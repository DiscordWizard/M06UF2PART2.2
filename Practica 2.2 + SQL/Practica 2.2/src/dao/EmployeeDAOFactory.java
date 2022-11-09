package dao;

public class EmployeeDAOFactory {
	public EmployeeDAO createEmployeeDAO() {
		return new EmployeeDAOJDBCImpl();
	}
}
