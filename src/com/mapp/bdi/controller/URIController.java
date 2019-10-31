package com.mapp.bdi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String prefix = "/WEB-INF/view";
	private static final String suffix = ".jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		/* /uri/target 인데 substring(4)를 통해 "/uri" 삭제 */
		uri = prefix + uri.substring(4) + suffix;
		
//		String msg = (String)request.getAttribute("msg");
//		msg += "<br> 난 URIController를 거치지!";
//		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	// request : 주문한 거 kitchen에 전달
	// response : 뭘 주문했는지 확인해줌
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
