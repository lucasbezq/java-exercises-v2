package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Project {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> products = new ArrayList<>();

		System.out.println("Enter file path: ");
		String UserSourceFile = sc.nextLine();

		File sourceFile = new File(UserSourceFile);
		String UserSourceFolder = sourceFile.getParent();

		boolean success = new File(UserSourceFolder + "\\out").mkdir();
		String targetFile = UserSourceFolder + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(UserSourceFile))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				products.add(new Product(name, price, quantity));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {

				for (Product item : products) {
					bw.write(item.getName() + ", " + String.format("%.2f", item.totalPrice()));
					bw.newLine();
				}

				System.out.println(targetFile + " CREATED");

			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}

		sc.close();
	}

}
