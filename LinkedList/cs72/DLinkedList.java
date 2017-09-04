package eg.edu.alexu.csd.datastructure.linkedList.cs72;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author Murad.
 */
public class DLinkedList implements ILinkedList {

	private int size;

	private DNode header, trailer;

	public DLinkedList() {
		size = 0;
		header = new DNode(null, null, null);
		trailer = new DNode(null, header, null);
		header.setNext(trailer);
	}

	@Override
	public final void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index > size || index < 0) {
			throw new RuntimeException();
		} else {
			DNode w = header.getNext();
			int counter = 0;
			while (counter != index) {
				w = w.getNext();
				counter++;
			}
			DNode v = new DNode(element, null, null);
			DNode x = w.getPrev();
			x.setNext(v);
			v.setPrev(x);
			v.setNext(w);
			w.setPrev(v);
			size++;
		}
	}

	@Override
	public final void add(final Object element) {
		// TODO Auto-generated method stub
		DNode w = new DNode(element, null, null);
		DNode v = trailer.getPrev();
		w.setNext(trailer);
		w.setPrev(v);
		trailer.setPrev(w);
		v.setNext(w);
		size++;
	}

	@Override
	public final Object get(final int index) {
		DNode ind = header.getNext();
		if (index >= size() || index < 0) {
			throw new RuntimeException();
		} else {

			for (int i = 0; i < index; i++) {
				ind = ind.getNext();
			}
			return ind.getElement();
		}
	}

	public final void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		} else {
			DNode w = header.getNext();
			int counter = 0;
			while (counter != index) {
				w = w.getNext();
				counter++;
			}
			w.setElement(element);
		}
	}

	@Override
	public final void clear() {
		// TODO Auto-generated method stub
		DNode w = header.getNext();
		DNode v = trailer.getPrev();
		header.setNext(trailer);
		trailer.setPrev(header);
		w.setPrev(null);
		v.setNext(null);
		size = 0;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public final void remove(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		} else {
			DNode w = header.getNext();
			int counter = 0;
			while (counter != index) {
				w = w.getNext();
				counter++;
			}
			DNode x = w.getPrev();
			DNode y = w.getNext();
			x.setNext(y);
			y.setPrev(x);
			w.setPrev(null);
			w.setNext(null);
			size--;
		}
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return size;
	}

	// it should be public ILinkedList sublist(int fromIndex, int toIndex);
	@Override
	public final ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub

		if (toIndex >= size || fromIndex < 0) {
			throw new RuntimeException();
		} else {
			ILinkedList dLL = new DLinkedList();
			DNode w = header.getNext();
			int counter = 0;
			while (counter != fromIndex) {
				w = w.getNext();
				counter++;
			}
			while (counter != toIndex) {
				dLL.add(w.getElement());
				w = w.getNext();
				counter++;
			}
			dLL.add(w.getElement());
			return dLL;
		}
	}

	@Override
	public final boolean contains(final Object o) {
		// TODO Auto-generated method stub
		boolean b = false;
		DNode w = header;
		int counter = 0;
		while ((counter != size) && !b) {
			w = w.getNext();
			counter++;
			if (w.getElement().equals(o)) {
				b = true;
			}
		}
		return b;
	}

	public final void showMe() {
		String s = new String();
		s = "[";
		DNode v = header.getNext();
		while (v != trailer) {
			s += v.getElement();
			v = v.getNext();
			if (v != trailer) {
				s += ",";
			}
		}
		s += "]";
		System.out.println(s);
	}

	public final void print() {
		DNode i = header;
		while (i != null) {
			System.out.print(i.getElement() + "   ");
			i = i.getNext();
		}
		System.out.println();
	}
}
