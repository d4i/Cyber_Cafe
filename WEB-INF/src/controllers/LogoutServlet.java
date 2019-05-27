package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import models.Cafe;

public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
			
		Cafe cafe = (Cafe)session.getAttribute("cafe");

		if(cafe!=null){
			session.invalidate();
			request.getRequestDispatcher("login.jsp").forward(request,response);
			//response.sendRedirect("login.jsp");
		}
	}
}