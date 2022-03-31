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

<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h2>Kysymykset</h2>
<ol>
<c:forEach var="question" items="${requestScope.questionlist}" >
<li>${question.id}: ${question.kysymys} <a href='/delete?id=${kysymys.id}'>delete</a> <a href='/readtoupdate?id=${kysymys.id}'>update</a>
</c:forEach>
</ol>

<%
ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");

for (int i=0;questionList!=null && i<questionList.size();i++){
	Question f=questionList.get(i);
	out.println(f.getKysymys_id()+": "+f.getKysymys()+"<a href='/delete?id="+f.getKysymys_id()+"'>delete</a> <a href='/readtoupdate?id="+f.getKysymys_id()+"'>update</a>");
 //<%@ include file="../html/somehtml.html" //
}
%>


</body>
</html>