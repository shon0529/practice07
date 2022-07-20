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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/register.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		//入力値取得
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		
		//年齢を整数に変換
		int age = Integer.parseInt(strAge);
		
		//Memberオブジェクトにまとめる
		Member member = new Member(name, age, email);
		
		//セッションに格納
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		
		//確認ページへリダイレクト
		response.sendRedirect("registerConf");
	}

}
