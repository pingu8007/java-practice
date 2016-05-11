package moe.pingu.iii.thread;

class MazeGame {
	private int x = 1, y = 1;

	public void setPosition(int x, int y) {
		synchronized (this) {
			this.x = x;
			this.y = y;
			System.out.println("(x,y) = (" + x + "," + y + ")");
			this.notify();
		}
	}

	public void checkStatus() {
		synchronized (this) {
			try {
				this.wait();
//				System.out.println("checking...");
				if (x == 0 && y == 0) {
					exitGame();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void exitGame() {
		System.out.println("To be continued...");
		System.exit(0);
	}
}

class Heroine implements Runnable {
	private MazeGame game;

	public Heroine(MazeGame game) {
		this.game = game;
	}

	@Override
	public void run() {
		while (true) {
			game.setPosition((int) (Math.random() * 8), (int) (Math.random() * 8));
			try {
				Thread.sleep((long) (Math.random() * 800));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class GameOperator implements Runnable {
	private MazeGame game;

	public GameOperator(MazeGame game) {
		this.game = game;
	}

	@Override
	public void run() {
		while (true) {
			game.checkStatus();
			try {
				Thread.sleep((long) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class GameLoader {
	public static void main(String[] args) {

		MazeGame table = new MazeGame();
		Thread thread1 = new Thread(new Heroine(table));
		Thread thread2 = new Thread(new GameOperator(table));

		thread1.start();
		thread2.start();

	}
}