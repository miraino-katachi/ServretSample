package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Memo;

/**
 * Servlet implementation class OrderServletForSession
 */
@WebServlet("/OrderServletForSession")
public class OrderServletForSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServletForSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// することを取得。
		String todo = "";
		if (request.getParameter("todo") != null && !request.getParameter("todo").isEmpty()) {
			todo = request.getParameter("todo");
		}

		// フォワード先
		String forwardPath = null;

		if (todo.equals("finish")) {
			// 完了の場合
			
			// セッションスコープ内のメモの情報を削除。
			HttpSession session = request.getSession();
			session.removeAttribute("memo");
			
			// フォワード先に完了画面を設定。
			forwardPath = "WEB-INF/jsp/finishOrder.jsp";

		} else if (todo.equals("change")) {
			// 変更の場合
			
			// フォワード先に変更画面を設定。
			forwardPath = "WEB-INF/jsp/changeOrder.jsp";
		} else {
			// その他の場合
			
			// フォワード先にトップ画面を設定。
			forwardPath = "inputOrderForSession.jsp";
		}

		// フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
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

		// メモモデルのインスタンスをセッションスコープにも保存する。 
		HttpSession session = request.getSession();
		session.setAttribute("memo", memo);

		// 確認画面へのフォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirmOrderForSession.jsp");
		dispatcher.forward(request, response);

	}

}
