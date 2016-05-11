package moe.pingu.iii.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeTest implements FileVisitor<Path> {
	private byte depth = 0;

	public static void main(String[] args) {
		try {
			Files.walkFileTree(Paths.get("C:/temp/bin"), new WalkFileTreeTest());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("----------------");
		System.out.println("Walker finished.");
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		for (byte i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.println("" + dir.getFileName() + "/");
		this.depth++;
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		for (byte i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.println("" + file.getFileName());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		this.depth--;
		return FileVisitResult.CONTINUE;
	}

}
