
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Question;
/**
 * Servlet implementation class ShowQuestion
 */
@WebServlet("/showquestion")


public class ShowQuestion extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Dao dao=null;

	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
	}
	/**
     * @see HttpServlet#HttpServlet()
     */
	
	public ShowQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			list=dao.readAllQuestions();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestion.jsp");
		rd.forward(request, response);
	}
}

