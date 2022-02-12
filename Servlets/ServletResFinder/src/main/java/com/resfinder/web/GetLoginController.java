package com.resfinder.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resfinder.web.dao.LoginDao;
import com.resfinder.web.model.Login;

//@WebServlet("/getLogin")

/**
 * Servlet implementation class GetLoginController
 */


public class GetLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
	//	int id = Integer.parseInt(request.getParameter("id"));
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		//Login l1=dao.getLogin(id);
		if(dao.check(uname,pass))
		{
			HttpSession session = request.getSession();
		
		session.setAttribute("username", uname);
		//RequestDispatcher rd = request.getRequestDispatcher("showLogin.jsp");
		//rd.forward(request, response);
		response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	//}

}
