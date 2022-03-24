package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.EmployeeException;
import com.sapient.aem.model.Employee;
import com.sapient.aem.service.EmployeeService;
import com.sapient.aem.service.EmployeeServiceImpl;


@WebServlet("/allemp")
public class AllEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService= new EmployeeServiceImpl();
	private Logger logger= Logger.getLogger(AllEmployeeServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//fetch all employees from database into List
			List<Employee> employeeList=  employeeService.getEmployees();
			//Place employeeList object in request object
			request.setAttribute("employeeList", employeeList);
			//dispatch employeeList to show-all-emp.jsp
			request.getRequestDispatcher("WEB-INF/views/show-all-emp.jsp")
										.forward(request, response);
			
		}catch(EmployeeException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
