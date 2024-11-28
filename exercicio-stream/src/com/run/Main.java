package com.run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.people.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file path: ");

		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			List<Employee> employeeList = new ArrayList<>();

			while (line != null) {
				String[] strArray = line.split(",");
				employeeList.add(new Employee(strArray[0], strArray[1], Double.parseDouble(strArray[2])));
				line = br.readLine();
			}

			System.out.print("Enter minimum salary: ");

			Double minSalary = sc.nextDouble();
			sc.nextLine();

			List<String> emails = employeeList.stream().filter(s -> s.getSalary() > minSalary).map(Employee::getEmail)
					.sorted().collect(Collectors.toList());

			emails.forEach(System.out::println);

			System.out.print("Enter first letter: ");

			Character firstLetter = sc.nextLine().toUpperCase().charAt(0);

			Double avrSalary = employeeList.stream().filter(p -> p.getName().charAt(0) == firstLetter)
					.map(Employee::getSalary).reduce(0.0, (x, y) -> x + y);

			System.out.println("Sum of salary of people whose name starts with " + firstLetter + ": "
					+ String.format("%.2f", avrSalary));

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
