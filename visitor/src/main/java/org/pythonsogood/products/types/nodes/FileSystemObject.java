package org.pythonsogood.products.types.nodes;

import org.pythonsogood.interfaces.Element;
import org.pythonsogood.interfaces.Visitor;
import org.pythonsogood.products.types.FileSystemObjectMetadata;
import org.pythonsogood.products.types.FileSystemPermissions;

public abstract class FileSystemObject implements Element<FileSystemObject, FileSystemObjectMetadata> {
	private String name;
	private Directory parent;
	private FileSystemPermissions permissions;
	private boolean hidden;

	protected FileSystemObject(AbstractBuilder builder) {
		this.name = builder.name;
		this.parent = builder.parent;
		this.permissions = builder.permissions;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Directory getParent() {
		return this.parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public FileSystemPermissions getPermissions() {
		return this.permissions;
	}

	public void setPermissions(FileSystemPermissions permissions) {
		this.permissions = permissions;
	}

	public boolean isHidden() {
		return this.hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getFullName() {
		return this.getName();
	}

	public String getPath() {
		Directory parent = this.getParent();
		if (parent == null) {
			return Directory.SEPARATOR;
		}

		String path = "";

		while (parent != null) {
			path += String.format("%s%s", Directory.SEPARATOR, parent.getName());
		}

		return path;
	}

	public String getPathWithFullName() {
		return this.parent != null ? String.format("%s%s%s", this.getPath(), Directory.SEPARATOR, this.getFullName()) : String.format("%s%s", Directory.SEPARATOR, this.getFullName());
	}

	protected String getKey() {
		return this.getPathWithFullName();
	}

	protected String getKey(Directory newParent) {
		if (newParent == null) {
			return String.format("%s%s", Directory.SEPARATOR, this.getFullName());
		}

		return String.format("%s%s%s", newParent.getPathWithFullName(), Directory.SEPARATOR, this.getFullName());
	}

	protected String getKey(String newFullName) {
		if (this.getParent() == null) {
			return String.format("%s%s", Directory.SEPARATOR, newFullName);
		}

		return String.format("%s%s%s", this.getPath(), Directory.SEPARATOR, newFullName);
	}

	@Override
	public abstract FileSystemObjectMetadata accept(Visitor<FileSystemObject, FileSystemObjectMetadata> visitor);

	public static abstract class AbstractBuilder<T> {
		protected String name;
		protected Directory parent;
		protected FileSystemPermissions permissions;
		protected boolean hidden;

		public AbstractBuilder<T> setName(String name) {
			this.name = name;
			return this;
		}

		public AbstractBuilder<T> setParent(Directory parent) {
			this.parent = parent;
			return this;
		}

		public AbstractBuilder<T> setPermissions(FileSystemPermissions permissions) {
			this.permissions = permissions;
			return this;
		}

		public AbstractBuilder<T> setHidden(boolean hidden) {
			this.hidden = hidden;
			return this;
		}

		public abstract T build();
	}
}
