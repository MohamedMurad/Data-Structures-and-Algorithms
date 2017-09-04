package testSpeed;

import java.util.Random;

import sortingAlgorithm.BubbleSort;
import sortingAlgorithm.HeapSort;
import sortingAlgorithm.InsertionSort;
import sortingAlgorithm.QuickSort;

public class TestSortingSpeed {

	public static void main(String[] args) {
		Random random = new Random();
		final int size = 10000;
		int i = size;
		int arr[] = new int[size];
		int num;
		while (i > 0) {
			num = random.nextInt(size);
			arr[i - 1] = num;
			i--;
		}

		BubbleSort bubbleSort = new BubbleSort(arr);
		InsertionSort insertionSort = new InsertionSort(arr);
		QuickSort quickSort = new QuickSort(arr);
		HeapSort heapSort = new HeapSort(arr);
		long startTime, endTime;

		/*
		 * it takes approximately average of 410 ms
		 */
		// startTime = System.currentTimeMillis();
		// bubbleSort.sort(arr);
		// endTime = System.currentTimeMillis();
		// System.out.println("Bubble Sort\nTime = "+(endTime-startTime)+"\n");
		// bubbleSort.print();

		/*
		 * it takes approximately average of 90 ms
		 */
		// startTime = System.currentTimeMillis();
		// insertionSort.sort(arr);
		// endTime = System.currentTimeMillis();
		// System.out.println("Insertion Sort\nTime =
		// "+(endTime-startTime)+"\n");
		// insertionSort.print();
		
		/*
		 * it takes approximately average of 3 ms
		 */
		// startTime = System.currentTimeMillis();
		// quickSort.sort(arr);
		// endTime = System.currentTimeMillis();
		// System.out.println("Quick Sort\nTime = "+(endTime-startTime)+"\n");
		// quickSort.print();
		
		/*
		 * it takes approximately average of 5 ms
		 */
		startTime = System.currentTimeMillis();
		heapSort.doSorted();
		endTime = System.currentTimeMillis();
		System.out.println("Heap Sort\nTime = " + (endTime - startTime) + "\n");
		heapSort.print();

	}
}
