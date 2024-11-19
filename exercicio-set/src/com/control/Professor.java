package com.control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Professor implements Iterable<Classroom> {
	private String name;

	private List<Classroom> c = new ArrayList<>();
	

	public Professor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addClassroom(Classroom cls) {
		c.add(cls);
	}

	public void removeClassroom(Classroom cls) {
		c.remove(cls);
	}

	@Override
	public Iterator<Classroom> iterator() {
		return c.iterator();
	}

	public String studentsCount() {
		Set<Integer> studentSet = new HashSet<>();
		for (Classroom classroom : c) {
			for (Student student : classroom) {
				studentSet.add(student.getCod());
			}
		}
		return "Total students: " + studentSet.size();
	}

}
