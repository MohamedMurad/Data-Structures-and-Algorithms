package sortingAlgorithm;

import dataStructure.BinaryHeap;

public class HeapSort extends SortingMethod {
	
	private BinaryHeap binaryHeap;

	public HeapSort(int[] listOfNumber) {
		super(listOfNumber);
		binaryHeap = new BinaryHeap(listOfNumber);
	}

	@Override
	public void doSorted() {
		binaryHeap.build_max_heap();
		for (int i = size; i >= 1; --i) {
			swap(i, 0);
			size--;
			binaryHeap.setSize(size);
			binaryHeap.heapfyUp(0);
		}
	}
}