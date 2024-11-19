package com.control;

import java.util.Objects;

public class Student {

	private int cod;

	public Student(int cod) {

		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return cod == other.cod;
	}
	
}
