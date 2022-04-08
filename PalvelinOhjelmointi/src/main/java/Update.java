
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

@WebServlet("/updatequestion")

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;


@Override
public void init() {
	dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
}

	//if(request.getParameter("Action").equals("Edit"))

	
    //Question.setKysymys_id(Integer.parseInt(request.getParameter("kysymys_id")));
    //Question.setKysymys(request.getParameter("kysymys"));

  

public Update() {
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
		ArrayList<String> list = null;
		int id = Integer.parseInt(request.getParameter("id"));
		if (dao.getConnection()) {
			f = dao.readQuestion(id);
			list.add(f.getKysymys_id(), f.getKysymys());
		} else {
			System.out.println("No connection to database");
		}
		
		
		request.setAttribute("question", list);
		response.sendRedirect("/jsp/updatequestion.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("/jsp/updatequestion.jsp");
		//rd.forward(request, response);
	}
}