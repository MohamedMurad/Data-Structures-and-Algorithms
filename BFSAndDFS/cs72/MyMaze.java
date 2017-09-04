package eg.edu.alexu.csd.datastructure.maze.cs72;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs72.MyQueue2;
import eg.edu.alexu.csd.datastructure.stack.cs72.MyStack;

/**
 * @author Murad. this is an implemetation for Maze.
 */
public class MyMaze implements IMazeSolver {

	/**
	 * initialization n and m. n is number of rows. m is number of columns.
	 */
	private int n = 0, m = 0;
	/**
	 * initialize the grids.
	 */
	private Character[][] grid = new Character[n][m];

	@Override
	public int[][] solveBFS(final File maze) {
		// TODO Auto-generated method stub
		String getSymbol = new String();
		String[] getLines;
		String getLine = new String();
		int i = 0;

		LineNumberReader lNReader;
		try {
			lNReader = new LineNumberReader(new FileReader(maze));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		try {
			lNReader.skip(Long.MAX_VALUE);
		} catch (IOException e1) {
			throw new RuntimeException();
		}
		m = lNReader.getLineNumber();
		getLines = new String[m + 1];
		try {
			lNReader.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

		File file = maze;
		FileReader reader;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		BufferedReader bReader = new BufferedReader(reader);
		try {

			while ((getLine = bReader.readLine()) != null) {
				getLines[i++] = getLine;
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
		String firstLine = getLines[0];
		firstLine = firstLine + " ";
		for (i = 0; i < firstLine.length(); i++) {
			if (firstLine.charAt(i) != ' ') {
				getSymbol = new String();
				while (firstLine.charAt(i) != ' ') {
					getSymbol += firstLine.charAt(i++);
				}
				if (m == 0) {
					m = Integer.parseInt(getSymbol);
				} else {
					n = Integer.parseInt(getSymbol);
				}

			}
		}

		// making the grid
		int sX = -1, sY = -1;
		boolean exit = false;

		grid = new Character[m][n];
		String currentLine = new String();
		int numberOfCells = 0;
		for (i = 1; i < getLines.length; i++) {
			currentLine = new String(getLines[i]);
			currentLine = currentLine.replaceAll(" ", "");
			if (currentLine.contains("E")) {
				exit = true;
			}
			for (int j = 0; j < currentLine.length(); j++) {
				if (currentLine.charAt(j) == '.' || currentLine.charAt(j) == '#' || currentLine.charAt(j) == 'E'
						|| currentLine.charAt(j) == 'S') {
					if (numberOfCells >= n) {
						throw new RuntimeException();
					}
					if (currentLine.charAt(j) == 'S') {
						if (sX == -1 && sY == -1) {
							sX = i - 1;
							sY = numberOfCells;
						} else {
							throw new RuntimeException();
						}
					}
					grid[i - 1][numberOfCells++] = currentLine.charAt(j);
				} else {
					throw new RuntimeException();
				}

			}
			if (numberOfCells != n) {
				throw new RuntimeException();
			}
			numberOfCells = 0;
		}

		if (!exit) {
			throw new RuntimeException();
		}

		return solveUsingBFS(sX, sY);
	}

	@Override
	public int[][] solveDFS(final File maze) {
		// TODO Auto-generated method stub
		String getSymbol = new String();
		String[] getLines;
		String getLine = new String();
		int i = 0;

		LineNumberReader lNReader;
		try {
			lNReader = new LineNumberReader(new FileReader(maze));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		try {
			lNReader.skip(Long.MAX_VALUE);
		} catch (IOException e1) {
			throw new RuntimeException();
		}
		m = lNReader.getLineNumber();
		getLines = new String[m + 1];
		try {
			lNReader.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

		File file = maze;
		FileReader reader;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		BufferedReader bReader = new BufferedReader(reader);
		try {

			while ((getLine = bReader.readLine()) != null) {
				getLines[i++] = getLine;
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
		String firstLine = getLines[0];
		firstLine = firstLine + " ";
		for (i = 0; i < firstLine.length(); i++) {
			if (firstLine.charAt(i) != ' ') {
				getSymbol = new String();
				while (firstLine.charAt(i) != ' ') {
					getSymbol += firstLine.charAt(i++);
				}
				if (m == 0) {
					m = Integer.parseInt(getSymbol);
				} else {
					n = Integer.parseInt(getSymbol);
				}

			}
		}

		// making the grid
		int sX = -1, sY = -1;
		boolean exit = false;

		grid = new Character[m][n];
		String currentLine = new String();
		int numberOfCells = 0;
		for (i = 1; i < getLines.length; i++) {
			currentLine = new String(getLines[i]);
			currentLine = currentLine.replaceAll(" ", "");
			if (currentLine.contains("E")) {
				exit = true;
			}
			for (int j = 0; j < currentLine.length(); j++) {
				if (currentLine.charAt(j) == '.' || currentLine.charAt(j) == '#' || currentLine.charAt(j) == 'E'
						|| currentLine.charAt(j) == 'S') {
					if (numberOfCells >= n) {
						throw new RuntimeException();
					}
					if (currentLine.charAt(j) == 'S') {
						if (sX == -1 && sY == -1) {
							sX = i - 1;
							sY = numberOfCells;
						} else {
							throw new RuntimeException();
						}
					}
					grid[i - 1][numberOfCells++] = currentLine.charAt(j);
				} else {
					throw new RuntimeException();
				}

			}
			if (numberOfCells != n) {
				throw new RuntimeException();
			}
			numberOfCells = 0;
		}
		if (!exit) {
			throw new RuntimeException();
		}

		return solveUsingDFS(sX, sY);
	}

	/**
	 * this is the array of paths which. will contain final paths that will be
	 * returned.
	 */
	int[][] path;

	/**
	 * @param x
	 *            is the x-coordinate of start.
	 * @param y
	 *            is the x-coordinate of start.
	 * @return path : is the final results of paths.
	 */
	public final int[][] solveUsingBFS(final int x, final int y) {

		// basic declaration.
		boolean[][] visited = new boolean[m][n];
		Integer[][] dist = new Integer[m][n];
		MyQueue2 mQ = new MyQueue2();
		ArrayList<Point> outPuts = new ArrayList<Point>();
		int i = 0;
		boolean flag = false;
		boolean valid = false;
		Point p = new Point();
		Point e = new Point();
		/**
		 * xC and yC is the current coordinates.
		 */
		int xC, yC;
		// basic initialization.
		p.setLocation(x, y);
		mQ.enqueue(p);
		visited[x][y] = true;
		dist[x][y] = i;

		while (!flag) {
			try {
				p = (Point) mQ.dequeue();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				return null;
			}
			xC = (int) p.getX();
			yC = (int) p.getY();
			i = dist[xC][yC] + 1;

			if (!flag && (xC - 1 >= 0 && grid[xC - 1][yC] != '#' && !visited[xC - 1][yC])) {
				Point pp = new Point(xC - 1, yC);
				mQ.enqueue(pp);
				visited[xC - 1][yC] = true;
				dist[xC - 1][yC] = i;
				valid = true;
				if (grid[xC - 1][yC] == 'E') {
					flag = true;
					e.setLocation(xC - 1, yC);
				}
			}
			if (!flag && (yC + 1 < n && grid[xC][yC + 1] != '#' && !visited[xC][yC + 1])) {
				Point pp = new Point(xC, yC + 1);
				mQ.enqueue(pp);
				visited[xC][yC + 1] = true;
				dist[xC][yC + 1] = i;
				valid = true;
				if (grid[xC][yC + 1] == 'E') {
					flag = true;
					e.setLocation(xC, yC + 1);
				}
			}
			if (!flag && (xC + 1 < m && grid[xC + 1][yC] != '#' && !visited[xC + 1][yC])) {
				Point pp = new Point(xC + 1, yC);
				mQ.enqueue(pp);
				visited[xC + 1][yC] = true;
				dist[xC + 1][yC] = i;
				valid = true;
				if (grid[xC + 1][yC] == 'E') {
					flag = true;
					e.setLocation(xC + 1, yC);
				}
			}
			if (!flag && (yC - 1 >= 0 && grid[xC][yC - 1] != '#' && !visited[xC][yC - 1])) {
				Point pp = new Point(xC, yC - 1);
				mQ.enqueue(pp);
				visited[xC][yC - 1] = true;
				dist[xC][yC - 1] = i;
				valid = true;
				if (grid[xC][yC - 1] == 'E') {
					flag = true;
					e.setLocation(xC, yC - 1);
				}
			}
			if (valid) {
				outPuts.add(p);
			}
			valid = false;
			if (flag) {
				outPuts.add(e);
			}

		}
		int size = dist[(int) e.getX()][(int) e.getY()] + 1;
		path = new int[size][2];
		int counter = size - 1;

		for (i = outPuts.size() - 1; i >= 0; i--) {
			xC = (int) outPuts.get(i).getX();
			yC = (int) outPuts.get(i).getY();
			if (counter == dist[xC][yC]) {
				path[counter][0] = xC;
				path[counter--][1] = yC;
			}

		}
		return path;

	}

	/**
	 * @param x
	 *            as initial x is the x-coordinate of the start point.
	 * @param y
	 *            as initial y is the y-coordinate of the start point.
	 * @return path : is the final paths.
	 */
	public final int[][] solveUsingDFS(final int x, final int y) {
		boolean[][] visited = new boolean[m][n];

		MyStack mS = new MyStack();
		Point p = new Point();
		p.setLocation(x, y);
		mS.push(p);
		visited[x][y] = true;
		boolean flag = false;
		/**
		 * xC and yC is the current coordinates.
		 */
		int xC, yC;
		while (!flag && !mS.isEmpty()) {
			p = (Point) mS.peek();
			xC = (int) p.getX();
			yC = (int) p.getY();
			if (grid[xC][yC] == 'E') {
				flag = true;
			}
			if (!flag) {
				if (xC - 1 >= 0 && grid[xC - 1][yC] != '#' && !visited[xC - 1][yC]) {
					Point pp = new Point(xC - 1, yC);
					mS.push(pp);
					visited[xC - 1][yC] = true;
				} else if (yC + 1 < n && grid[xC][yC + 1] != '#' && !visited[xC][yC + 1]) {
					Point pp = new Point(xC, yC + 1);
					mS.push(pp);
					visited[xC][yC + 1] = true;
				} else if (xC + 1 < m && grid[xC + 1][yC] != '#' && !visited[xC + 1][yC]) {
					Point pp = new Point(xC + 1, yC);
					mS.push(pp);
					visited[xC + 1][yC] = true;
				} else if (yC - 1 >= 0 && grid[xC][yC - 1] != '#' && !visited[xC][yC - 1]) {
					Point pp = new Point(xC, yC - 1);
					mS.push(pp);
					visited[xC][yC - 1] = true;
				} else {
					mS.pop();
				}

			}
		}
		int size = mS.size();
		if (size == 0) {
			return null;
		}
		path = new int[size][2];
		for (size = size - 1; size >= 0; size--) {
			p = (Point) mS.pop();
			path[size][0] = (int) p.getX();
			path[size][1] = (int) p.getY();
		}
		return path;
	}
	// public static void main(String[] args) {
	// File file = new File("C:\\Users\\3rb\\Desktop\\testing.txt");
	// MyMaze MM = new MyMaze();
	// // MM.M = 6;
	// // MM.N = 6;
	// // Character[][] g = { { '#', '#', '#', 'E', '.', '.' },
	// // { '#', '#', '.', '.', '.', '#' },
	// // { '.', '.', '.', '.', '.', '.' },
	// // { '#', 'S', '.', '#', '#', '.' },
	// // { '.', '.', '#', '.', '.', '#' },
	// // { '.', '.', '.', '.', 'S', '.' } };
	// // MM.grid = g;
	// int arr[][] = MM.solveBFS(file);
	// if (arr == null) {
	// System.out.println("null");
	// } else {
	// for (int i = 0; i < arr.length; i++) {
	// for (int j = 0; j < arr[0].length; j++) {
	// System.out.print(arr[i][j] + " ");
	// }
	// System.out.print("\n");
	// }
	// }
	// }

}
