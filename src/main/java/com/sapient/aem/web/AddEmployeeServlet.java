package com.sapient.aem.web;

import java.io.IOException;
import java.time.LocalDate;
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


@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(AddEmployeeServlet.class);
	private EmployeeService employeeService= new EmployeeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the form data
			String ename= request.getParameter("ename");
			String job= request.getParameter("job");
			Integer mgr= Integer.parseInt(request.getParameter("mgr"));
			//yyyy-mm-dd
			String hiredate=request.getParameter("hiredate");
			Double sal= Double.parseDouble(request.getParameter("sal"));
			Double comm= Double.parseDouble(request.getParameter("comm"));
			Integer deptno= Integer.parseInt(request.getParameter("deptno"));
			// Sanitize the form data
			//TODO
			
			// Populate the Employee object
			if(mgr==0) {
				mgr=null;
			}
			Employee employee= 
					new Employee(ename,job,mgr,LocalDate.parse(hiredate),sal,comm,deptno);
			
			//call employee service addEmployee()
			Integer empno= employeeService.addEmployee(employee);
			if(empno !=null) {
//				List<Employee> employeeList= employeeService.getEmployees();
//				request.setAttribute("employeeList", employeeList);
//				request.getRequestDispatcher("WEB-INF/views/show-all-emp.jsp")
//								.forward(request, response);
				
				request.getRequestDispatcher("allemp").forward(request, response);
			}else {
				response.getWriter().println("<html><body><h2>"+"Unable to add employee"+"</h2></body></html>");
				request.getRequestDispatcher("WEB-INF/views/add-emp.jsp")
				.include(request, response);
			}
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
