package org.pythonsogood.products.types;

import org.pythonsogood.interfaces.Element;
import org.pythonsogood.interfaces.Visitor;

public abstract class FileSystemObject implements Element {
	@Override
	public void accept(Visitor<FileSystemObject> visitor) {
	}
}
