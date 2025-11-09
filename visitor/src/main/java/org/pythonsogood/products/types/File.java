package org.pythonsogood.products.types;

import org.pythonsogood.interfaces.Visitor;

public class File extends Node {
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

	protected void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public NodeMetadata accept(Visitor<Node, NodeMetadata> visitor) {
		if (visitor instanceof Archive archive) {
			return archive.visitFile(this);
		}

		throw new RuntimeException("Not implemented");
	}

	public static class Builder extends Node.AbstractBuilder<File> {
		private String extension = "";

		public Builder setExtension(String extension) {
			this.extension = extension;
			return this;
		}

		public File build() {
			if (!this.validate()) {
				throw new RuntimeException("File must have a name!");
			}

			return new File(this);
		}
	}
}
