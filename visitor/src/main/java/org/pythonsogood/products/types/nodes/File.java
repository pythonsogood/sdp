package org.pythonsogood.products.types.nodes;

import java.util.HashMap;
import java.util.Map;

import org.pythonsogood.interfaces.Visitor;
import org.pythonsogood.products.FileSystem;
import org.pythonsogood.products.types.FileSystemObjectMetadata;

public class File extends FileSystemObject {
	private static Map<String, File> instances = new HashMap<>();

	private String extension;

	public File(Builder builder) {
		super(builder);

		this.extension = builder.extension;
	}

	public String getExtension() {
		return this.extension;
	}

	@Override
	public String getFullName() {
		return this.extension != "" ? String.format("%s.%s", this.getName(), this.getExtension()) : this.getName();
	}

	@Override
	public void setName(String name) {
		String oldKey = this.getKey();
		String key = this.getKey(this.extension != "" ? String.format("%s.%s", name, this.extension) : name);

		if (File.instances.containsKey(key)) {
			throw new RuntimeException("File with that name already exists here!");
		}

		File.instances.remove(oldKey);

		super.setName(name);

		File.instances.put(key, this);
	}

	public void setExtension(String extension) {
		String oldKey = this.getKey();
		String key = this.getKey(extension != "" ? String.format("%s.%s", this.getName(), extension) : this.getName());

		if (File.instances.containsKey(key)) {
			throw new RuntimeException("File with that name already exists here!");
		}

		File.instances.remove(oldKey);

		this.extension = extension;

		File.instances.put(key, this);
	}

	@Override
	public void setParent(Directory parent) {
		String oldKey = this.getKey();
		String key = this.getKey(parent);

		if (File.instances.containsKey(key)) {
			throw new RuntimeException("File with that name already exists at parent!");
		}

		File.instances.remove(oldKey);

		super.setParent(parent);

		File.instances.put(key, this);
	}

	@Override
	public FileSystemObjectMetadata accept(Visitor<FileSystemObject, FileSystemObjectMetadata> visitor) {
		if (visitor instanceof FileSystem fs) {
			return fs.visitFile(this);
		}

		throw new RuntimeException("Not implemented");
	}

	public static class Builder extends FileSystemObject.AbstractBuilder<File> {
		private String extension;

		public Builder setExtension(String extension) {
			this.extension = extension;
			return this;
		}

		public File build() {
			String fullName = this.extension != "" ? String.format("%s.%s", this.name, this.extension) : this.name;
			String key = this.parent != null ? String.format("%s%s%s", this.parent.getPathWithFullName(), Directory.SEPARATOR, fullName) : String.format("%s%s", Directory.SEPARATOR, fullName);

			if (File.instances.containsKey(key)) {
				return File.instances.get(key);
			}

			File file = new File(this);
			File.instances.put(key, file);

			return file;
		}
	}
}
