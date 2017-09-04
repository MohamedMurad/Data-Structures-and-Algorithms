package eg.edu.alexu.csd.datastructure.stack.cs72;

import java.util.LinkedList;

import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * @author Murad this implementation for stack apply 6 essential options.
 *         add,push,pop,peak,isEmpty and size
 */
public class StackImp implements IStack {
	/**
	 * import a linked list.
	 */
	LinkedList<Object> myList = new LinkedList<Object>();
	/**
	 * this is the top index.
	 */
	int topInex = -1;

	/**
	 * @param element
	 *            which we add.
	 * @param index
	 *            is the index if element.
	 */
	public final void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		myList.add(index, element);
		topInex++;
	}

	/**
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#pop().
	 * @return obj return value.
	 */
	public Object pop() {
		// TODO Auto-generated method stub
		if (topInex == -1) {
			throw new RuntimeException();
		}
		Object obj = myList.get(topInex);
		myList.remove(topInex);
		topInex--;
		return obj;
	}

	/**
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#peek()
	 * @return myList.get(topInex) give me the top without removeing.
	 */
	public Object peek() {
		// TODO Auto-generated method stub
		return myList.get(topInex);
	}

	/**
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#push(java.lang.Object)
	 * @param element
	 *            give the value.
	 */
	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		myList.add(element);
		topInex++;
	}

	/**
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#isEmpty()
	 * @param return
	 *            myList.isEmpty() check if empty.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return myList.isEmpty();
	}

	/**
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#size()
	 * @param return
	 *            myList.size() return the size.
	 */
	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return myList.size();
	}

	// public static void main(String[] args){
	// StackImp M=new StackImp();
	// M.push(5);
	// M.pop();
	// M.pop();
	// }
}
