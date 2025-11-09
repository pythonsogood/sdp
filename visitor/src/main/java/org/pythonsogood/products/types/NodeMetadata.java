package org.pythonsogood.products.types;

public class NodeMetadata {
	public final String fullName;
	public final NodePermissions permissions;
	public final boolean isDirectory;

	public NodeMetadata(String fullName, NodePermissions permissions, boolean isDirectory) {
		this.fullName = fullName;
		this.permissions = permissions;
		this.isDirectory = isDirectory;
	}

	@Override
	public String toString() {
		if (this.isDirectory) {
			return String.format("d%s %s", this.permissions.toString(), this.fullName);
		}

		return String.format(" %s %s", this.permissions.toString(), this.fullName);
	}
}
