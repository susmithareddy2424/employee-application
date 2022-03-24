package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.EmployeeDAO;
import com.sapient.aem.dao.EmployeeDaoImpl;
import com.sapient.aem.exception.EmployeeException;
import com.sapient.aem.model.Employee;

/*
 * The methods of service layer will call corresponding methods
 * of DAO layer and the response these methods receive are returned 
 * to UI layer.
 * 
 * How to call methods of DAO layer in Service layer?
 */
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDao= new EmployeeDaoImpl();

	@Override
	public Employee getEmployeeById(Integer empno) throws EmployeeException {
		try {
			Employee employee= employeeDao.getEmployeeById(empno);
			//any filtering
			return employee; //returing employee object UI layer
		}catch(SQLException e) {
			//converting SQLException to EmployeeException
			throw new EmployeeException(e.getMessage(),e);
		}
	}

	@Override
	public List<Employee> getEmployees() throws EmployeeException {
		try {
			List<Employee> employeeList= employeeDao.getEmployees();
			//any filtering
			return employeeList; //returning array of employees to UI layer
		}catch(SQLException e) {
			//converting SQLException to EmployeeException
			throw new EmployeeException(e.getMessage(),e);
		}
	}

	@Override
	public Integer addEmployee(Employee employee) throws EmployeeException {
		try {
			Integer empno = employeeDao.addEmployee(employee);
			//TODO: Validate employee object
			return empno; 
		}catch(SQLException e) {
			//converting SQLException to EmployeeException
			throw new EmployeeException(e.getMessage(),e);
		}
	}

	@Override
	public String updateEmployee(Employee employee) throws EmployeeException {
		try {
			String result= employeeDao.updateEmployee(employee);
			return result; 
		}catch(SQLException e) {
			//converting SQLException to EmployeeException
			throw new EmployeeException(e.getMessage(),e);
		}
	}

	@Override
	public String deleteEmployee(Integer empno) throws EmployeeException {
		try {
			String result= employeeDao.deleteEmployee(empno);			
			return result; 
		}catch(SQLException e) {
			//converting SQLException to EmployeeException
			throw new EmployeeException(e.getMessage(),e);
		}
	}

}
