package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

import java.util.ArrayList;
import models.Activity;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent e){
		ServletContext sc = e.getServletContext();

		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");

		ArrayList<Activity> activities = Activity.collectActivities();
		//ArrayList<SystemUser> systemUser = SystemUser.getAllUsers();

		sc.setAttribute("activities",activities);
	}

	public void contextDestroyed(ServletContextEvent e){
		System.out.println("######################");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
		System.out.println("*@*@*@*@*@*@*@*@*@*@*");
	}
}