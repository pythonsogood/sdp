package org.pythonsogood.products.types;

import java.util.HashSet;
import java.util.Set;

import org.pythonsogood.products.enums.NodePermission;

public class NodePermissions {
	private Set<NodePermission> ownerPermissions;
	private Set<NodePermission> groupPermissions;
	private Set<NodePermission> otherPermissions;

	private NodePermissions(Builder builder) {
		this.ownerPermissions = builder.ownerPermissions;
		this.groupPermissions = builder.groupPermissions;
		this.otherPermissions = builder.otherPermissions;
	}

	public Set<NodePermission> getOwnerPermissions() {
		return this.ownerPermissions;
	}

	public Set<NodePermission> getGroupPermissions() {
		return this.groupPermissions;
	}

	public Set<NodePermission> getOtherPermissions() {
		return this.otherPermissions;
	}

	public void setOwnerPermissions(Set<NodePermission> permissions) {
		this.ownerPermissions = permissions;
	}

	public void addOwnerPermissions(NodePermission... permissions) {
		for (NodePermission permission : permissions) {
			this.ownerPermissions.add(permission);
		}
	}

	public void removeOwnerPermissions(NodePermission... permissions) {
		for (NodePermission permission : permissions) {
			this.ownerPermissions.remove(permission);
		}
	}

	public void clearOwnerPermissions() {
		this.ownerPermissions.clear();
	}

	public void setGroupPermissions(Set<NodePermission> permissions) {
		this.groupPermissions = permissions;
	}

	public void addGroupPermissions(NodePermission... permissions) {
		for (NodePermission permission : permissions) {
			this.groupPermissions.add(permission);
		}
	}

	public void removeGroupPermissions(NodePermission... permissions) {
		for (NodePermission permission : permissions) {
			this.groupPermissions.remove(permission);
		}
	}

	public void clearGroupPermissions() {
		this.groupPermissions.clear();
	}

	public void setOtherPermissions(Set<NodePermission> permissions) {
		this.otherPermissions = permissions;
	}

	public void addOtherPermissions(NodePermission... permissions) {
		for (NodePermission permission : permissions) {
			this.otherPermissions.add(permission);
		}
	}

	public void removeOtherPermissions(NodePermission... permissions) {
		for (NodePermission permission : permissions) {
			this.otherPermissions.remove(permission);
		}
	}

	public void clearOtherPermissions() {
		this.otherPermissions.clear();
	}

	private int toOctal(Set<NodePermission> permissions) {
		int octal = 0;

		if (permissions.contains(NodePermission.EXECUTE)) {
			octal += 1;
		}

		if (permissions.contains(NodePermission.WRITE)) {
			octal += 2;
		}

		if (permissions.contains(NodePermission.READ)) {
			octal += 4;
		}

		return octal;
	}

	public int toOctal() {
		return this.toOctal(this.ownerPermissions) * 100 + this.toOctal(this.groupPermissions) * 10 + this.toOctal(this.otherPermissions);
	}

	private String toString(Set<NodePermission> permissions) {
		String str = "";

		if (permissions.contains(NodePermission.READ)) {
			str += "r";
		} else {
			str += "-";
		}

		if (permissions.contains(NodePermission.WRITE)) {
			str += "w";
		} else {
			str += "-";
		}

		if (permissions.contains(NodePermission.EXECUTE)) {
			str += "x";
		} else {
			str += "-";
		}

		return str;
	}

	@Override
	public String toString() {
		return String.format("%s-%s-%s", this.toString(this.ownerPermissions), this.toString(this.groupPermissions), this.toString(this.otherPermissions));
	}

	public static class Builder {
		private Set<NodePermission> ownerPermissions = new HashSet<>();
		private Set<NodePermission> groupPermissions = new HashSet<>();
		private Set<NodePermission> otherPermissions = new HashSet<>();

		public Builder setOwnerPermissions(Set<NodePermission> permissions) {
			this.ownerPermissions = permissions;
			return this;
		}

		public Builder addOwnerPermissions(NodePermission... permissions) {
			for (NodePermission permission : permissions) {
				this.ownerPermissions.add(permission);
			}

			return this;
		}

		public Builder removeOwnerPermissions(NodePermission... permissions) {
			for (NodePermission permission : permissions) {
				this.ownerPermissions.remove(permission);
			}

			return this;
		}

		public Builder clearOwnerPermissions() {
			this.ownerPermissions.clear();
			return this;
		}

		public Builder setGroupPermissions(Set<NodePermission> permissions) {
			this.groupPermissions = permissions;
			return this;
		}

		public Builder addGroupPermissions(NodePermission... permissions) {
			for (NodePermission permission : permissions) {
				this.groupPermissions.add(permission);
			}

			return this;
		}

		public Builder removeGroupPermissions(NodePermission... permissions) {
			for (NodePermission permission : permissions) {
				this.groupPermissions.remove(permission);
			}

			return this;
		}

		public Builder clearGroupPermissions() {
			this.groupPermissions.clear();
			return this;
		}

		public Builder setOtherPermissions(Set<NodePermission> permissions) {
			this.otherPermissions = permissions;
			return this;
		}

		public Builder addOtherPermissions(NodePermission... permissions) {
			for (NodePermission permission : permissions) {
				this.otherPermissions.add(permission);
			}

			return this;
		}

		public Builder removeOtherPermissions(NodePermission... permissions) {
			for (NodePermission permission : permissions) {
				this.otherPermissions.remove(permission);
			}

			return this;
		}

		public Builder clearOtherPermissions() {
			this.otherPermissions.clear();
			return this;
		}

		public NodePermissions build() {
			return new NodePermissions(this);
		}
	}
}
