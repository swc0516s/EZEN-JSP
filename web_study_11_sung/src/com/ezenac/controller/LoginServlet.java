package com.ezenac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.MemberDAO;
import com.ezenac.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url="member/login.jsp";
		HttpSession session=request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			url="main.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String url="member/login.jsp";
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		
		MemberDAO mdao=MemberDAO.getInstance();
		int result=mdao.userCheck(userid, pwd);
		
		if(result == 1) {
			MemberVO mvo=mdao.getMember(userid);
			
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", mvo);
			request.setAttribute("message","?????? ????????? ??????????????????.");
			url="main.jsp";
		}else if(result == 0) {
			request.setAttribute("message","?????? ????????? ?????? ????????????.");
		}else if(result == -1) {
			request.setAttribute("message","???????????? ?????? ???????????????.");
		}
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		 dispatcher.forward(request, response);
	}

}








