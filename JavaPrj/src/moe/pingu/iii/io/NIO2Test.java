package moe.pingu.iii.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileAttribute;

public class NIO2Test {

	public static void main(String[] args) {
		Path path = Paths.get("c:/temp/hello.txt");
		// System.out.println(path.getFileSystem().getRootDirectories());
		// System.out.println(path.getFileName());
		// System.out.println(path.getParent());
		// System.out.println(path.getRoot());

		if (Files.exists(path)) {
			try {
				BasicFileAttributes attrBasic = Files.readAttributes(path, BasicFileAttributes.class);
				System.out.println(attrBasic.size());
				System.out.println(attrBasic.fileKey());
				System.out.println(attrBasic.isRegularFile());
				System.out.println(attrBasic.isDirectory());
				System.out.println(attrBasic.isSymbolicLink());
				System.out.println(attrBasic.lastAccessTime());
				System.out.println(attrBasic.creationTime());

				DosFileAttributes attrDos = Files.readAttributes(path, DosFileAttributes.class);
				System.out.println("DOS Archive :" + attrDos.isArchive());
				System.out.println("DOS Hidden  :" + attrDos.isHidden());
				System.out.println("DOS ReadOnly:" + attrDos.isReadOnly());
				System.out.println("DOS System  :" + attrDos.isSystem());
								
				
//				Files.copy(path, Paths.get("c:/temp/copy.txt"), StandardCopyOption.REPLACE_EXISTING,
//						StandardCopyOption.COPY_ATTRIBUTES);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
