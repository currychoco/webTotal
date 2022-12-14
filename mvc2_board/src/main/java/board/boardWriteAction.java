package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class boardWriteAction
 */
@WebServlet("/boardWriteAction")
public class boardWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardWriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		BoardDao dao = BoardDao.getInstance();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(title);
		System.out.println(content);
		if(title != null && content != null){

			String user = request.getParameter("user");
			String password = request.getParameter("password");

			BoardDto board = new BoardDto(title, content, user, password);
			dao.createBoard(board);
			response.sendRedirect("alertAndRedirect?alertMsg=Save Success!&redirectUrl=index");
		}else {
			response.sendRedirect("alertAndRedirect?alertMsg=Save Failed&redirectUrl=index");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
