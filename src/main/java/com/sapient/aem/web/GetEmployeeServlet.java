package com.sapient.aem.web;

import java.io.IOException;

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


@WebServlet("/getemp")
public class GetEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService= new EmployeeServiceImpl();
	private Logger logger= Logger.getLogger(GetEmployeeServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer empno= Integer.parseInt(request.getParameter("empno"));
			Employee employee= employeeService.getEmployeeById(empno);
			if(employee != null) {
				//store employee object in request object
				request.setAttribute("employee", employee);
				logger.info(employee);
				request.getRequestDispatcher("WEB-INF/views/show-emp.jsp")
				.forward(request, response);		
			}else {
				request.setAttribute("message", "Invalid Empno");
				request.getRequestDispatcher("WEB-INF/views/status.jsp")
				.forward(request, response);
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
