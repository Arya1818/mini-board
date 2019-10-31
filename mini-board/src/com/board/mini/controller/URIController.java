package com.board.mini.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class URIController extends HttpServlet { //httpServlet접근제어자 protected
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF"; //prefix접두사, 스프링할때 쓰는단어
	private static final String SUFFIX = ".jsp"; //suffix접미사
	
	private static String getForwardURI(HttpServletRequest request) {
		return PREFIX + request.getRequestURI() + SUFFIX;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(getForwardURI(request)); 
		rd.forward(request, response); //request, response를 그대로 담아서 보낸다
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
/*
 *1단계.http요청을 받는다
 *2단계.요청분석(request객체로부터 사용자의 요청 분석하는 코드)
 *3단계.모델을 사용하여 요청한 기능 수행(사용자의 요청에 따라 알맞은 코드)
 *4단계. request나 session에 처리 결과를 저장(request.setAttribute("result",resultObject);이런형태의코드
 *5단계.RequestDispatcher을 사용하여 알맞은 뷰로 포워딩/통로관리자
 *
 * protected 상속과 관련 
 * is has,,  do 하다 doGet
 * 우리는 톰캣한테 "사용자가 view를 보고 싶다는 요청이 들어왔을 때 메모리 만들고 함수 호출해"라고 명령만 내리면 됨!
 * uri controller 는 얘를 웹 안에 넣는 중개자 역할만 함 - 내가보낸 키밸류 값을 먹을 순 없음 그래서 forward할 때 request, response를 보냄.
 */
