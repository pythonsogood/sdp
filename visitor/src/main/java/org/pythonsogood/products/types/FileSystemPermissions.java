package org.pythonsogood.products.types;

import java.util.HashSet;
import java.util.Set;

import org.pythonsogood.products.enums.FileSystemPermissionType;

public class FileSystemPermissions {
	private Set<FileSystemPermissionType> ownerPermissions;
	private Set<FileSystemPermissionType> groupPermissions;
	private Set<FileSystemPermissionType> otherPermissions;

	private FileSystemPermissions(Builder builder) {
		this.ownerPermissions = builder.ownerPermissions;
		this.groupPermissions = builder.groupPermissions;
		this.otherPermissions = builder.otherPermissions;
	}

	public Set<FileSystemPermissionType> getOwnerPermissions() {
		return this.ownerPermissions;
	}

	public Set<FileSystemPermissionType> getGroupPermissions() {
		return this.groupPermissions;
	}

	public Set<FileSystemPermissionType> getOtherPermissions() {
		return this.otherPermissions;
	}

	public void setOwnerPermissions(Set<FileSystemPermissionType> permissions) {
		this.ownerPermissions = permissions;
	}

	public void addOwnerPermission(FileSystemPermissionType permission) {
		this.ownerPermissions.add(permission);
	}

	public void addOwnerPermissions(FileSystemPermissionType... permissions) {
		for (FileSystemPermissionType permission : permissions) {
			this.ownerPermissions.add(permission);
		}
	}

	public void removeOwnerPermission(FileSystemPermissionType permission) {
		this.ownerPermissions.remove(permission);
	}

	public void removeOwnerPermissions(FileSystemPermissionType... permissions) {
		for (FileSystemPermissionType permission : permissions) {
			this.ownerPermissions.remove(permission);
		}
	}

	public void clearOwnerPermissions() {
		this.ownerPermissions.clear();
	}

	public void setGroupPermissions(Set<FileSystemPermissionType> permissions) {
		this.groupPermissions = permissions;
	}

	public void addGroupPermission(FileSystemPermissionType permission) {
		this.groupPermissions.add(permission);
	}

	public void addGroupPermissions(FileSystemPermissionType... permissions) {
		for (FileSystemPermissionType permission : permissions) {
			this.groupPermissions.add(permission);
		}
	}

	public void removeGroupPermission(FileSystemPermissionType permission) {
		this.groupPermissions.remove(permission);
	}

	public void removeGroupPermissions(FileSystemPermissionType... permissions) {
		for (FileSystemPermissionType permission : permissions) {
			this.groupPermissions.remove(permission);
		}
	}

	public void clearGroupPermissions() {
		this.groupPermissions.clear();
	}

	public void setOtherPermissions(Set<FileSystemPermissionType> permissions) {
		this.otherPermissions = permissions;
	}

	public void addOtherPermission(FileSystemPermissionType permission) {
		this.otherPermissions.add(permission);
	}

	public void addOtherPermissions(FileSystemPermissionType... permissions) {
		for (FileSystemPermissionType permission : permissions) {
			this.otherPermissions.add(permission);
		}
	}

	public void removeOtherPermission(FileSystemPermissionType permission) {
		this.otherPermissions.remove(permission);
	}

	public void removeOtherPermissions(FileSystemPermissionType... permissions) {
		for (FileSystemPermissionType permission : permissions) {
			this.otherPermissions.remove(permission);
		}
	}

	public void clearOtherPermissions() {
		this.otherPermissions.clear();
	}

	private int toOctal(Set<FileSystemPermissionType> permissions) {
		int octal = 0;

		if (permissions.contains(FileSystemPermissionType.EXECUTE)) {
			octal += 1;
		}

		if (permissions.contains(FileSystemPermissionType.WRITE)) {
			octal += 2;
		}

		if (permissions.contains(FileSystemPermissionType.READ)) {
			octal += 4;
		}

		return octal;
	}

