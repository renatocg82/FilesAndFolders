package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class ReadingAndWriting {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scString = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the input file path: ");
		String strPath = scString.nextLine();
		File filePath = new File (strPath);
		boolean outDirectory = new File (filePath.getParent() + "\\Out").mkdir();
		System.out.println();
		System.out.println("Folder \\Out created: " + outDirectory);

		try (FileReader fr = new FileReader(strPath);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter("C:\\temp\\ws_eclipse\\FilesAndFoldExerc\\Out\\ExOut.csv", true);
				BufferedWriter bw = new BufferedWriter(fw)) {
			
			String line = br.readLine();

			while (line != null) {
				String[] line2 = line.split(",");

				Product tempProduct = (new Product(line2[0], Double.parseDouble(line2[1]),
						Double.parseDouble(line2[2])));
				String strTemp = (tempProduct.getName() + "," + String.format("%.2f", tempProduct.getTotal()));

				bw.write(strTemp);
				bw.newLine();
				line = br.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		scString.close();
		sc.close();
	}

}
