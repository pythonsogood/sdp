package org.pythonsogood.products.types;

public class FileSystemObjectMetadata {
	public final String name;
	public final FileSystemPermissions permissions;
	public final boolean isDirectory;
	public final boolean hidden;

	public FileSystemObjectMetadata(String name, FileSystemPermissions permissions, boolean isDirectory, boolean hidden) {
		this.name = name;
		this.permissions = permissions;
		this.isDirectory = isDirectory;
		this.hidden = hidden;
	}

	@Override
	public String toString() {
		if (this.isDirectory) {
			return String.format("d %s %s", this.permissions.toString(), this.name);
		}

		return String.format("%s %s", this.permissions.toString(), this.name);
	}
}
