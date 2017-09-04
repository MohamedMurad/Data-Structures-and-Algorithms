package dataStructure;


public class BinaryHeap implements BinaryTree {
	private int size;
	private int maxSize;
	public int[] data;

	public BinaryHeap(int[] listOfNumber) {
		maxSize = listOfNumber.length;
		data = listOfNumber;
		size = 0;
		//build_max_heap();
	}

	public int getMax() {
		if (isEmpty())
			throw new RuntimeException("Heap is empty");
		else
			return data[0];
	}

	@Override
	public boolean isEmpty() {

		return size == 0;

	}

	@Override
	public boolean isFull() {

		return size == maxSize;
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub

	}

	@Override
	public int parentIndex(int nodeIndex) {
		// return ;

		if (hasParent(nodeIndex))
			return (nodeIndex - 1) / 2;
		else
			throw new RuntimeException("No Parent");
	}

	@Override
	public void insert(int value) {
		if (size == maxSize)
			throw new RuntimeException("can't add new element , heap is full");
		else {
			size++;
			data[size - 1] = value;
			heapfyUp(size - 1);
		}

	}

	@Override
	public void deleteMax() {
		if (isEmpty())
			throw new RuntimeException("Heap is empty");
		else {
			data[0] = data[size - 1];
			size--;
			if (size > 0)
				heapfyDown(0);
		}
	}

	@Override
	public int rightChildIndex(int nodeIndex) {
		//if (hasRightChild(nodeIndex))
			return 2 * nodeIndex + 2;
		//else throw new RuntimeException("No Right Child");
	}

	@Override
	public int leftChildIndex(int nodeIndex) {
		//if (hasLeftChild(nodeIndex))
			return 2 * nodeIndex + 1;
		//else throw new RuntimeException("No Left Child");
	}

	@Override
	public boolean hasRightChild(int nodeIndex) {
		// TODO Auto-generated method stub
		return 2 * nodeIndex + 2 < maxSize && 2 * nodeIndex + 1 >= 0;
	}

	@Override
	public boolean hasLeftChild(int nodeIndex) {
		// TODO Auto-generated method stub
		return 2 * nodeIndex + 1 < maxSize && 2 * nodeIndex + 1 >= 0;
	}

	@Override
	public boolean hasParent(int nodeIndex) {
		// TODO Auto-generated method stub
		return (nodeIndex - 1) / 2 < maxSize && (nodeIndex - 1) / 2 >= 0;
	}

	protected void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public void heapfyUp(int nodeIndex) {
		int parentIndex;
		if (nodeIndex != 0) {
			parentIndex = parentIndex(nodeIndex);
			if (data[parentIndex] < data[nodeIndex]) {
				swap(nodeIndex, parentIndex);
				heapfyUp(parentIndex);
			}
		}
	}

	private void heapfyDown(int nodeIndex) {
		int leftChildIndex, rightChildIndex, maxIndex;
		leftChildIndex = leftChildIndex(nodeIndex);
		rightChildIndex = rightChildIndex(nodeIndex);
		if (!hasRightChild(nodeIndex)) {
			if (!hasLeftChild(nodeIndex))
				return;
			else{
				maxIndex =  leftChildIndex(nodeIndex);
				
			}
		} else {
			if (data[leftChildIndex] >= data[rightChildIndex])
				maxIndex = leftChildIndex;
			else
				maxIndex = rightChildIndex;
		}
		if (data[nodeIndex] < data[maxIndex]) {
			swap(maxIndex, nodeIndex);
			heapfyDown(maxIndex);
		}
	}

	public void build_max_heap() {
		// TODO Auto-generated method stub
		
		for (int i = (size / 2)+1; i >= 0; --i) {
			
			heapfyDown(i);
		}
	}

	public void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" " );
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
