package validation;

public class Exceptions {

	private Exceptions() {
		// TODO Auto-generated constructor stub
	}

	private static Exceptions instance = null;

	public static Exceptions getInstance() {
		if (instance == null) {
			instance = new Exceptions();
		}
		return instance;
	}

	public void throwCannotOpenFile() {
		throw new RuntimeException("File Can't be opened, check your file name or destination");
	}

	public void throwMissingNAndE() {
		throw new RuntimeException("File is Empty, or number of n and/or e is invalid");
	}

	public void throwDataInvalid() {
		throw new RuntimeException("Data in this file is Invalid");
	}
	
	public void throwNegWeightNotAllowed() {
		throw new RuntimeException("Dijkstra can't handle negative weight");
	}
}
