package dao;

public class EmployeeDAOFactory {
	EmployeeDAO createEmployeeDAO() {
		return new EmployeeDAOJDBCImpl();
	}
}
