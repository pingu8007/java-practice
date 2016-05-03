package moe.pingu.iii.common;

/**
 * This is examples for Inheritance.
 * 
 * @author PinGu
 *
 */
public class User {

	protected String username = "";
	protected String password = "";
	protected String secret = "";
	protected String homePath = "";

	protected User(String username, String password, String secret) {
		// check username not empty
		if (checkUsername(username)) {
			this.username = username;
		}
		this.password = randomPassword();
		this.secret = secret;
	}

	// public static User userAdd() {
	// return new User("demo", "123456654321");
	// }

	private static boolean checkUsername(String username) {
		if (username.trim().length() == 0) {
			System.out.println("Username can't be empty.");
		}
		return true;
	}

	private static boolean checkPassword(String password) {
		if (password.trim().length() == 0) {
			System.out.println("Password can't be empty.");
		}
		return true;
	}

	public final void printUsername() {
		System.out.println(username);
	}

	private static String randomPassword() {
		return "      ";
	}

	public boolean setPassword(String password) {
		if (checkPassword(password)) {
			this.password = password;
			return true;
		} else {
			return false;
		}
	}

	public boolean resetPassword(String secret) {
		if (this.secret.equals(secret)) {
			this.password = randomPassword();
			return true;
		} else {
			return false;
		}
	}

	public void useComputer() {
		System.out.println("Hello, World!");
	}

}
