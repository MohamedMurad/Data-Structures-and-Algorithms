package sortingAlgorithm;

public abstract class SortingMethod {
	protected int[] sortedNumber;
	protected int size;

	public SortingMethod(int[] listOfNumber) {
		sortedNumber = listOfNumber;
		size = listOfNumber.length;
	}

	public void print() {
		for (int i : sortedNumber) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}

	public abstract void doSorted();

	protected void swap(int i, int j) {
		int temp = sortedNumber[i];
		sortedNumber[i] = sortedNumber[j];
		sortedNumber[j] = temp;
	}
}
