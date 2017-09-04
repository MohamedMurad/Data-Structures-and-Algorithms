package eg.edu.alexu.csd.datastructure.stack.cs72;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * @author Murad
 */
public class ExpressionEval implements IExpressionEvaluator {

	public static final int A = 7;

	@Override
	public String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
		StringBuilder expre = new StringBuilder();
		MyStack mS = new MyStack();
		if (!ifIsValid(expression)) {
			throw new RuntimeException();
		}
		if (expression.length() < A || !checkIfValid(expression)) {
			throw new RuntimeException();
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != ' ') {
				if (expression.charAt(i) == '(' || expression.charAt(i) == '+' || expression.charAt(i) == '-'
						|| expression.charAt(i) == '*' || expression.charAt(i) == '/') {
					if (mS.size() == 0 || mS.peek() == (Object) '(' || expression.charAt(i) == '(') {
						mS.push(expression.charAt(i));
					} else if ((expression.charAt(i) == '*' || expression.charAt(i) == '/')
							&& (mS.peek().equals('+') || mS.peek().equals('-'))) {
						mS.push(expression.charAt(i));
					} else {
						if (expre.length() != 0) {
							expre.append(" ");
						}
						expre.append(mS.pop());
						i--;
					}

				} else if (expression.charAt(i) != ')') {
					if (expre.length() != 0) {
						expre.append(" ");
					}
					StringBuilder s = new StringBuilder();
					while (i != expression.length() && expression.charAt(i) != ' ' && expression.charAt(i) != '+'
							&& expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/'
							&& expression.charAt(i) != ')') {
						s.append(expression.charAt(i));
						i++;
					}
					i--;
					expre.append(s);
				} else if (expression.charAt(i) == ')') {
					while (mS.peek() != (Object) '(') {
						if (expre.length() != 0) {
							expre.append(" ");
						}
						expre.append(mS.pop());
					}
					mS.pop();
				}
			}
		}
		while (mS.size() != 0) {

			expre.append(" ");
			expre.append(mS.pop());
		}
		return expre.toString();
	}

	public static final int L = 3;

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		MyStack mSS = new MyStack();
		if (!ifIsValid(expression)) {
			throw new RuntimeException();
		}
		if (expression.length() < L || !checkIfValid2(expression)) {
			throw new RuntimeException();
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != ' ') {
				if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*'
						&& expression.charAt(i) != '/') {
					StringBuilder s = new StringBuilder();
					while (expression.charAt(i) != ' ') {
						s.append(expression.charAt(i++));
					}
					mSS.push(s);
				} else {
					float f1 = Float.parseFloat(mSS.pop().toString());
					float f2 = Float.parseFloat(mSS.pop().toString());
					switch (expression.charAt(i)) {
					case '+':
						mSS.push(f2 + f1);
						break;
					case '-':
						mSS.push(f2 - f1);
						break;
					case '*':
						mSS.push(f2 * f1);
						break;
					case '/':
						mSS.push(f2 / f1);
						break;
					default:
						throw new RuntimeException();
					}
				}
			}
		}
		float y = Float.parseFloat(mSS.pop().toString());
		int x = (int) y;
		return x;
	}

	/**
	 * . this function is for check if the expression valid to us or no. .
	 * 
	 * @param expression
	 *            is the expression we process on.
	 * @return true if is valid false otherwise.
	 */
	public final boolean checkIfValid(final String expression) {
		int counter = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(' || expression.charAt(i) == ')') {
				if (expression.charAt(i) == '(') {
					counter++;
				} else {
					counter--;
				}
			}
			if (counter < 0) {
				return false;
			}
		}
		if (counter != 0) {
			return false;
		}
		return true;
	}

	/**
	 * this is another method check for another kind for symbols validation.
	 * 
	 * @param expression
	 *            this is the required expression.
	 * @return true if valid , false otherwise.
	 */
	public final boolean checkIfValid2(final String expression) {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+' && expression.charAt(i) == '-' && expression.charAt(i) == '*'
					&& expression.charAt(i) == '/') {
				if (expression.charAt(i + 1) != ' ' || expression.charAt(i - 1) != ' ') {
					return false;
				}
			}
		}
		return true;
	}

	public static final int B = 48;

	public static final int C = 57;

	public static final int D = 40;

	public static final int E = 43;

	public static final int F = 45;

	public static final int G = 47;

	public final boolean checkIfExIsValid(final String expression) {
		int in;
		int l = expression.length();
		for (int i = 0; i < l; i++) {
			in = (int) expression.charAt(i);
			if (!((in >= B && in <= C) || (in >= D && in <= E) || in == F || in == G)) {
				throw new RuntimeException();
			}
		}
		return true;
	}

	public static final int H = 65;

	public static final int I = 90;

	public static final int J = 97;

	public static final int K = 122;

	public final boolean ifIsValid(final String expression) {
		int counterNum = 0, counterSym = 0;
		char c;
		for (int i = 0; i < expression.length(); i++) {
			c = expression.charAt(i);
			if ((((int) c >= H && (int) c <= I) || ((int) c >= J && (int) c <= K))) {
				counterNum++;
			} else {
				switch (expression.charAt(i)) {
				case '+':
				case '-':
				case '*':
				case '/':
					counterSym++;
					break;
				case '(':
				case ')':
				case ' ':
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					counterNum++;
					while (i < expression.length() && (expression.charAt(i) == '0' || expression.charAt(i) == '1'
							|| expression.charAt(i) == '2' || expression.charAt(i) == '3' || expression.charAt(i) == '4'
							|| expression.charAt(i) == '5' || expression.charAt(i) == '6' || expression.charAt(i) == '7'
							|| expression.charAt(i) == '8' || expression.charAt(i) == '8')) {
						i++;
					}
					i--;
				default:
					break;
				}

			}
		}
		if (counterNum - counterSym == 1) {
			return true;
		}
		return false;
	}
	// public static void main(String[] args) {
	// ExpressionEval EX = new ExpressionEval();
	// System.out.println(EX.infixToPostfix("a+(b/c)*d/e+(f/g*h+i)/j"));
	// System.out.println(EX.infixToPostfix(
	// "25 + ( 8 / 12 ) * 7 / 2 + ( 5 / 2 * ( 3 + 8 ) / 12 )"));
	// System.out.println(EX.evaluate(EX.infixToPostfix(
	// "25 + ( 8 / 12 ) * 7 / 2 + ( 5 / 2 * ( 3 + 8 ) / 12 )")));
	// System.out.println(EX.infixToPostfix("a*b+5"));
	// System.out.println(EX.checkIfValid(")()"));
	// System.out.println(EX.infixToPostfix("a*b/c"));
	// System.out.println(EX.infixToPostfix("(a/(b-c+d))*(e-a)*c"));
	// System.out.println(EX.infixToPostfix("a/b-c+d*e-a*c"));
	// System.out.println(
	// EX.infixToPostfix("a*b*c/c+r-e*f+(2*(5-(3*7-7/8)))*3+5/8"));
	// }
}
