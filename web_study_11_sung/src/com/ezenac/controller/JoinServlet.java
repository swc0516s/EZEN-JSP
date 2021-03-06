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
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("member/join.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		
		String  name=request.getParameter("name");
		String  userid=request.getParameter("userid");
		String  pwd=request.getParameter("pwd");
		String  email=request.getParameter("email");
		String  phone=request.getParameter("phone");
		String  admin=request.getParameter("admin");
		
		System.out.println(name);
		
		MemberVO mvo=new MemberVO();
		mvo.setName(name);
		mvo.setUserid(userid);
		mvo.setPwd(pwd);
		mvo.setEmail(email);
		mvo.setPhone(phone);
		mvo.setAdmin(Integer.parseInt(admin));
		
		MemberDAO mdao=MemberDAO.getInstance();
		int result=mdao.insertMember(mvo);
		
		HttpSession session=request.getSession();
		
		if(result == 1) {
			session.setAttribute("userid",mvo.getUserid());
			request.setAttribute("message","?????? ????????? ??????????????????.");
		}else {
			request.setAttribute("message","?????? ????????? ??????????????????.");
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("member/login.jsp");
		 dispatcher.forward(request, response);
	}

}
