<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h1>Kysymykset</h1>

<a href="/createQuestion"> Create new question </a>
<div class="container">
	<div class="row justify-content-center">
		<ol>
			<c:forEach var="question" items="${requestScope.questionlist}" >

				<li>${question.kysymys_id}: ${question.kysymys} <br><a href='/deleteQuestion?id=${question.kysymys_id}'>Delete</a> <a href='/updatequestion?id=${question.kysymys_id}'>Update</a>

			</c:forEach>
		</ol>
	</div>
</div>
<%
// ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");

// for (int i=0;questionList!=null && i<questionList.size();i++){
	
//	Question f=questionList.get(i);
	//out.println(f.getKysymys_id()+": "+f.getKysymys()+"<a href='/deleteQuestion?id="+f.getKysymys_id()+"'>delete</a> <a href='/readtoupdate?id="+f.getKysymys_id()+"'>update</a>");
 //<%@ include file="../html/somehtml.html" //
//}
%>


</body>
</html>