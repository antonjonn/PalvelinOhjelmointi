<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidate" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>V</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h2>El vaalikone1</h2>
<ol>

<c:forEach var="candidate" items="${requestScope.candidatelist}" >
<li>${candidate.id}: ${candidate.etunimi} ${candidate.sukunimi} <a href='/delete?id=${candidate.id}'>delete</a> <a href='/readtoupdate?id=${candidate.id}'>update</a>
</c:forEach>
</ol>

<%

// ArrayList<Candidate> candidateList=(ArrayList<Candidate>)request.getAttribute("candidatelist");

// for (int i=0;candidateList!=null && i<candidateList.size();i++){
// 	Candidate f=candidateList.get(i);
// 	out.println(f.getId()+": "+f.getEtunimi()+"<a href='/delete?id="+f.getId()+"'>delete</a> <a href='/readtoupdate?id="+f.getId()+"'>update</a>");
 //<%@ include file="../html/somehtml.html" //
// }
%>





</body>
</html>