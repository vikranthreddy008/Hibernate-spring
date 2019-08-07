package com.lti.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pwd");
		
		try {
		CustomerDao dao=new CustomerDao();
		Customer c = dao.fetch(email, pass);
		HttpSession session=request.getSession();
		session.setAttribute("Customer",c);
		response.sendRedirect("welcome.jsp");
		}
		catch(Exception e) {
			response.sendRedirect("login.html");
		}
	}
	
}
