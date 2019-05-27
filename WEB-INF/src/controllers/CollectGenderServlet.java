package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import models.Cafe;
import models.SystemUser;

import com.google.gson.Gson;

public class CollectGenderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Cafe cafe = (Cafe)session.getAttribute("cafe");
		if(cafe!=null){
			ArrayList<SystemUser> gender = SystemUser.getGenderRatio(cafe.getCafeId());

			response.getWriter().write(new Gson().toJson(gender));

			System.out.println(gender);
			System.out.println(gender.get(0));
			System.out.println(gender.get(1));
		}		
	}
}