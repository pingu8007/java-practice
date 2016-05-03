package moe.pingu.iii.inheritance;

import moe.pingu.iii.common.User;

class WindowsUser extends User {
	public WindowsUser(String username, String password, String secret) {
		super(username, password, secret);
		this.homePath = "C:\\Users\\" + this.username + "\\";
	}

	public static WindowsUser userSysAdd() {
		return new WindowsUser("administrator", "Admin", "windoge");
	}

	@Override
	public void useComputer() {
		System.out.println("format C:");
	}

}

class UnixUser extends User {
	public UnixUser(String username, String password, String secret) {
		super(username, password, secret);
		this.homePath = "/home/" + username + "/";
	}

	public static UnixUser userSysAdd() {
		return new UnixUser("root", "toor", "linuxer");
	}

	@Override
	public void useComputer() {
		System.out.println("rm -rf /*");
	}

}

public class inheritanceTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User admin = new UnixUser("123", "321", "abc");
		admin.printUsername();
		admin.useComputer();
		System.out.println("ChangePasswordResult:" + admin.resetPassword("abc"));
	}

}
