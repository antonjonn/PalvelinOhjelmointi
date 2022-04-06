
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

@WebServlet(
    name = "DeleteQuestion",
    urlPatterns = {"/deleteQuestion"}
)
public class DeleteQuestion extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("id"));
		//ArrayList<Question> list=dao.readAllQuestions();
		if (dao.getConnection()) {
			dao.deleteQuestion(id);
		}
		else {
			System.out.println("connection failed");
		}
		
		//request.setAttribute();//"questionlist", list
		
		response.sendRedirect("showquestion");
	}
}