

import data.Question


public class Update {

}

if (request.getParameter("Action").equals("Edit")) {
    Question.setKysymys_id(Integer.parseInt(request.getParameter("kysymys_id")));
    Question.setKysymys(request.getParameter("kysymys"));

  }