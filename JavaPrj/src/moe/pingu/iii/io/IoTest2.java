package moe.pingu.iii.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IoTest2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new
		// FileWriter("c:/temp/save.txt"));
		// BufferedWriter bw = new BufferedWriter(
		// new OutputStreamWriter(new FileOutputStream("c:/temp/save.txt"),
		// Charset.forName("Big5")));
		BufferedWriter bw = Files.newBufferedWriter(Paths.get("c:/temp/save.txt"), Charset.forName("UTF-8"));

		System.out.println("Type something:");
		String data;
		while ((data = br.readLine()) != null && !data.equalsIgnoreCase("<EOF>")) {
			bw.write(data);
			bw.newLine();
			System.out.println(data);
		}
		bw.close();
		br.close();
	}
}
