package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import models.Cafe;
import models.NonSystemUser;
import models.Activity;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;
import models.Day;

public class SaveUserActivityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String result = "timeout";
		String nextPage = null;

		Cafe cafe = (Cafe)session.getAttribute("cafe");
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		Day day = new Day(dayOfWeek);

		
		if(cafe!=null){
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			Integer activityId = Integer.parseInt(request.getParameter("activity"));
			String startTime = request.getParameter("start_time");
			String endTime = request.getParameter("end_time");
			String payment = request.getParameter("payment");

			NonSystemUser nsu = new NonSystemUser();

			nsu.setName(name);
			nsu.setGender(gender);
			nsu.setAddress(address);
			nsu.setContact(contact);
			nsu.setActivity(new Activity(activityId));
			nsu.setStartTime(startTime);
			nsu.setEndTime(endTime);
			nsu.setPayment(payment);
			nsu.setCafe(cafe);
			nsu.setDay(day);

			if(nsu.saveUser()){
				result = "success";
				nextPage = "non_system_users_table.jsp";
			}else{
				result = "fail";
			}

			response.getWriter().write(result);
			request.getRequestDispatcher(nextPage).forward(request,response);
		}
	}
}