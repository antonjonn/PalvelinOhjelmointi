import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Candidate;
/**
 * Servlet implementation class ShowCandidate
 */
@WebServlet("/showcandidate")


public class ShowCandidate extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Dao dao=null;

	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
	}
	/**
     * @see HttpServlet#HttpServlet()
     */
	
	public ShowCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Candidate> list=null;
		if (dao.getConnection()) {
			list=dao.readAllCandidates();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("candidatelist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidate.jsp");
		rd.forward(request, response);
	}
}














