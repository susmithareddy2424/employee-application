package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.Employee;

//CRUD operations
public interface EmployeeDAO {
	public abstract Employee getEmployeeById(Integer empno) throws SQLException;
	public abstract List<Employee> getEmployees() throws SQLException;
	public abstract Integer addEmployee(Employee employee) throws SQLException;
	public abstract String updateEmployee(Employee employee) throws SQLException;
	public abstract String deleteEmployee(Integer empno) throws SQLException;
	
}
