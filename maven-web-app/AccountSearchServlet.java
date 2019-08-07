package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dao.AccountDao;
import com.lti.model.Account;

/**
 * Servlet implementation class AccountSearchServlet
 */
@WebServlet("/AccountSearchServlet")
public class AccountSearchServlet extends HttpServlet {
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		int aid = Integer.parseInt(request.getParameter("aid"));
 		
 		AccountDao dao = new AccountDao();
 		Account acc = dao.fetchAccount(aid);
 		
 		HttpSession session = request.getSession();
 		session.setAttribute("account",	acc);
 		
 		response.sendRedirect("searchResult.jsp");
 	}

}
