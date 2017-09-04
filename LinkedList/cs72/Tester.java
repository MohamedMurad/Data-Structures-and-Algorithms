package eg.edu.alexu.csd.datastructure.linkedList.cs72;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class Tester {

	public static final int O = 3;

	public static final int P = 4;

	public static final int Q = 5;

	public static final int R = 6;

	public static final int S = -4;

	@org.junit.Test
	public final void test() {
		Polynom po = new Polynom();
		int[][] a = { { 0, P }, { -1, O }, { 1, 2 }, { 1, 1 } };
		int[][] b = { { -1, Q }, { 0, P }, { 1, 1 }, { 1, 0 } };
		po.setPolynomial('A', a);
		po.setPolynomial('B', b);
		int[][] x;
		x = po.multiply('A', 'B');
		po.setPolynomial('C', x);

		assertEquals("x^8-x^7-x^6-x^4+2x^2+x", po.print('C'));

		po.add('C', 'A');
		assertEquals("x^8-x^7-x^6-x^4-x^3+3x^2+2x", po.print('R'));

		po.subtract('R', 'C');
		assertEquals("-x^3+x^2+x", po.print('R'));

	}

	/**
	 * this is a test.
	 */
	@Test(expected = RuntimeException.class)
	public void exception() {
		Polynom po = new Polynom();
		po.evaluatePolynomial('A', 2);
		po.evaluatePolynomial('B', 2);
		po.evaluatePolynomial('C', 2);
		int[][] a = { { 0, P }, { -1, O }, { 1, 2 }, { 1, 1 } };
		po.setPolynomial('s', a);
		po.add('A', 'B');
		po.subtract('A', 'B');
		po.multiply('A', 'B');
		int[][] b = { { 0, 1 }, { -1, 2 }, { 1, O }, { 1, P } };
		po.setPolynomial('A', b);
		int[][] c = { { 0, P }, {}, { 1, 2 }, { 1, 1 } };
		po.setPolynomial('A', c);
		po.setPolynomial('A', null);
		SLinkedList ln = new SLinkedList();
		ln.add(null);
		ln.add(1, Q);
		ln.remove(1);
		ln.get(2);
		ln.add(2);
		ln.set(1, Q);
		ln.clear();
		ILinkedList sub = new SLinkedList();
		ln.add(Q);
		ln.add(Q);
		ln.add(Q);
		ln.add(Q);
		ln.add(Q);
		sub = ln.sublist(P, R);
		sub = ln.sublist(P, 2);
		sub = ln.sublist(S, 2);
		ln.add(-1, Q);
	}

	@org.junit.Test
	public final void testlinked() {
		SLinkedList ln = new SLinkedList();
		ILinkedList sub = new SLinkedList();
		ln.add(0);
		ln.add("com");
		ln.add(2, 2);
		ln.add(O);
		assertEquals("com", ln.get(1));
		assertEquals(P, ln.size());
		assertTrue(ln.contains("com"));
		assertFalse(ln.isEmpty());
		ln.remove(1);
		assertEquals(2, ln.get(1));
		sub = ln.sublist(0, 2);
		assertEquals(2, sub.get(1));
		ln.clear();
		assertTrue(ln.isEmpty());
	}
}
