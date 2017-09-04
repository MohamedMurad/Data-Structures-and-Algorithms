package eg.edu.alexu.csd.datastructure.queue.cs72;

import eg.edu.alexu.csd.datastructure.linkedList.cs72.DNode;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author Murad. this is an implementation of Queue using linkedlist.
 */
public class MyQueue2 implements IQueue, ILinkedBased {

	/**
	 * size : stores length of the Queue.
	 */
	private int size;
	/**
	 * header and trailer.
	 */
	private DNode header, trailer;

	/**
	 * this is the declearation containing initial nodes.
	 */
	public MyQueue2() {
		size = 0;
		header = new DNode(null, null, null);
		trailer = new DNode(null, header, null);
		header.setNext(trailer);
	}

	/**
	 * @param item
	 *            is the element needed be entered. enqueue : to put new element
	 *            at end of the queue.
	 */
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		DNode node = new DNode(item, null, null);
		DNode w = header.getNext();
		node.setPrev(header);
		node.setNext(w);
		w.setPrev(node);
		header.setNext(node);
		size++;
	}

	/**
	 * dequeue an element : remove element at front.
	 */
	@Override
	public final Object dequeue() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new RuntimeException();
		}
		DNode prev = trailer.getPrev();
		DNode bPrev = prev.getPrev();
		bPrev.setNext(trailer);
		trailer.setPrev(bPrev);
		Object temp = prev.getElement();
		size--;
		return temp;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	// public static void main(String[] args){
	// MyQueue2 mQ=new MyQueue2();
	// System.out.println(mQ.size());
	// mQ.enqueue(1);
	// mQ.enqueue(2);
	// mQ.enqueue(3);
	// System.out.println(mQ.dequeue());
	// System.out.println(mQ.dequeue());
	// System.out.println(mQ.dequeue());
	// System.out.println(mQ.size());
	// System.out.println(mQ.isEmpty());
	// mQ.enqueue(1);
	// mQ.enqueue(2);
	// mQ.enqueue(3);
	// System.out.println(mQ.dequeue());
	// System.out.println(mQ.dequeue());
	// System.out.println(mQ.size());
	// System.out.println(mQ.isEmpty());
	// System.out.println(mQ.dequeue());
	// System.out.println(mQ.dequeue());
	// }

}
