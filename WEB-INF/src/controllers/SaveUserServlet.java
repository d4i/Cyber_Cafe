package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;

import models.SystemUser;
import models.Cafe;
import models.Day;

public class SaveUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String result = "timeout";

		Cafe cafe = (Cafe)session.getAttribute("cafe");
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		Day day = new Day(dayOfWeek);

		if(cafe!=null){

			String nextPage = null;
			
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			String systemNo = request.getParameter("system_no");
			String startTime = request.getParameter("start_time");
			String endTime = request.getParameter("end_time");
			String payment = request.getParameter("payment");
			
			SystemUser systemUser = new SystemUser();

			systemUser.setName(name);
			systemUser.setGender(gender);
			systemUser.setAddress(address);
			systemUser.setContact(contact);
			systemUser.setSystemNo(systemNo);
			systemUser.setStartTime(startTime);
			systemUser.setEndTime(endTime);
			systemUser.setPayment(payment);
			systemUser.setCafe(cafe);	
			systemUser.setDay(day);		//~~~~~~~~~~~~~~~~~

			if(systemUser.saveUser()){
				result = "success";
				nextPage = "system_users_table.jsp";
			}else{
				result = "fail";
			}
			response.getWriter().write(result);
			request.getRequestDispatcher(nextPage).forward(request,response);
		}		
	}
}
