package dao;
import java.sql.SQLException;

import model.Employee;

public interface EmployeeDAO {
	public void add(Employee empleat) throws SQLException;
	
	public void delete(int id)  throws SQLException;
	
	public Employee findById(int id)  throws SQLException;
	
	public Employee[] findAllEmployees()  throws SQLException;
	
	public void update(Employee empleat)  throws SQLException;
}
