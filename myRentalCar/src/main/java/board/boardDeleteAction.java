package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class boardDeleteAction
 */
@WebServlet("/boardDeleteAction")
public class boardDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardDeleteAction() {
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
		
		if(request.getParameter("no")!=null && request.getParameter("password") != null){
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDto board = dao.getBoardByNo(no);
			String password = request.getParameter("password");
			
			if(board.getPassword().equals(password)){
				dao.deleteBoard(no);
				response.sendRedirect("alertAndRedirect?alertMsg=Delete Success!&redirectUrl=board");
			} else {
				response.sendRedirect("alertAndRedirect?alertMsg=Wrong Password&redirectUrl=board");
			}
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
