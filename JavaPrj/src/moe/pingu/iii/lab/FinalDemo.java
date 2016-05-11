package moe.pingu.iii.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

import moe.pingu.iii.shared.Array;

class Maze {
	private int[] pStart = { 0, 0 };
	private int[] pEnd;
	private ArrayList<ArrayList<Boolean>> maze = new ArrayList<ArrayList<Boolean>>();

	public Maze() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("input:");
			char[] in;
			int lines = 0;
			while ((in = br.readLine().toCharArray()) != null && in.length > 0) {
				// System.out.println("input length: " + in.length);
				ArrayList<Boolean> line = new ArrayList<Boolean>();
				int chars = 0;
				for (char c : in) {
					if (c == 'S') {
						pStart = new int[] { lines, chars };
					} else if (c == 'D') {
						pEnd = new int[] { lines, chars };
					}
					// c = '1';
					line.add(((c == '1' || c == ' ' || c == 'S' || c == 'D') ? true : false));
					chars++;
				}
				// System.out.println(line);
				maze.add(line);
				lines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printMaze() {
		for (ArrayList<Boolean> line : maze) {
			for (Boolean isRoad : line) {
				System.out.print((isRoad ? ' ' : '#'));
			}
			System.out.print('\n');
		}
	}

	/**
	 * @param x
	 *            Horizontal position. (column)
	 * @param y
	 *            Vertically position. (line)
	 * @return Order: [R, D, L, U]
	 */
	public boolean[] queryMap(int x, int y) {
		boolean[] mapBlock = { false, false, false, false };

		// U
		try {
			ArrayList<Boolean> line = this.maze.get(y - 1);
			try {
				mapBlock[3] = line.get(x);
			} catch (IndexOutOfBoundsException e) {
				mapBlock[3] = false;
			}
		} catch (IndexOutOfBoundsException e) {
			mapBlock[3] = false;
		}

		// center
		try {
			ArrayList<Boolean> line = this.maze.get(y);

			// R
			try {
				mapBlock[0] = line.get(x + 1);
			} catch (IndexOutOfBoundsException e) {
				mapBlock[0] = false;
			}

			// L
			try {
				mapBlock[2] = line.get(x - 1);
			} catch (IndexOutOfBoundsException e) {
				mapBlock[2] = false;
			}
		} catch (IndexOutOfBoundsException e) {
			mapBlock[0] = false;
			mapBlock[2] = false;
		}

		// D
		try {
			ArrayList<Boolean> line = this.maze.get(y + 1);
			try {
				mapBlock[1] = line.get(x);
			} catch (IndexOutOfBoundsException e) {
				mapBlock[1] = false;
			}
		} catch (IndexOutOfBoundsException e) {
			mapBlock[1] = false;
		}
		return mapBlock;
	}

	public boolean[] queryMap(int[] position) {
		return this.queryMap(position[1], position[0]);
	}

	public int[] getStart() {
		return pStart;
	}

	public int[] getEnd() {
		return pEnd;
	}

	public int[] getDimension() {
		return new int[] { maze.size(), maze.get(0).size() };
	}
}

// @SuppressWarnings("unused")
class Mice implements Runnable {
	private boolean[] allowedMove = { false, false, false, false };
	private ArrayList<int[]> history = new ArrayList<int[]>();
	private int[] position = { 0, 0 };
	private Maze map;
	private FinalDemo player;

	/**
	 * 
	 * @param position
	 *            Current position.
	 * @param goes
	 *            Direction comes from, -1 mean new comer..
	 * @param map
	 * @param player
	 */
	public Mice(int[] position, boolean[] allowedMove, Maze map, FinalDemo player) {
		this.position = position.clone();
		this.allowedMove = allowedMove.clone();
		this.map = map;
		this.player = player;
		history.add(position.clone());
	}

