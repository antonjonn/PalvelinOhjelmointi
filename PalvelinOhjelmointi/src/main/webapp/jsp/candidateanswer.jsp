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

<link rel="stylesheet" type="text/css" href="/html/mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h2>Cantitaatti</h2>

<%
request.getAttribute("candidateanswer");
ArrayList<Candidate> f = (ArrayList)request.getAttribute("candidateanswer");
Candidate b = f.get(0);

out.println("Nimi: " + b.getEtunimi() + " " +  b.getSukunimi() + "<br>");
out.println("Ammatti: " + b.getAmmatti() + "<br>");
out.println("Puolue: " + b.getPuolue() + "<br>");
out.println("Kotipaikkakunta: " + b.getKotipaikkakunta() + "<br>");
out.println("Ikä: " + b.getIka() + "<br>");
out.println("Miksi Eduskuntaan?: " + b.getMiksi_eduskuntaan() + "<br>");
out.println("Mitä asioita haluat edistää?: " + b.getMita_edistaa() + "<br>");
//out.println(f[0]);

%>





</body>
</html>