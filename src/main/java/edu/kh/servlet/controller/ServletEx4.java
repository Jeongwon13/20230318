package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. extends HttpServlet4 선언

// 2. 애노테이션
@WebServlet("/order")
public class ServletEx4 extends HttpServlet {

	
	// 3. Override 선언 ctrl + space
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	
	// 4. 문자 인코딩
	req.setCharacterEncoding("UTF-8");
	
	// 5. VSCODE에 있는 name 값 req.getParameter~로 가져와서
	// name과 동일한 변수를 각각 만들어 대입해주기 
	String inputNumber = req.getParameter("inputNumber");
	String radio1 = req.getParameter("radio1");
	String hamburger = req.getParameter("hamburger");
	String[] side = req.getParameterValues("side");
	String beverage = req.getParameter("beverage");
	String request = req.getParameter("request");
	
	// 6. 응답 데이터 문서 형식, 문자 인코딩
	resp.setContentType("text/html; charset=UTF-8");
	
	// 7. 응답용 스트림 얻어오기
	PrintWriter out = resp.getWriter();
	
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	
	out.println("<head>");
	out.println("<title>" + "맥도날드 메뉴 선택" + "</title>");
	out.println("</head>");
	
	out.println("<body>");
	
	out.printf("<h3>주문자명 : %s님</h3>\n", inputNumber);
	
	out.println("<h3>");
	if(radio1.equals("세트")) {
		out.println("세트로 주문");
		out.println();
	} else {
		out.println("단품으로 주문");
		out.println();
	}
	out.println("</h3>");
	
	
	out.println("<h3>");
	out.println("주문한 메뉴 : ");
	out.println(hamburger);
	out.println("</h3>");
	
	
	// 사이드 추가
	if(side != null) {
		out.println("추가한 사이드 메뉴");
		
		out.println("<ul>");
		
		 
		// 향상된 for문
		for(String s : side) {
			String temp = "";
			
			switch(s){
			case "yang" :
				temp = "양상추+300원";
					break;
			case "meat" :
				temp = "패티+2000원"; 
					break;
			case "pea" : 
				temp = "피클+500원";
					break;
			}
			
			out.printf("<li>%s</li>\n", temp);
		}
		
		out.println("</ul>");
	}
	
	
	// 음료
	out.println("<h3>");
	out.println("음료 : ");
	out.println(beverage);
	out.println("</h3>");
	
	// 요청사항
	out.println("<h3>" + "요청 사항(알러지 종류, 피클 제외 등)" + "</h3>");
	out.println("<h5>" + "알러지 종류, 피클 제외 등" + "</h5>");
	out.println("<textarea cols=\"30\" rows=\"5\">"+ request + "</textarea>");
	
	
	out.println("</body>");
	out.println("</html>");


	
	 }
}
