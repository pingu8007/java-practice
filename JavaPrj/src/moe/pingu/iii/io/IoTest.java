package moe.pingu.iii.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// File target = new File("C:\\temp\\hello.txt");

		// System.out.println(target.exists());
		// if (target.exists() && target.isFile()) {
		// System.out.println("Say goodbye to your file :D");
		// target.delete();
		// }
		// System.out.println(target.exists());

		FileInputStream fi = new FileInputStream("c:/temp/hello.txt");
		FileOutputStream fo = new FileOutputStream("c:/temp/copy.txt", true);
		int read;
		while ((read = fi.read()) != -1) {
			System.out.print((char) read + " ");
			fo.write(read);
		}
		fo.close();
		fi.close();

	}

}
