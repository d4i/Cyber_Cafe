package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import models.Cafe;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//HttpSession session = request.getSession();

		String nextPage = "index.jsp";
		
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");

		//form validation~~~
		Cafe cafe = new Cafe();

		cafe.setName(name);
		cafe.setContact(contact);
		cafe.setPassword(password);

		if(cafe.registerCafe()){
			nextPage = "login.jsp";
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}
