package sortingAlgorithm;

public class BubbleSort extends SortingMethod{

	public BubbleSort(int[] listOfNumber) {
		super(listOfNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSorted() {
		int i, j;
		boolean flag = true;
		for (i = 0; (i < size) && (flag); ++i) {
			flag = false;
			for (j = 0; j < size - 1 - i; ++j) {
				if (sortedNumber[j] > sortedNumber[j + 1]) {
					swap(j, j + 1);
					flag = true;
				}
			}
		}		
	}
}