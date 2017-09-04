package sortingAlgorithm;

public class SelectionSort extends SortingMethod {
	public SelectionSort(int[] listOfNumber) {
		super(listOfNumber);
	}

	@Override
	public void doSorted() {
		for (int i = 0; i < this.size - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < this.size; j++) {
				if (this.sortedNumber[j] < this.sortedNumber[maxIndex]) {
					maxIndex = j;
				}
			}
			swap(i, maxIndex);
		}
	}
}