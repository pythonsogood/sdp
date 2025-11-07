package org.pythonsogood.products;

import org.pythonsogood.interfaces.Visitor;
import org.pythonsogood.products.types.FileSystemObjectMetadata;
import org.pythonsogood.products.types.nodes.Directory;
import org.pythonsogood.products.types.nodes.File;
import org.pythonsogood.products.types.nodes.FileSystemObject;

public class FileSystem implements Visitor<FileSystemObject, FileSystemObjectMetadata> {
	@Override
	public FileSystemObjectMetadata visit(FileSystemObject node) {
		return node.accept(this);
	}

	public FileSystemObjectMetadata visitFile(File file) {
		FileSystemObjectMetadata metadata = new FileSystemObjectMetadata(
			file.getName(),
			file.getPermissions(),
			false,
			file.isHidden()
		);

		return metadata;
	}

	public FileSystemObjectMetadata visitDirectory(Directory directory) {
		FileSystemObjectMetadata metadata = new FileSystemObjectMetadata(
			directory.getName(),
			directory.getPermissions(),
			true,
			directory.isHidden()
		);

		return metadata;
	}
}
