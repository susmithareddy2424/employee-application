package com.sapient.aem.service;


import java.util.List;

import com.sapient.aem.exception.EmployeeException;
import com.sapient.aem.model.Employee;

/*
 * Exceptions thrown by the methods of DAO layer will be trapped
 * in Service layer. In the service layer, we convert SQLException to
 * custom exception and throw custom exception to the presentation layer.
 */
public interface EmployeeService {
	public abstract Employee getEmployeeById(Integer empno) throws EmployeeException;
	public abstract List<Employee> getEmployees() throws EmployeeException;
	public abstract Integer addEmployee(Employee employee) throws EmployeeException;
	public abstract String updateEmployee(Employee employee) throws EmployeeException;
	public abstract String deleteEmployee(Integer empno) throws EmployeeException;
}
