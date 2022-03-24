package com.sapient.aem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Employee;


public class EmployeeDaoImpl implements EmployeeDAO{

	@Override
	public Employee getEmployeeById(Integer empno) throws SQLException {
		//? is called placeholder
		String sql="select * from emp where empno= ?";
		Connection connection=null;
		try  {
			//JNDI
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/emsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			//replace placeholder(?) with empno passed to this method
			//after execution of the following statement, ? is replaced with empno
			preparedStatement.setInt(1, empno);
			ResultSet resultSet= preparedStatement.executeQuery();
			//read the row from resultSet object into Employee object
			if(resultSet.next()) {
				Employee employee= new Employee();
				//copy contents contents of resultset object into employee object
				populateEmployee(resultSet,employee);
				return employee;				
			}else {
				return null;
			}

		}catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}

	private void populateEmployee(ResultSet resultSet, Employee employee) throws SQLException{
		//here empno is column name
		employee.setEmpno(resultSet.getInt("empno"));
		employee.setEname(resultSet.getString("ename"));
		employee.setJob(resultSet.getString("job"));
		//convert java.sql.Date to java.time.LocalDate		
		employee.setHiredate(resultSet.getDate("hiredate").toLocalDate());		
		employee.setMgr(resultSet.getInt("mgr"));
		employee.setSal(resultSet.getDouble("sal"));
		employee.setComm(resultSet.getDouble("comm"));
		employee.setDeptno(resultSet.getInt("deptno"));

	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		String sql= "select * from emp";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/emsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet= statement.executeQuery(sql);
			
			List<Employee> employeeList=new ArrayList<>();			
			while(resultSet.next()) {
				Employee employee= new Employee();
				populateEmployee(resultSet,employee);
				employeeList.add(employee);				
			}

			return employeeList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public Integer addEmployee(Employee employee) throws SQLException {
		String sql= "insert into emp(ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?)";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/emsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			//replace the place holders
			preparedStatement.setString(1, employee.getEname());
			preparedStatement.setString(2, employee.getJob());
			if(employee.getMgr()==null) {
				preparedStatement.setNull(3, java.sql.Types.INTEGER);;
			}else {
				preparedStatement.setInt(3, employee.getMgr());
			}
			//convert java.time.LocalDate to java.sql.Date			
			preparedStatement.setDate(4, java.sql.Date.valueOf(employee.getHiredate()));
			preparedStatement.setDouble(5, employee.getSal());
			if(employee.getComm()==null) {
				preparedStatement.setNull(6, java.sql.Types.DOUBLE);
			}else {
				preparedStatement.setDouble(6, employee.getComm());
			}
			preparedStatement.setInt(7, employee.getDeptno());
			/*
			 * preparedStatement.executeUpdate() is applied for all DML(insert/update/delete) statements
			 */
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return getId();
			}else {
				return null;
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}

	private Integer getId() throws SQLException {
		String sql="select max(empno) from emp";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/emsDB");
			connection= dataSource.getConnection();
			Statement statement= connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new SQLException("No records in the table");
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}

	@Override
	public String updateEmployee(Employee employee) throws SQLException {
		String sql="update emp set job=?,sal=?,comm=?,deptno=? where empno=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/emsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			//replace place holders
			preparedStatement.setString(1, employee.getJob());
			preparedStatement.setDouble(2, employee.getSal());
			preparedStatement.setDouble(3, employee.getComm());
			preparedStatement.setInt(4, employee.getDeptno());
			preparedStatement.setInt(5, employee.getEmpno());

			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "Empno: "+ employee.getEmpno()+" updated";
			}else {
				return "Unable to update empno: "+ employee.getEmpno();
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public String deleteEmployee(Integer empno) throws SQLException {
		String sql="delete from emp where empno=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/emsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setInt(1, empno);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "Empno:"+empno+" deleted from database";
			}else {
				return "Unable to delete empno: "+empno;
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

}
