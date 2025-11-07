package org.pythonsogood.products.types.nodes;

import java.util.HashMap;
import java.util.Map;

import org.pythonsogood.interfaces.Visitor;
import org.pythonsogood.products.FileSystem;
import org.pythonsogood.products.types.FileSystemObjectMetadata;

public class Directory extends FileSystemObject {
	public static String SEPARATOR = "/";
	private static Map<String, Directory> instances = new HashMap<>();

	public Directory(Builder builder) {
		super(builder);
	}

	@Override
	public void setName(String name) {
		String oldKey = this.getPathWithFullName();
		String key = this.getParent() != null ? String.format("%s%s%s", this.getPath(), Directory.SEPARATOR, name) : String.format("%s%s", Directory.SEPARATOR, name);

		if (Directory.instances.containsKey(key)) {
			throw new RuntimeException("Directory with that name already exists here!");
		}

		Directory.instances.remove(oldKey);

		super.setName(name);

		Directory.instances.put(key, this);
	}

	@Override
	public void setParent(Directory parent) {
		String oldKey = this.getPathWithFullName();
		String key = parent != null ? String.format("%s%s%s", parent.getPathWithFullName(), Directory.SEPARATOR, this.getName()) : String.format("%s%s", Directory.SEPARATOR, this.getName());

		if (Directory.instances.containsKey(key)) {
			throw new RuntimeException("Directory with that name already exists at parent!");
		}

		Directory.instances.remove(oldKey);

		super.setParent(parent);

		Directory.instances.put(key, this);
	}

	@Override
	public FileSystemObjectMetadata accept(Visitor<FileSystemObject, FileSystemObjectMetadata> visitor) {
		if (visitor instanceof FileSystem fs) {
			return fs.visitDirectory(this);
		}

		throw new RuntimeException("Not implemented");
	}

	public static class Builder extends FileSystemObject.AbstractBuilder<Directory> {
		public Directory build() {
			String fullName = this.name;
			String key = this.parent != null ? String.format("%s%s%s", this.parent.getPathWithFullName(), Directory.SEPARATOR, fullName) : String.format("%s%s", Directory.SEPARATOR, fullName);

			if (Directory.instances.containsKey(key)) {
				return Directory.instances.get(key);
			}

			Directory directory = new Directory(this);
			Directory.instances.put(key, directory);

			return directory;
		}
	}
}
