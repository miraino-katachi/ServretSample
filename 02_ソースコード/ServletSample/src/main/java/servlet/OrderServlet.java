package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Memo;

/**
 * Servlet implementation class Test1
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		
		// 注文内容を取得。
		String order = request.getParameter("order");

		// 注文内容をメモに設定。
		Memo memo = new Memo(order);

		// メモモデルのインスタンスをリクエストスコープに設定する。
		request.setAttribute("memo", memo);
		
		// 確認画面へのフォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirmOrder.jsp");
		dispatcher.forward(request, response);
	}

}
