package dataStructure;

public interface BinaryTree {

	public boolean isEmpty();

	public boolean isFull();

	public void makeEmpty();

	public int parentIndex(int nodeIndex);

	public void insert(int value);

	public void deleteMax();

	public int rightChildIndex(int nodeIndex);

	public int leftChildIndex(int nodeIndex);

	public boolean hasRightChild(int nodeIndex);

	public boolean hasLeftChild(int nodeIndex);

	public boolean hasParent(int nodeIndex);
}