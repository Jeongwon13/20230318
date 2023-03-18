package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/smartRemote")
public class ServletEx5 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		String[] main = req.getParameterValues("main");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>" + "스마트센서?" + "</title>");
		out.println("</head>");
		
		out.println("<body>");
			
			if(main.equals("gas")) {
				out.println("<h3>" + "gas" + "</h3>");
				out.println("<p>" + "밸브 잠그기" + "</p>");
				
			} else if(main.equals("air")) {
				out.println("<h3>" + "air" + "</h3>");
				out.println("<p>" + "에어컨 켜기" + "</p>");
			
			} else if(main.equals("temperal")) {
				out.println("<h3>" + "temperal" + "</h3>");
				out.println("<p>" + "온도 조절하기" + "</p>");
			} else if(main.equals("light")) {
				out.println("<h3>" + "light" + "</h3>");
				out.println("<p>" + "조명 켜기" + "</p>");
			}
			
		
		
	 
		out.println("</body>");
		out.println("</html>");


		
		 }
	}
