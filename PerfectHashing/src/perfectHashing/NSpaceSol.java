package perfectHashing;

import java.util.ArrayList;
import universalHashing.MatrixMethodUH;

public class NSpaceSol {
	
	private Integer[] values;
	private NNSpaceSol[] hTable;
	private int n;
	private MatrixMethodUH hFunction;
	
	public NSpaceSol(Integer[] values) {
		this.values = values;
		n = values.length;
		hFunction = new MatrixMethodUH(n);
	}

	public boolean hash() {
		hTable = new NNSpaceSol[n];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] distributedData = new ArrayList[n];
		for (int i = 0; i < distributedData.length; i++) {
			distributedData[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n; i++) {
			int idx = hFunction.hashing(values[i]);
			if (!distributedData[idx].contains(values[i])) {
				distributedData[idx].add(values[i]);
			}
		}

		boolean finish = true;
		for (int i = 0; i < n && finish; i++) {
			Integer[] data = new Integer[distributedData[i].size()];
			data = distributedData[i].toArray(data);
			hTable[i] = new NNSpaceSol(data);
			finish = hTable[i].hash();
		}
		return finish;
	}
	
	public boolean exist(int value) {
		if (hTable[hFunction.hashing(value)]== null) {
			return false;
		}
		return hTable[hFunction.hashing(value)].exist(value);
	}
	
	/**
	 * ====================PRINT=======================
	 */
	
	public void printHTable(){
		for (int i = 0; i < hTable.length; i++) {
			System.out.print("INDEX:"+i+" >> ");
			hTable[i].printHTable();
		}
	}
	
	public void printRebuildingTrials(){
		for (int i = 0; i < hTable.length; i++) {
			System.out.println("REBUILDING TRIALS AT INDEX:"+i+" >> "+hTable[i].getChangesNum());
		}
	}
}