package com.run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the file path: ");

		String filePath = sc.nextLine();

		sc.close();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line = br.readLine();
			
			Map<String, Integer> candidate = new TreeMap<>();

			while (line != null) {
				String[] fields = line.split(",");

				String name = fields[0];
				Integer counts = Integer.valueOf(fields[1]);
				
				if(candidate.containsKey(name)) {
					candidate.put(name, candidate.get(name) + counts);
				} else {
					candidate.put(name, counts);
				}

				line = br.readLine();

			}

			System.out.println(candidate.toString());

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
