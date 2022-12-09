package application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String userPath = sc.nextLine();
		
		File path = new File(userPath);
		
		System.out.println("File name: " + path.getName());
		System.out.println("Path name: " + path.getParent());
		System.out.println("Complete path name: " + path.getPath());
		
		sc.close();
	}

}
