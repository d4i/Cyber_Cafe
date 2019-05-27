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
import models.SystemUser;
import models.NonSystemUser;

public class CollectIncomeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Cafe cafe = (Cafe)session.getAttribute("cafe");

		if(cafe!=null){

			ArrayList<SystemUser> payment = SystemUser.getUserPayment(cafe.getCafeId());
			
			/////~~~~~~~~~
			/*
			ArrayList<NonSystemUser> payment2 = NonSystemUser.getUserPayment(cafe.getCafeId());

			ArrayList<Object> payments = new ArrayList<Object>();

			payments.add(payment);
			payments.add(payment2);

			
			response.getWriter().write(new Gson().toJson(payments));
			//response.getWriter().write(new Gson().toJson(payments.get(1)));

			System.out.println(payments.get(0)+"!!!!!!!!!");
			System.out.println(payments.get(1)+"~~~~~~~~~~~~");
			*/
			//~~~~~~~~~~~~~~~~~~~

			response.getWriter().write(new Gson().toJson(payment));
		}
	}
}