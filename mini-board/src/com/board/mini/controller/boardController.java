package com.board.mini.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.mini.service.BoardService;

public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		if ("list".equals(cmd)) {
			BoardService bs = new BoardService();
			String path = "/views/board/list";
			if ("list".equals(cmd)) {
				request.setAttribute("boardList", bs.getBoardList());
			}
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		BoardService bs = new BoardService();
		String path = "/views/board/list";
		String msg = "게시물이 저장되었습니다.";
		if("insert".contentEquals(cmd)) {
			Map<String,String> board = new HashMap<>();
			board.put("biTitle", request.getParameter("biTitle"));
			board.put("biContent", request.getParameter("biContent"));
			HttpSession hs = request.getSession();
			Map<String,Object> user = (Map<String,Object>)hs.getAttribute("user");
			board.put("uiNum",user.get("uiNum").toString());
			int result = bs.insertBoard(board);
			if(result!=1) {
				path = "/views/board/insert";
				msg = "뭔진 모르지만 저장 안됨..";
			}
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
