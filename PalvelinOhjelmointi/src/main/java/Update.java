
import dao.Dao;
import data.Question

@WebServlet("/updatequestion")

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

}

@Override
public void init() {
	dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
}

	if(request.getParameter("Action").equals("Edit"))

	{
    Question.setKysymys_id(Integer.parseInt(request.getParameter("kysymys_id")));
    Question.setKysymys(request.getParameter("kysymys"));

  }

public Update() {
    super();
    // TODO Auto-generated constructor stub
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Question> list = null;
		if (dao.getConnection()) {
			list = dao.updateQuestion();
		} else {
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/updatequestion.jsp");
		rd.forward(request, response);
	}
}