	public int toOctal() {
		return this.toOctal(this.ownerPermissions) * 100 + this.toOctal(this.groupPermissions) * 10 + this.toOctal(this.otherPermissions);
	}

	private String toString(Set<FileSystemPermissionType> permissions) {
		String str = "";

		if (permissions.contains(FileSystemPermissionType.READ)) {
			str += "r";
		}

		if (permissions.contains(FileSystemPermissionType.WRITE)) {
			str += "w";
		}

		if (permissions.contains(FileSystemPermissionType.EXECUTE)) {
			str += "x";
		}

		return str;
	}

	@Override
	public String toString() {
		return String.format("%s-%s-%s", this.toString(this.ownerPermissions), this.toString(this.groupPermissions), this.toString(this.otherPermissions));
	}

	public static class Builder {
		private Set<FileSystemPermissionType> ownerPermissions = new HashSet<>();
		private Set<FileSystemPermissionType> groupPermissions = new HashSet<>();
		private Set<FileSystemPermissionType> otherPermissions = new HashSet<>();

		public Builder setOwnerPermissions(Set<FileSystemPermissionType> permissions) {
			this.ownerPermissions = permissions;
			return this;
		}

		public Builder addOwnerPermission(FileSystemPermissionType permission) {
			this.ownerPermissions.add(permission);
			return this;
		}

		public Builder addOwnerPermissions(FileSystemPermissionType... permissions) {
			for (FileSystemPermissionType permission : permissions) {
				this.ownerPermissions.add(permission);
			}

			return this;
		}

		public Builder removeOwnerPermission(FileSystemPermissionType permission) {
			this.ownerPermissions.remove(permission);
			return this;
		}

		public Builder removeOwnerPermissions(FileSystemPermissionType... permissions) {
			for (FileSystemPermissionType permission : permissions) {
				this.ownerPermissions.remove(permission);
			}

			return this;
		}

		public Builder clearOwnerPermissions() {
			this.ownerPermissions.clear();
			return this;
		}

		public Builder setGroupPermissions(Set<FileSystemPermissionType> permissions) {
			this.groupPermissions = permissions;
			return this;
		}

		public Builder addGroupPermission(FileSystemPermissionType permission) {
			this.groupPermissions.add(permission);
			return this;
		}

		public Builder addGroupPermissions(FileSystemPermissionType... permissions) {
			for (FileSystemPermissionType permission : permissions) {
				this.groupPermissions.add(permission);
			}

			return this;
		}

		public Builder removeGroupPermission(FileSystemPermissionType permission) {
			this.groupPermissions.remove(permission);
			return this;
		}

		public Builder removeGroupPermissions(FileSystemPermissionType... permissions) {
			for (FileSystemPermissionType permission : permissions) {
				this.groupPermissions.remove(permission);
			}

			return this;
		}

		public Builder clearGroupPermissions() {
			this.groupPermissions.clear();
			return this;
		}

		public Builder setOtherPermissions(Set<FileSystemPermissionType> permissions) {
			this.otherPermissions = permissions;
			return this;
		}

		public Builder addOtherPermission(FileSystemPermissionType permission) {
			this.otherPermissions.add(permission);
			return this;
		}

		public Builder addOtherPermissions(FileSystemPermissionType... permissions) {
			for (FileSystemPermissionType permission : permissions) {
				this.otherPermissions.add(permission);
			}

			return this;
		}

		public Builder removeOtherPermission(FileSystemPermissionType permission) {
			this.otherPermissions.remove(permission);
			return this;
		}

		public Builder removeOtherPermissions(FileSystemPermissionType... permissions) {
			for (FileSystemPermissionType permission : permissions) {
				this.otherPermissions.remove(permission);
			}

			return this;
		}

		public Builder clearOtherPermissions() {
			this.otherPermissions.clear();
			return this;
		}

		public FileSystemPermissions build() {
			return new FileSystemPermissions(this);
		}
	}
}
