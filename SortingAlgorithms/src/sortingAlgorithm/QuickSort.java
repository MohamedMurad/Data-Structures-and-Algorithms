package sortingAlgorithm;

public class QuickSort extends SortingMethod {

	public QuickSort(int[] listOfNumber) {
		super(listOfNumber);
	}

	@Override
	public void doSorted() {
		if (sortedNumber == null || sortedNumber.length == 0) {
			return;
		}
		quickSort(0, size - 1);
	}

	private void quickSort(int l, int h) {
		int i = l;
		int j = h;
		int pivot = sortedNumber[l + (h - l) / 2];
		while (i <= j) {
			while (sortedNumber[i] < pivot) {
				i++;
			}
			while (sortedNumber[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (l < j)
			quickSort(l, j);
		if (i < h)
			quickSort(i, h);
	}
}