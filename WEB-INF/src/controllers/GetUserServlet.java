package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.SystemUser;
import models.Cafe;

public class GetUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Cafe cafe = (Cafe)session.getAttribute("cafe");

		if(cafe!=null){
			ArrayList<SystemUser> systemUser = SystemUser.getAllUsers(cafe.getCafeId());
			response.getWriter().write(new Gson().toJson(systemUser));
		}
	}
}