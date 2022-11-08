package dao;
import model.Employee;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String username = "root";
		String password = "";
		try {
			Connection con = GetConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection GetConnection(String url, String username,String password) throws SQLException {
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}

	//Stored
	public void add(Employee empleat) {
		
	}

	//Stored
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	//PreparedStatement
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	//Stored
	public Employee[] findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	//Stored
	public void update(Employee empleat) {
		// TODO Auto-generated method stub
		
	}
}
