package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;
import model.Employee;

public class test {
	public static void main(String[] args) {
		try {
			EmployeeDAOFactory factory = new EmployeeDAOFactory();
			EmployeeDAO dao = factory.createEmployeeDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString="2000-04-25";
			Date d = (Date) sdf.parse(dateString);
			Employee e = new Employee(340,"ISAAC","FALCON",d,1000f);
			dao.add(e);
			
			Employee[] allEmps = dao.findAllEmployees();
			for (Employee employee : allEmps) {
				System.out.println(employee + "\n");
			}
			
		} catch (Exception e) {
			System.out.println("Error closing resource " + e.getClass().getName());
			System.out.println("Message: " + e.getMessage());
		}
	}
}
