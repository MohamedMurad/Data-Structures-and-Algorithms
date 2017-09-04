package sortingAlgorithm;

public class InsertionSort extends SortingMethod{

	public InsertionSort(int[] listOfNumber) {
		super(listOfNumber);	
	}

	@Override
	public void doSorted() {
		for(int i=1;i<size;i++){
			int key=sortedNumber[i];
			int j=i-1;
			while(j>-1&&sortedNumber[j]>key){
				sortedNumber[j+1]=sortedNumber[j];
				j--;
			}
			sortedNumber[j+1]=key;
		}
	}
}