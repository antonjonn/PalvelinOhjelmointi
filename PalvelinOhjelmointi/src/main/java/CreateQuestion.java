
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

@WebServlet("/createquestion")

public class CreateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;


@Override
public void init() {
	dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
}

	//if(request.getParameter("Action").equals("Edit"))

	
    //Question.setKysymys_id(Integer.parseInt(request.getParameter("kysymys_id")));
    //Question.setKysymys(request.getParameter("kysymys"));

  

public CreateQuestion() {
    super();
    // TODO Auto-generated constructor stub
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Question f = null;
//		ArrayList<Question> list = null;
		int id = Integer.parseInt(request.getParameter("id"));
		if (dao.getConnection()) {
//			//list = dao.updateQuestion(null);
			f = dao.readQuestion(id);
			
			ArrayList<String> f = new ArrayList<String>();
			if (dao.getConnection()) {
				candi = dao.readCandidate(id);
				f.add(candi.getEtunimi());
		} else {
			System.out.println("No connection to database");
		}
		
		
		request.setAttribute("question", f);
		response.sendRedirect("/jsp/createquestion.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("/jsp/updatequestion.jsp");
		//rd.forward(request, response);
	}
}