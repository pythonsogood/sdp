package org.pythonsogood.products.types;

import org.pythonsogood.interfaces.Visitor;

public class Directory extends Node {
	public Directory(Builder builder) {
		super(builder);
	}

	@Override
	public NodeMetadata accept(Visitor<Node, NodeMetadata> visitor) {
		if (visitor instanceof Archive archive) {
			return archive.visitDirectory(this);
		}

		throw new RuntimeException("Not implemented");
	}

	public static class Builder extends Node.AbstractBuilder<Directory> {
		public Directory build() {
			if (!this.validate()) {
				throw new RuntimeException("Directory must have a name!");
			}

			return new Directory(this);
		}
	}
}
