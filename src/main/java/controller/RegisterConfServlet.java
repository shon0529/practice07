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
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションに登録内容が未登録の場合、登録画面へリダイレクト
		HttpSession session = request.getSession();
		if(session.getAttribute("member") == null) {
			response.sendRedirect("register");
			return;
		}
		
		//確認画面の表示
		request.getRequestDispatcher("/WEB-INF/view/register.jsp")
				.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションから登録内容を取り出す
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		//最終的に登録内容を保存する
		System.out.println("以下の内容を登録しました");
		System.out.println("名前:" + member.getName());
		System.out.println("年齢:" + member.getAge());
		System.out.println("メール:" + member.getEmail());
		
		//セッションの内容が不要になったので破棄する
		session.invalidate();
		
		//完了ページへ移動
		response.sendRedirect("registerDone");
	}

}
