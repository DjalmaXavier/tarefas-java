package com.principal;

import java.util.Scanner;

import com.control.Classroom;
import com.control.Professor;
import com.control.Student;
import com.control.Subjects;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Professor Name: ");

		String name = sc.nextLine();

		Professor prof = new Professor(name);

		prof.addClassroom(new Classroom(Subjects.MATEMATICA));
		prof.addClassroom(new Classroom(Subjects.PORTUGUES));
		prof.addClassroom(new Classroom(Subjects.CIENCIA));

		for (Classroom cs : prof) {
			System.out.print("How many students for course " + cs.getSubject() + "?");
			int quantity = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < quantity; i++) {
				System.out.print("Stundent #" + (i + 1) + ":");
				int cod = sc.nextInt();
				cs.addStudent(new Student(cod));
			}
		}

		sc.close();

		System.out.println(prof.studentsCount());
	}

}
