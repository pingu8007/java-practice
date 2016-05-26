package moe.pingu.iii.shared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Str {
	private final static char[] idMap = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'W', 'Z', 'I', 'O' };
	private final static int idMapShift = 10;
	static {
	}

	public static void main(String[] args) {
		short i = 0;
		while (++i > 0) {
			String id = genId(Character.toString((char) Calc.random(65, 90)), Integer.toString(Calc.random(1, 2)));
			System.out.println("\"" + id + "\"" + " is " + (checkId(id) ? "valid." : "invalid."));
		}
	}

	// Rewrite using autoClosable.
	public static void main01(String[] args) {
		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {
			String id = " ";
			System.out.println("Enter your ID:");
			while (!(id = br.readLine().trim()).isEmpty())
				System.out.println("\"" + id + "\"" + " is " + (checkId(id) ? "valid." : "invalid."));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Old method, without autoClosable.
	public static void main02(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String id = " ";
			System.out.println("Enter your ID:");
			while (!(id = br.readLine().trim()).isEmpty())
				System.out.println("\"" + id + "\"" + " is " + (checkId(id) ? "valid." : "invalid."));
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (isr != null)
					isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean checkId(String id) {
		if (!id.toUpperCase().matches("^[A-Z][12][0-9]{8}$"))
			return false;

		char[] idchar = " ".concat(id).toUpperCase().toCharArray();
		int sum = 0;

		for (int i = 0; i < idMap.length; i++)
			sum = (idchar[1] == idMap[i]) ? i + idMapShift : sum;
		idchar = Integer.toString(sum).concat(id.substring(1)).toCharArray();

		return (idchar[idchar.length - 1] == idHash(idchar));
	}

	public static String genId(String city, String gender) {
		if (!(city = city.trim().toUpperCase()).matches("^[A-Z]$") || !(gender = gender.trim()).matches("^[12]$"))
			return "INVALID ARGS";
//		city = (city = city.trim().toUpperCase()).matches("^[A-Z]$") ? city	: Character.toString((char) Calc.random(65, 90));
//		gender = (gender = gender.trim()).matches("^[12]$") ? gender : Integer.toString(Calc.random(1, 2));

		String serial = String.format("%1$07d", Calc.random(1, 9999999));
		char[] idchar = " ".concat(city).toCharArray();
		int sum = 0;

		for (int i = 0; i < idMap.length; i++)
			sum = (idchar[1] == idMap[i]) ? i + idMapShift : sum;
		idchar = Integer.toString(sum).concat(gender).concat(serial).concat(" ").toCharArray();
		idchar[idchar.length - 1] = idHash(idchar);

		serial = city;
		for (int i = 2; i < idchar.length; i++)
			serial = serial.concat(Character.toString(idchar[i]));

		return serial;
	}

	private static char idHash(char[] id) {
		int sum = id[0] - 48;
		for (int i = 1; i < id.length - 1; i++)
			sum = sum + ((id[i] - 48) * (10 - i));
		return (char) (((10 - (sum % 10)) % 10) + 48);
	}

}
