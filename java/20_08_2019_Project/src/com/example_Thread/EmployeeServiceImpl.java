package com.example_Thread;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao = null;

	public EmployeeServiceImpl() throws SQLException {
		super();
		dao = new EmployeeDaoImpl();
	}

	@Override
	public void createEmployee(Employee employee) {

		dao.createEmployee(employee);
	}

	@Override
	public ResultSet getAllEmployees() {

		return dao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {

		return dao.getEmployeeById(id);
	}
	
	@Override
	public Employee delEmployeeById(int id) {

		return dao.delEmployeeById(id);
	}

}