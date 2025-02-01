package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//フォワード
		request.getRequestDispatcher("WEB-INF/view/login.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		//入力値取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		//System.out.println(loginId);
		//System.out.println(password);
		
		//Memberオブジェクトにまとめる
		Member member = new Member(loginId, password);
		
		//セッションに格納
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		
		//確認ページへリダイレクト
		response.sendRedirect("registerConf");
	}

}
