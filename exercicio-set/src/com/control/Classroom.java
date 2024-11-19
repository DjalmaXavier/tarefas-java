package com.control;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Classroom implements Iterable<Student> {
	private Subjects subject;

	private Set<Student> students = new HashSet<>();

	public Classroom(Subjects subject) {
		this.subject = subject;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void addStudent(Student user) {
		students.add(user);
	}

	public void removeStudent(Student user) {
		students.remove(user);
	}

	@Override
	public Iterator<Student> iterator() {
		return students.iterator();
	}

}
