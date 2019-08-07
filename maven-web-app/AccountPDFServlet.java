package com.lti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lti.model.Account;

/**
 * Servlet implementation class AccountPDFServlet
 */
@WebServlet("/AccountPDFServlet")
public class AccountPDFServlet extends HttpServlet {
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		try {
 		HttpSession session = request.getSession();
 		Account acc = (Account) session.getAttribute("account");
 		
 		Document doc = new Document();
 		PdfWriter.getInstance(doc, response.getOutputStream());
 		
 		doc.open();
 		doc.addTitle("Account Details");
 		
 		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
 		Paragraph para = new Paragraph();
 		para.setFont(font);
 		para.add(new Paragraph("Account Id " + acc.getId()));
 		para.add(new Paragraph("Name " + acc.getName()));
 		para.add(new Paragraph("Date of Birth " + acc.getDateOfBirth()));
 		para.add(new Paragraph("Balance " + acc.getBalance()));
 		
 		doc.add(para);
 		
 		response.setContentType("application/pdf");
 		doc.close();
 		
 		}
 		catch (DocumentException e) {
			throw new ServletException(e);
		}
 	}

}
