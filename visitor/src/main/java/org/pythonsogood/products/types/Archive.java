package org.pythonsogood.products.types;

import java.util.HashMap;
import java.util.Map;

import org.pythonsogood.interfaces.Visitor;

public class Archive implements Visitor<Node, NodeMetadata> {
	private Map<String, Node> nodes = new HashMap<>();

	@Override
	public NodeMetadata visit(Node node) {
		return node.accept(this);
	}

	public NodeMetadata visitFile(File file) {
		NodeMetadata metadata = new NodeMetadata(
			file.getPathWithFullName(),
			file.getPermissions(),
			false
		);

		return metadata;
	}

	public NodeMetadata visitDirectory(Directory directory) {
		NodeMetadata metadata = new NodeMetadata(
			directory.getPathWithFullName(),
			directory.getPermissions(),
			true
		);

		return metadata;
	}

	public void addNode(Node node) {
		String nodeKey = node.getKey();

		if (this.nodes.containsKey(nodeKey)) {
			throw new RuntimeException("Node with that name already exists here!");
		}

		this.nodes.put(nodeKey, node);
	}

	public void renameNode(Node node) {
		String oldNodeKey = node.getKey();
		String newNodeKey = node.getKey(node.getParent());

		if (this.nodes.containsKey(newNodeKey)) {
			throw new RuntimeException("Node with that name already exists here!");
		}

		this.nodes.remove(oldNodeKey);
		this.nodes.put(newNodeKey, node);
	}

	public void removeNode(Node node) {
		this.nodes.remove(node.getKey());
	}

	public void setNodeParent(Node node, Directory parent) {
		String oldNodeKey = node.getKey();
		String newNodeKey = node.getKey(parent);

		if (this.nodes.containsKey(newNodeKey)) {
			throw new RuntimeException("Node with that name already exists here!");
		}

		this.nodes.remove(oldNodeKey);
		this.nodes.put(newNodeKey, node);
		node.setParent(parent);
	}

	public void setFileExtension(File file, String extension) {
		String oldFileKey = file.getKey();
		String newFileKey = file.getKey(extension != "" ? String.format("%s.%s", file.getName(), extension) : file.getName());

		if (this.nodes.containsKey(newFileKey)) {
			throw new RuntimeException("File with that name already exists here!");
		}

		this.nodes.remove(oldFileKey);
		this.nodes.put(newFileKey, file);
		file.setExtension(extension);
	}

	public String listDir() {
		String list = "Listing archive...\n";

		for (Node node : this.nodes.values()) {
			NodeMetadata metadata = this.visit(node);
			list += String.format("%s\n", metadata.toString());
		}

		list += String.format("Total: %d entries", this.nodes.size());

		return list;
	}
}
