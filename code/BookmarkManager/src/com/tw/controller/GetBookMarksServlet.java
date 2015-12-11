package com.tw.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;

import com.tw.service.BookMarksService;
import com.tw.service.ItemService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetBookMarksServlet
 */
public class GetBookMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		Integer pageNum = request.getParameter("pageNum")==null? 1: Integer.parseInt(request.getParameter("pageNum"))+1;
		BookMarksService bookMarksService = new BookMarksService();
		String path = request.getSession().getServletContext().getRealPath("/");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookList", bookMarksService.getBookListByPage(path, pageNum));
        map.put("pageCount", bookMarksService.getPageCount());
        map.put("bookCount", bookMarksService.getBookCount());
		JSONObject json = JSONObject.fromObject(map);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
