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
 * Servlet implementation class RegisterConfServlet
 */
@WebServlet("/registerConf")
public class RegisterConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションに登録内容が未保存の場合、登録画面へリダイレクト
		HttpSession session = request.getSession();
		if(session.getAttribute("member") == null) {
			response.sendRedirect("login");
			return;
		}
		
		//確認画面の表示
		request.getRequestDispatcher("/WEB-INF/view/registerConf.jsp")
			.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションから登録内容を取り出す
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		//将来的に、データベースに登録内容を保存する
		System.out.println("以下の内容でログインします");
		System.out.println("ログインID：" + member.getLoginId());
		System.out.println("パスワード：" + member.getPassword());
		
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
		
		//ログインIDとパスワード両方が正しかった時にログイン後の画面(admin/list)に遷移する
		boolean correctId = (boolean) session.getAttribute("loginId");
		boolean correctPassword = (boolean) session.getAttribute("password");
		if(correctId && correctPassword) {
			response.sendRedirect("admin/list");
		}
	
		
	}

}
