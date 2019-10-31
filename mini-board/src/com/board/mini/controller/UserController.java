package com.board.mini.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.mini.service.UserService;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		uri = uri.substring(6);
		String url ="/views/user/login";
		String msg ="아이디 비번을 확인해주세요";
		
		if("login".equals(uri)) {
			Map<String,Object> user = us.doLogin(uiId, uiPwd);
			
			
			if(user!=null) {
				HttpSession hs = request.getSession();  //세션유지
				hs.setAttribute("user", user);
				url = "/views/index";
				msg = user.get("uiName") + "님 환영합니다.";
			}
			
		}else if("signup".equals(uri)) {
			Map<String,Object> rMap = us.doSignup(uiName,  uiId,  uiPwd);
			if(rMap!=null) {
				url = (String)rMap.get("url");
				msg = (String)rMap.get("msg");
			}else {
				url = "/views/user/signup";
				msg = "뭔가 잘못돼서 회원가입 안됨";
			}
		}
		request.setAttribute("msg",msg);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
				
//		PrintWriter out = response.getWriter();
//		out.println("uiName:" + uiName); //메서드의실행 getWriter()은 PrintWriter꺼 이건 response꺼
		
	}

}

