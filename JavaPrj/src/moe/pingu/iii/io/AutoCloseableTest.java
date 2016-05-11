package moe.pingu.iii.io;

public class AutoCloseableTest implements AutoCloseable {

	public static void main(String[] args) {
		try (AutoCloseableTest res = new AutoCloseableTest()) {
			System.out.println("Resource opened.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		System.out.println("Resource closed.");
	}

}
