<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<h2>El vaalikone</h2>
	<ol>

	</ol>
	<h1>Vaalikone</h1>
	<%
ArrayList<Candidate> candidateList=(ArrayList<Candidate>)request.getAttribute("candidatelist");
//?id=${candidate.id}
for (int i=0;candidateList!=null && i<candidateList.size();i++){
	Candidate f=candidateList.get(i);
	
	//out.println(f.getId()+": "+f.getEtunimi()+"<a href='/jsp/candidateanswer.jsp"+"'>Select Candidate</a> <br>");
	
	//out.println("<form name=" + "sendId" + "method=POST" + f.getId()+": "+f.getEtunimi()+ "<a href='/jsp/candidateanswer.jsp"+"'>Select Candidate</a>" + "</form>");

	
	out.println(
		"<form name=submitForm method=" + "POST" + "action=" + "/jsp/candidateanswer.jsp" + ">"
		+ "<input type=" + "button"  + " " + "name=" + "param1"  + " " +  "value=" + f.getId() + " >" +
    "<A HREF=" + "/jsp/candidateanswer.jsp" + ">" +  f.getEtunimi() + " " +  f.getSukunimi() +  "</A>" + 
	"</form>" 
    		//+
	//"<input type=" + "button"  + "id=" + f.getId() + "name=" + "fav_language" + "value=" + "HTML" + ">"
    
    );
	
	//<a href='/readtoupdate?id="+f.getId()+"'>update</a> 
	//out.println(i);
	//<%@ include file="../html/somehtml.html" //+f.getId() ?id=" +f.getId()
}

%>





</body>
</html>