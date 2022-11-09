package model;

import java.sql.Date;

public class Employee {
	private Date birthDate;
	private String firstName;
	private int id;
	private String lastName;
	private float salary;
	public Employee(int id, String firstName, String lastName, Date birthDate, float salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	public Date getBirthDate() { return birthDate; }
	public String getFirstName() { return firstName; }
	public int getId() { return id; }
	public String getLastname() { return lastName; }
	public float getSalary() { return salary; }
	public String toString() {
		return "Employee with ID " + id + " and name " + firstName + " " + lastName;
	}
}
