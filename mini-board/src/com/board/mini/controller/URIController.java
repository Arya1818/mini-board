package com.board.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class URIController extends HttpServlet { //httpServlet접근제어자 protected
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter() ; // response에서 get해옴 , 응답객체에게 쓸것조 ㅁ가져와라! 그게 PrintWriter!! 
		out.println("<br>나는 겟방식일때 호출되는 메소드임~"); //디폴트인 utf-8이아닌걸 바라봄, out객체를 통해 response.. 응답객체..
		
		String uri ="/WEB-INF" + request.getRequestURI() + ".jsp";
		out.println("<br>니가 나한테 요청한 페이지: " + uri);
		out.println("<br>니가 보낸 a값: " + request.getParameter("a"));
		
		request.setAttribute("test", "나나나"); //스트링,스트링
		
		RequestDispatcher rd = request.getRequestDispatcher(uri); //Request에 대한 통로 관리자,기관사, 너가 나한테 요청한 uri가 뭔지물어봄.
		rd.forward(request, response); //request, response를 그대로 담아서 보낸다
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		out.println("나는 포스트방식일때 호출되는 메소드임~");
		
		//doGet(request, response);
	}
}
/*
 * protected 상속과 관련 
 * is has,,  do 하다 doGet
 * 우리는 톰캣한테 "사용자가 view를 보고 싶다는 요청이 들어왔을 때 메모리 만들고 함수 호출해"라고 명령만 내리면 됨!
 * uri controller 는 얘를 웹 안에 넣는 중개자 역할만 함 - 내가보낸 키밸류 값을 먹을 순 없음 그래서 foward할 때 request, response를 보냄.
 */
