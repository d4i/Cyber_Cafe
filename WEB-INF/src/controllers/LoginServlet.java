package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import models.Cafe;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String nextPage = "login.jsp";

		HttpSession session = request.getSession();

		String contact = request.getParameter("contact");
		String password = request .getParameter("password");	
		
		Cafe cafe = new Cafe(contact,password);

		if(cafe.loginCafe()){
			//System.out.println(cafe.loginCafe()+"~~~~~~~@@@@@@@");
			nextPage = "dashboard.jsp";
			session.setAttribute("cafe",cafe);
		}/*else{
			session.setAttribute("emessage","Either username or password is incorrect");
		}*/

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}