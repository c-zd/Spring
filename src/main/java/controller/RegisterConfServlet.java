package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
		
	}

}
