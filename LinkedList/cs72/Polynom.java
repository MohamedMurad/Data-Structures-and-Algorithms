package eg.edu.alexu.csd.datastructure.linkedList.cs72;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * @author Murad.
 */
public class Polynom implements IPolynomialSolver {

	SLinkedList a = new SLinkedList();

	SLinkedList b = new SLinkedList();

	SLinkedList c = new SLinkedList();

	SLinkedList r = new SLinkedList();

	public final void setPolynomial(final char poly, final int[][] terms) {
		int x = terms.length;
		int index = 0;
		if (terms == null || terms.length == 0) {
			throw new RuntimeException();
		}

		switch (poly) {
		case 'A':
			a.clear();
			for (int i = 0; i < terms.length; i++) {
				if (terms[i] == null) {
					throw new RuntimeException();
				}
				if (terms[i][1] < 0 || (i < terms.length - 1 && terms[i][1] < terms[i + 1][1])) {

					throw new RuntimeException();
				}
				if (terms[i][0] != 0) {
					index++;
					Point ter = new Point(terms[i][0], terms[i][1]);
					a.add(ter);

				}
			}

			break;
		case 'B':
			b.clear();
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0 || (i < terms.length - 1 && terms[i][1] < terms[i + 1][1])) {
					throw new RuntimeException();
				}
				if (terms[i][0] != 0) {
					index++;
					Point ter = new Point(terms[i][0], terms[i][1]);
					b.add(ter);
				}
			}
			//
			break;
		case 'C':
			c.clear();
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0 || (i < terms.length - 1 && terms[i][1] < terms[i + 1][1])) {
					throw new RuntimeException();
				}
				if (terms[i][0] != 0) {
					index++;
					Point ter = new Point(terms[i][0], terms[i][1]);
					c.add(ter);

				}
			}

			break;
		case 'R':
			for (int i = 0; i < terms.length; i++) {
				if (terms[i] == null) {
					throw new RuntimeException();
				}
				if (terms[i][1] < 0 || (i < terms.length - 1 && terms[i][1] < terms[i + 1][1])) {
					throw new RuntimeException();
				}
				if (terms[i][0] != 0) {
					index++;
					Point ter = new Point(terms[i][0], terms[i][1]);
					r.add(ter);

				}
			}
			break;

		default:
			throw new RuntimeException();
		}

	}

	@Override
	public final String print(final char poly) {
		SLinkedList sLL = new SLinkedList();
		switch (poly) {
		case 'A':
			sLL = a;
			break;
		case 'B':
			sLL = b;
			break;
		case 'C':
			sLL = c;
			break;
		case 'R':
			sLL = r;
			break;

		default:
			throw new RuntimeException();
		}
		int size = sLL.size();
		if (size == 0) {
			return null;
		}
		String poll = new String();
		for (int i = 0; i < size; i++) {
			Point point = new Point();
			point = (Point) sLL.get(i);
			if (point.y < 0) {
				throw new RuntimeException();
			} else if (point.x > 1 || point.x < -1) {
				poll += point.x;
				if (point.y > 1) {
					poll += "x^" + point.y;
				} else if (point.y == 1) {
					poll += "x";
				}
			} else if (point.x == 1) {
				if (point.y > 1) {
					poll += "x^" + point.y;
				} else if (point.y == 1) {
					poll += "x";
				} else if (point.y == 0) {
					poll += "1";
				}
			} else if (point.x == -1) {
				if (point.y > 1) {
					poll += "-x^" + point.y;
				} else if (point.y == 1) {
					poll += "-x";
				} else if (point.y == 0) {
					poll += "-1";
				}
			}
			if (i < size - 1) {
				Point poi = new Point();
				poi = (Point) sLL.get(i + 1);
				if (poi.x > 0) {
					poll += "+";
				}
			}
		}

		return poll;
	}

	@Override
	public final void clearPolynomial(final char poly) {
		switch (poly) {
		case 'A':
			a.clear();
			break;
		case 'B':
			b.clear();
			break;
		case 'C':
			c.clear();
			break;
		default:
			break;
		}
	}

	@Override
	public final float evaluatePolynomial(final char poly, final float value) {
		// TODO Auto-generated method stub
		float f = 0f;

		switch (poly) {
		case 'A':
			if (a.size() == 0) {
				throw new RuntimeException();
			}

			for (int i = 0; i < a.size(); i++) {
				Point point = new Point();
				point = (Point) a.get(i);
				f += point.x * Math.pow(value, point.y);
			}
			break;
		case 'B':
			if (b.size() == 0) {
				throw new RuntimeException();
			}

			for (int i = 0; i < b.size(); i++) {
				Point point = new Point();
				point = (Point) b.get(i);
				f += point.x * Math.pow(value, point.y);
			}
			break;
		case 'C':
			if (c.size() == 0) {
				throw new RuntimeException();
			}
			for (int i = 0; i < c.size(); i++) {
				Point point = new Point();
				point = (Point) c.get(i);
				f += point.x * Math.pow(value, point.y);
			}
			break;
		case 'R':
			if (r.size() == 0) {
				throw new RuntimeException();
			}

			for (int i = 0; i < r.size(); i++) {
				Point point = new Point();
				point = (Point) r.get(i);
				f += point.x * Math.pow(value, point.y);
			}
			break;

		default:
			throw new RuntimeException();

		}

		return f;
	}

	@Override
	public final int[][] add(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		int index = 0;
		SLinkedList add1 = new SLinkedList();
		SLinkedList add2 = new SLinkedList();
		switch (poly1) {
		case 'A':
			add1 = a;
			break;
		case 'B':
			add1 = b;
			break;
		case 'C':
			add1 = c;
			break;
		case 'R':
			add1 = r;
			break;

		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			add2 = a;
			break;
		case 'B':
			add2 = b;
			break;
		case 'C':
			add2 = c;
			break;
		case 'R':
			add2 = r;
			break;

		default:
			throw new RuntimeException();
		}
		SLinkedList add = new SLinkedList();
		if (add1.size() == 0 || add2.size() == 0) {
			throw new RuntimeException();
		} else {
			boolean flag = true;
			for (int i = 0; i < add1.size(); i++) {
				Point point1 = new Point();
				point1 = (Point) add1.get(i);
				for (int j = 0; j < add2.size() && flag; j++) {
					Point point2 = new Point();
					point2 = (Point) add2.get(j);
					if (point1.y == point2.y) {
						Point point = new Point();
						point.setLocation(point1.x + point2.x, point1.y);
						if ((point1.x + point2.x) != 0) {
							index++;
							add.add(point);
						}
						flag = false;
					}
					if (j == add2.size() - 1 && flag) {
						Point point = new Point();
						point.setLocation(point1.x, point1.y);
						add.add(point);
						index++;
						flag = false;
					}
				}
				flag = true;
			}
			flag = true;
			for (int j = 0; j < add2.size(); j++) {
				Point point2 = new Point();
				point2 = (Point) add2.get(j);
				for (int i = 0; i < add1.size() && flag; i++) {
					Point point1 = new Point();
					point1 = (Point) add1.get(i);
					if (point1.y == point2.y) {
						flag = false;
					} else if (i == add1.size() - 1 && flag) {
						Point point = new Point();
						point.setLocation(point2.x, point2.y);
						add.add(point);
						index++;
						flag = false;
					}
				}
				flag = true;
			}
		}
		int[][] result = new int[index][2];
		for (int i = 0; i < index; i++) {
			Point point = new Point();
			point = (Point) add.get(i);
			result[i][0] = (int) point.x;
			result[i][1] = (int) point.y;
		}
		int p;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length - i - 1; j++) {
				if (result[j][1] < result[j + 1][1]) {
					p = result[j][1];
					result[j][1] = result[j + 1][1];
					result[j + 1][1] = p;
					p = result[j][0];
					result[j][0] = result[j + 1][0];
					result[j + 1][0] = p;
				}
			}
		}
		int[][] x = { { 0, 0 } };
		if (checkzero(result)) {
			r.clear();
			setPolynomial('R', x);
			return x;
		}
		r.clear();
		setPolynomial('R', result);

		return result;
	}

	@Override
	public final int[][] subtract(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		int index = 0;
		SLinkedList subtract1 = new SLinkedList();
		SLinkedList subtract2 = new SLinkedList();
		switch (poly1) {
		case 'A':
			subtract1 = a;
			break;
		case 'B':
			subtract1 = b;
			break;
		case 'C':
			subtract1 = c;
			break;
		case 'R':
			subtract1 = r;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			subtract2 = a;
			break;
		case 'B':
			subtract2 = b;
			break;
		case 'C':
			subtract2 = c;
			break;
		case 'R':
			subtract2 = r;
			break;
		default:
			throw new RuntimeException();
		}
		if (subtract1.size() == 0 || subtract2.size() == 0) {
			throw new RuntimeException();
		}
		int[][] x = { { 0, 0 } };
		if (subtract2.equals(subtract1)) {
			r.clear();
			setPolynomial('R', x);
			return x;
		}
		SLinkedList subtract = new SLinkedList();
		boolean flag = true;
		for (int i = 0; i < subtract1.size(); i++) {
			Point point1 = new Point();
			point1 = (Point) subtract1.get(i);
			for (int j = 0; j < subtract2.size() && flag; j++) {
				Point point2 = new Point();
				point2 = (Point) subtract2.get(j);
				if (point1.y == point2.y) {
					Point point = new Point();
					point.setLocation(point1.x - point2.x, point1.y);
					if ((point1.x - point2.x) != 0) {
						index++;
						subtract.add(point);
					}
					flag = false;
				}
				if (j == subtract2.size() - 1 && flag) {
					Point point = new Point();
					point.setLocation(point1.x, point1.y);
					index++;
					subtract.add(point);
					flag = false;
				}
			}
			flag = true;
		}
		flag = true;
		for (int j = 0; j < subtract2.size(); j++) {
			Point point2 = new Point();
			point2 = (Point) subtract2.get(j);
			for (int i = 0; i < subtract1.size() && flag; i++) {
				Point point1 = new Point();
				point1 = (Point) subtract1.get(i);
				if (point1.y == point2.y) {
					flag = false;
				} else if (i == subtract1.size() - 1 && flag) {
					Point point = new Point();
					point.setLocation(-point2.x, point2.y);
					subtract.add(point);
					index++;
					flag = false;
				}
			}
			flag = true;
		}
		int[][] result = new int[index][2];
		for (int i = 0; i < index; i++) {
			Point point = new Point();
			point = (Point) subtract.get(i);
			result[i][0] = (int) point.x;
			result[i][1] = (int) point.y;
		}
		int p;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length - i - 1; j++) {
				if (result[j][1] < result[j + 1][1]) {
					p = result[j][1];
					result[j][1] = result[j + 1][1];
					result[j + 1][1] = p;
					p = result[j][0];
					result[j][0] = result[j + 1][0];
					result[j + 1][0] = p;
				}
			}
		}
		r.clear();
		setPolynomial('R', result);
		return result;
	}

	@Override
	public final int[][] multiply(final char poly1, final char poly2) {
		// int index = 0;
		SLinkedList mult1 = new SLinkedList();
		SLinkedList mult2 = new SLinkedList();
		switch (poly1) {
		case 'A':
			mult1 = a;
			break;
		case 'B':
			mult1 = b;
			break;
		case 'C':
			mult1 = c;
			break;
		case 'R':
			mult1 = r;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			mult2 = a;
			break;
		case 'B':
			mult2 = b;
			break;
		case 'C':
			mult2 = c;
			break;
		case 'R':
			mult2 = r;
			break;
		default:
			throw new RuntimeException();
		}
		int size1 = mult1.size();
		int size2 = mult2.size();
		if (size1 == 0 || size2 == 0) {
			throw new RuntimeException();
		}
		int[][] result = new int[size1 * size2][2];
		int[][] num1 = new int[size1][2];
		int[][] num2 = new int[size2][2];
		for (int i = 0; i < size1; i++) {
			Point point1 = new Point();
			point1 = (Point) mult1.get(i);
			num1[i][0] = point1.x;
			num1[i][1] = point1.y;
		}
		for (int j = 0; j < size2; j++) {
			Point point2 = new Point();
			point2 = (Point) mult2.get(j);
			num2[j][0] = point2.x;
			num2[j][1] = point2.y;
		}
		int k = 0;
		result = new int[size1 * size2][2];
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {
				if (indexplace(result, num1[i][1] + num2[j][1]) == -1) {
					if ((num1[i][0]) * (num2[j][0]) != 0) {
						result[k][0] = (num1[i][0]) * (num2[j][0]);
						result[k][1] = num1[i][1] + num2[j][1];
						k++;
						// index++;
					}
				} else {
					if ((num1[i][0]) * (num2[j][0]) != 0) {
						result[indexplace(result, num1[i][1] + num2[j][1])][0] += (num1[i][0]) * (num2[j][0]);
					}
				}
			}
		}
		int[][] x = { { 0, 0 } };
		if (checkzero(result)) {
			r.clear();
			setPolynomial('R', x);
			return x;
		}
		int[][] result1 = new int[k][2];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 2; j++) {
				result1[i][j] = result[i][j];
			}
		}
		int p;
		for (int i = 0; i < result1.length; i++) {
			for (int j = 0; j < result1.length - i - 1; j++) {
				if (result1[j][1] < result1[j + 1][1]) {
					p = result1[j][1];
					result1[j][1] = result1[j + 1][1];
					result1[j + 1][1] = p;
					p = result1[j][0];
					result1[j][0] = result1[j + 1][0];
					result1[j + 1][0] = p;
				}
			}
		}
		r.clear();
		setPolynomial('R', result1);
		return result1;
	}

	public final int indexplace(final int[][] arr, final int num) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1] == num) {
				index = i;

				break;
			}
		}
		return index;
	}

	public final boolean checkzero(final int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] != 0) {
				return false;
			}
		}
		return true;
	}
}
