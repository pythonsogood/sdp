package org.pythonsogood.products;

import org.pythonsogood.interfaces.Visitor;
import org.pythonsogood.products.types.FileSystemObject;

public class FileSystem implements Visitor<FileSystemObject> {
	@Override
	public void visit(FileSystemObject node) {}
}
