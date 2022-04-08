import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Candidate;

/**
 * Servlet implementation class CandidateAnswer
 */
@WebServlet("/CandidateAnswer")

public class CandidateAnswer extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Dao dao=null;

	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
	}
	/**
     * @see HttpServlet#HttpServlet()
     */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		ArrayList<String> yeppers = new ArrayList<String>();
		Candidate candi = null;
		String ye = null;
		ArrayList<String> f = new ArrayList<String>();
		if (dao.getConnection()) {
			candi = dao.readCandidate(id);
			f.add(candi.getEtunimi());
			yeppers.add(candi.getEtunimi() + candi.getSukunimi() + candi.getAmmatti() + candi.getIka() + candi.getKotipaikkakunta() + candi.getMiksi_eduskuntaan() + candi.getMita_edistaa() + candi.getPuolue());
		}
		else {
			System.out.println("No connection to database");
		}
	
		request.setAttribute("candidateanswer", yeppers);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/candidateanswer.jsp");
		rd.forward(request, response);
	}}