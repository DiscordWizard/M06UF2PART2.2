package dao;
import model.Employee;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
	
	static Connection con;
	String url = "jdbc:mysql://localhost:3306/employeedb";
	String username = "root";
	String password = "";
	public EmployeeDAOJDBCImpl() {
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Stored
	public void add(Employee empleat) throws SQLException {
		CallableStatement statement = null;
		String proc = "{call ADDEMPLOYEE(?,?,?,?,?)}";
		try {
			con.setAutoCommit(false);
			
			statement = con.prepareCall(proc);
			statement.setDate(1, empleat.getBirthDate());
			statement.setString(2, empleat.getFirstName());
			statement.setInt(3, empleat.getId());
			statement.setString(4, empleat.getLastname());
			statement.setFloat(5, empleat.getSalary());
			statement.execute();
		} catch (SQLException e) {
			con.rollback();
		} finally {
			con.setAutoCommit(true);
		}
	}

	//Stored
	public void delete(int id) throws SQLException {
		CallableStatement statement = null;
		String proc = "{call REMOVEEMPLOYEE(?)}";
		try {
			con.setAutoCommit(false);
			
			statement = con.prepareCall(proc);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			con.rollback();
		} finally {
			con.setAutoCommit(true);
		}
	}

	//PreparedStatement
	public Employee findById(int id) throws SQLException {
		CallableStatement statement = null;
		PreparedStatement proc = con.prepareStatement(
				"SELECT ID, FIRSTNAME, LASTNAME, BIRTHDATE, SALARY"
				+ "FROM EMPLOYEE"
				+ "WHERE ID = ?"
		);
		proc.setInt(1, id);
		Employee found = null;
		ResultSet employee = statement.executeQuery();
		while(employee.next()) {
			found = new Employee(employee.getInt("ID"),
					employee.getString("FIRSTNAME"),
					employee.getString("LASTNAME"),
					employee.getDate("BIRTHDATE"),
					employee.getFloat("SALARY"));
		}
		return found;
	}

	//Stored
	public Employee[] findAllEmployees() throws SQLException {
		CallableStatement statement = null;
		String proc = "{call FINDALLEMPLOYEES()}";
		ArrayList<Employee> found = null;
		
		statement = con.prepareCall(proc);
		ResultSet employees = statement.executeQuery();
		while(employees.next()) {
			found.add(new Employee(employees.getInt("ID"),
					employees.getString("FIRSTNAME"),
					employees.getString("LASTNAME"),
					employees.getDate("BIRTHDATE"),
					employees.getFloat("SALARY")));
		}
		return found.toArray(new Employee[found.size()]);
	}

	//Stored
	public void update(Employee empleat) throws SQLException {
		CallableStatement statement = null;
		String proc = "{call UPDATEEMPLOYEE(?,?,?,?,?)}";
		try {
			con.setAutoCommit(false);
			
			statement = con.prepareCall(proc);
			statement.setDate(1, empleat.getBirthDate());
			statement.setString(2, empleat.getFirstName());
			statement.setInt(3, empleat.getId());
			statement.setString(4, empleat.getLastname());
			statement.setFloat(5, empleat.getSalary());
			statement.execute();
		} catch (SQLException e) {
			con.rollback();
		} finally {
			con.setAutoCommit(true);
		}
	}
}
