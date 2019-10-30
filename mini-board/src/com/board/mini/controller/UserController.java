package com.board.mini.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.mini.service.UserService;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doGet(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
//		response.setContentType("text/html;charset=utf-8");  //먼저 알려줘야함 (근데 보내는쪽에 이미 셋팅되어있으니 여기서 없어도됨)
				
		String uiName = request.getParameter("uiName"); //signup.jsp의 이름의 name을 바라봄!
		//System.out.println(uiName); // 웹에 회원가입 창 다 입력하고 회원가입 버튼 누르면 콘솔창에찍힘
		String uiId = request.getParameter("uiId");
		String uiPwd = request.getParameter("uiPwd");
		UserService us = new UserService();
		String uri = request.getRequestURI();
		System.out.println(uri.substring(6)); //잘라내서 뒤에 값만 받는다.
	
				
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("uiName:" + uiName); //메서드의실행 getWriter()은 PrintWriter꺼 이건 response꺼
		
	}

}