	public void move() {
		scan: while (true) {
			// get all possible move
			boolean[] nearBy = map.queryMap(position), nextMove = { false, false, false, false };
			int route = 0;
			// System.out.print(this + " : ");
			// Array.arrayPrint(position, true);
			for (int i = 0; i < 4; i++) {
				nextMove[i] = nearBy[i] && allowedMove[i];
				if (nextMove[i])
					route++;
				// System.out.println("isRoad=" + nearBy[i] + "+notPassed=" +
				// allowedMove[i] + "=> canGo=" + nextMove[i]);
			}

			if (route > 1) {
				// Intersection
				for (int i = 0; i < 4; i++) {
					if (nextMove[i]) {
						boolean[] order = { false, false, false, false };
						order[i] = true;
						// System.out.print(" forked.\n");
						player.putMice(position, order.clone(), map);
						nextMove[i] = false;
					}
				}
				break scan;
			} else if (route == 1) {
				// One-Way
				for (int i = 0; i < 4; i++) {
					if (nextMove[i]) {
						boolean[] order = { true, true, true, true };
						order[(i + 2) % 4] = false;
						allowedMove = order.clone();
						break;
					}
				}
				if (nextMove[0])
					position[1]++;
				if (nextMove[1])
					position[0]++;
				if (nextMove[2])
					position[1]--;
				if (nextMove[3])
					position[0]--;
				history.add(position.clone());
			} else {
				// Blind alley
				// System.out.print(" terminated.\n");
				int[] pEnd = map.getEnd();
				if (position[0] == pEnd[0] && position[1] == pEnd[1]) {
//					System.out.println("FFFIIIIIIIIIIIIIIIINNNNNNIIIIIIIIIISSSSSSSSSSSSSSSHHHHHHHH!!!!!!!!!!");
				} else {
					player.removeMice(this);
				}
				break scan;
			}
		}
	}

	public ArrayList<int[]> getResult() {
		return this.history;
	}

	@Override
	public void run() {
		this.move();
	}
}

public class FinalDemo {
	// ArrayList<Thread> nest = new ArrayList<Thread>();
	ArrayList<Mice> nest = new ArrayList<Mice>();

	public static void main(String[] args) {
		Maze maze = new Maze();
		// maze.mazeLoader();
		maze.printMaze();
		// for (boolean b : maze.queryMap(0, 0))
		// System.out.println(b);
		// for (boolean b : maze.queryMap(49, 0))
		// System.out.println(b);
		// for (boolean b : maze.queryMap(0, 29))
		// System.out.println(b);
		// for (boolean b : maze.queryMap(49, 29))
		// System.out.println(b);
		FinalDemo game = new FinalDemo();
		game.putMice(maze.getStart(), new boolean[] { true, true, true, true }, maze);
//		System.out.println(game.nest.size());
		System.out.print("\n\n");
		game.getResult(maze);
	}

	public void putMice(int[] position, boolean[] allowedMove, Maze map) {
		Mice mice = new Mice(position, allowedMove, map, this);
		nest.add(mice);
		// Thread runer = new Thread(mice);
		// runer.start();
		mice.move();
	}

	public void removeMice(Mice mice) {
		nest.remove(mice);
	}

	public void getResult(Maze maze) {
		ArrayList<ArrayList<int[]>> result = new ArrayList<ArrayList<int[]>>();
		for (Mice mice : nest) {
			result.add(mice.getResult());
		}
		System.out.println(result.size());

		boolean[][] mazeResult = new boolean[maze.getDimension()[0]][maze.getDimension()[1]];
		int[] pStart = maze.getStart(), pEnd = maze.getEnd();
		trace: while (true) {
			for (ArrayList<int[]> line : result) {
				if (line.get(line.size() - 1)[0] == pEnd[0] && line.get(line.size() - 1)[1] == pEnd[1]) {
					pEnd[0] = line.get(0)[0];
					pEnd[1] = line.get(0)[1];
					for (int[] isRoad : line) {
						mazeResult[isRoad[0]][isRoad[1]] = true;
					}
					if (line.get(0)[0] == pStart[0] && line.get(0)[1] == pStart[1]) {
						break trace;
					}
				}
			}
		}
		for (boolean[] lines : mazeResult) {
			for (boolean isRoad : lines) {
				System.out.print((isRoad ? '#' : ' '));
			}
			System.out.print('\n');
		}
	}
}
