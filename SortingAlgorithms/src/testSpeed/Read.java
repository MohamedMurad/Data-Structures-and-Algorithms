package testSpeed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

	
	public static void main(String[] args) throws FileNotFoundException {
		File file = null;
		ArrayList<Integer> result  = new ArrayList<>();
		
		try(Scanner scan = new Scanner(file);) {
			if (scan.hasNextInt()) {
				scan.nextInt();
			}
		} catch (Exception e) {
			
		}
	}
	
}
