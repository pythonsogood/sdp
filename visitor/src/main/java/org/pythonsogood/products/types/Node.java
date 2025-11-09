package org.pythonsogood.products.types;

import org.pythonsogood.interfaces.Element;
import org.pythonsogood.interfaces.Visitor;

public abstract class Node implements Element<Node, NodeMetadata> {
	private String name;
	private Directory parent;
	private NodePermissions permissions;

	protected Node(AbstractBuilder builder) {
		this.name = builder.name;
		this.parent = builder.parent;
		this.permissions = builder.permissions;
	}

	public String getName() {
		return this.name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public Directory getParent() {
		return this.parent;
	}

	protected void setParent(Directory parent) {
		this.parent = parent;
	}

	public NodePermissions getPermissions() {
		return this.permissions;
	}

	public void setPermissions(NodePermissions permissions) {
		this.permissions = permissions;
	}

	public String getFullName() {
		return this.getName();
	}

	public String getPath() {
		Directory parent = this.getParent();
		if (parent == null) {
			return "/";
		}

		String path = "";

		while (parent != null) {
			path += String.format("/%s", parent.getName());
			parent = parent.getParent();
		}

		return path;
	}

	public String getPathWithFullName() {
		return this.parent != null ? String.format("%s/%s", this.getPath(), this.getFullName()) : String.format("/%s", this.getFullName());
	}

	public String getKey() {
		return this.getPathWithFullName();
	}

	public String getKey(Directory newParent) {
		if (newParent == null) {
			return String.format("/%s", this.getFullName());
		}

		return String.format("%s/%s", newParent.getPathWithFullName(), this.getFullName());
	}

	public String getKey(String newFullName) {
		if (this.getParent() == null) {
			return String.format("/%s", newFullName);
		}

		return String.format("%s/%s", this.getPath(), newFullName);
	}

	@Override
	public abstract NodeMetadata accept(Visitor<Node, NodeMetadata> visitor);

	public static abstract class AbstractBuilder<T extends Node> {
		protected String name;
		protected Directory parent;
		protected NodePermissions permissions = new NodePermissions.Builder().build();

		public AbstractBuilder<T> setName(String name) {
			if (name.contains("/")) {
				throw new RuntimeException("Name cannot contain / character!");
			}

			this.name = name;
			return this;
		}

		public AbstractBuilder<T> setParent(Directory parent) {
			this.parent = parent;
			return this;
		}

		public AbstractBuilder<T> setPermissions(NodePermissions permissions) {
			this.permissions = permissions;
			return this;
		}

		public boolean validate() {
			return this.name != null;
		}

		public abstract T build();
	}
}
