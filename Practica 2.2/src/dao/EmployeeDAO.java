package dao;
import model.Employee;

public interface EmployeeDAO {
	public void add(Employee empleat);
	
	public void delete(int id);
	
	public Employee findById(int id);
	
	public Employee[] findAllEmployees();
	
	public void update(Employee empleat);
}
