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
	
		//Memberオブジェクトにまとめる
		Member member = new Member(loginId, password);
		
		//セッションに格納
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		//loginId = member.getLoginId();
		//password = member.getPassword();
		
		//セッションから登録内容を取り出す
				//Member member = (Member) session.getAttribute("member");
				
				//ログインIDとパスワード両方未入力の時
				String errorMessage = null;
				boolean isCorrect = true;
				if(member.getLoginId().isBlank() && member.getPassword().isBlank()) {
					isCorrect = false;
					errorMessage = "値を入力してください";
				}
				if(!isCorrect) {
					//両方未入力の場合
					request.setAttribute("message", errorMessage);
					request.getRequestDispatcher("/WEB-INF/view/login.jsp")
						.forward(request, response);
				}
		//---------------------------------------------------
				//ログインIDの確認(入力値はtaro)
				String idErrorMessage = null;
				boolean isCorrectId = true;
				if(member.getLoginId().isBlank()) {
					isCorrectId = false;
					idErrorMessage = "ログインIDが未入力です";
				} else if(!member.getLoginId().equals("taro")) {
					isCorrectId = false;
					idErrorMessage = "ログインIDが違います";
				}
				
				if(!isCorrectId) {
					//ログインIDが不正な場合
					request.setAttribute("message", idErrorMessage);
					request.getRequestDispatcher("/WEB-INF/view/login.jsp")
						.forward(request, response);
				} else {
					//ログインIDが正しい場合
					session.setAttribute("loginId", true);
				}
		//---------------------------------------------------		
				//パスワードの確認(入力値はpass)
				String passwordErrorMessage = null;
				boolean isCorrectPassword = true;
				
				if(member.getPassword().isBlank()) {
					isCorrectPassword = false;
					passwordErrorMessage = "パスワードが未入力です";
				} else if(!member.getPassword().equals("pass")) {
					isCorrectPassword = false;
					passwordErrorMessage = "パスワードが違います";
				}
				
				if(!isCorrectPassword) {
					//パスワードが不正な場合
					request.setAttribute("message", passwordErrorMessage);
					request.getRequestDispatcher("/WEB-INF/view/login.jsp")
						.forward(request, response);
				} else {
					//パスワードが正しい場合
					session.setAttribute("password", true);
				}
		//---------------------------------------------------	
				//ログインIDとパスワード両方が正しかった時にログイン後の画面(admin/list)に遷移する
				boolean correctId = (boolean) session.getAttribute("loginId");
				boolean correctPassword = (boolean) session.getAttribute("password");
				if(correctId && correctPassword) {
					response.sendRedirect("admin/list");
				}

	}

}
