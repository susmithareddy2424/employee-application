package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(LoginServlet.class);
	private UserService userService= new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			String username= request.getParameter("username");
			String password=  request.getParameter("password");
			String role= request.getParameter("role");
			
			Role myRole=null;
			if(role.equals("admin")) {
				myRole= Role.ADMIN;
			}else if(role.equals("manager")) {
				myRole=Role.MANAGER;
			}else if(role.equals("worker")){
				myRole=Role.WORKER;
			}
			if(userService.isValidUser(username, password, myRole)==true) {
				HttpSession session= request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("role", role);
				logger.info(username+" logged at"+ new Date());
//				out.println("<html><body><h2>"+"Welcome "+ username+"</h2></body></html>");
			
				if(role.equals("admin")) {
					request.getRequestDispatcher("WEB-INF/views/admin-dashboard.jsp")
													.forward(request, response);
				}else if(role.equals("manager")) {
					request.getRequestDispatcher("WEB-INF/views/manager-dashboard.jsp")
					.forward(request, response);
				}else if(role.equals("worker")) {
					request.getRequestDispatcher("WEB-INF/views/worker-dashboard.jsp")
					.forward(request, response);
				}else {
					out.println("<html><body><h2>"+"Invalid Role"+"</h2></body></html>");
				}
			
			
			}else {
				out.println("<html><body><h2>"+"Invalid Credentials. Login Again"+"</h2></body></html>");
//				RequestDispatcher requestDispatcher= request.getRequestDispatcher("login.html");
//				requestDispatcher.include(request, response);
				request.getRequestDispatcher("login.html").include(request, response);
				
			}
			
		}catch(UserException e) {
			logger.error(e.getMessage(),e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
