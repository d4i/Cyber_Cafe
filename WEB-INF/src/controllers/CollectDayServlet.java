package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.Cafe;
import models.Day;

public class CollectDayServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Cafe cafe = (Cafe)session.getAttribute("cafe");

		if(cafe!=null){

			ArrayList<Day> days = Day.getDayName(cafe.getCafeId());
			response.getWriter().write(new Gson().toJson(days));

			//System.out.println(days);
		}
	}
}