package org.pythonsogood;

import org.pythonsogood.products.TarArchive;
import org.pythonsogood.products.enums.NodePermission;
import org.pythonsogood.products.types.Directory;
import org.pythonsogood.products.types.File;
import org.pythonsogood.products.types.NodePermissions;

public class Main {
    public static void main(String[] args) {
		TarArchive tarArchive = new TarArchive();

		Directory imagesDirectory = new Directory.Builder()
													.setName("images")
													.setPermissions(new NodePermissions.Builder().addGroupPermissions(NodePermission.READ).build())
													.build();
		tarArchive.addNode(imagesDirectory);

		File fooTxt = new File.Builder()
								.setName("foo.txt")
								.setPermissions(new NodePermissions.Builder().addOwnerPermissions(NodePermission.READ, NodePermission.WRITE).build())
								.build();
		tarArchive.addNode(fooTxt);

		File catPng = new File.Builder()
								.setName("cat.png")
								.setParent(imagesDirectory)
								.setPermissions(new NodePermissions.Builder().addGroupPermissions(NodePermission.READ).build())
								.build();
		tarArchive.addNode(catPng);

		System.out.println(tarArchive.listDir());
    }
}