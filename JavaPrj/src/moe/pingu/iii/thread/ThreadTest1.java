package moe.pingu.iii.thread;

public class ThreadTest1 implements Runnable {
	public static void main(String[] args) {
		ThreadTest1 core = new ThreadTest1();
		Thread thread1 = new Thread(core);
		Thread thread2 = new Thread(core);
		Thread thread3 = new Thread(core);
		Thread thread4 = new Thread(core);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread-C msg");
//		for (int i = 0; i < 6; i++) {
//			// for (int j = 0; j <i;j++){
//			// System.out.print(" ");
//			// }
//			System.out.println("Thread-C msg " + i);
//			try {
//				Thread.sleep((long) (Math.random() * 1600));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			// for (int j = 0; j <i;j++){
			// System.out.print(" ");
			// }
			System.out.println(Thread.currentThread().getName() + " msg " + i);
			try {
				Thread.sleep((long) (Math.random() * 1600));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
