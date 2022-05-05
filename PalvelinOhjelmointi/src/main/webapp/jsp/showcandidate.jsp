<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>
<%@ page import="services.ReadCandidates"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body onload='readAllCandidates();'>
	<h2>Vaalikone</h2>
	<ol>

	</ol>
	<h1></h1>
	<td><a href='/jsp/createcandidate.jsp'>create candidate</a></td>
	<%
%>
<script>
function readAllCandidates(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsoncandidatelist=this.responseText;
		  //Add JSON string as a content of element resultall
		  //document.getElementById("resultall").innerHTML = jsoncandidatelist;
		  var candilist=JSON.parse(jsoncandidatelist);
		  
		  printAllCandidates(candilist);
	  }
	};
	xmlhttp.open("GET", "/rest/read/candidates", true);
	xmlhttp.send();	
}
function printAllCandidates(list){
	var s="<table border='1'>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr class='clickable-row' >";
		 s=s+"<td>"+ "<a href='/jsp/editcandidate.jsp?id=" + list[i].ehdokas_id + "'>" + list[i].etunimi + " " + list[i].sukunimi;
		//s=s+"<td>"+list[i].sukunimi;
		/* s=s+"<td>"+list[i].ika; 
		s=s+"<td>"+list[i].puolue; 
		s=s+"<td>"+list[i].ammatti; 
		s=s+"<td>"+list[i].kotipaikkakunta; 
		s=s+"<td>"+list[i].miksi_eduskuntaan; 
		s=s+"<td>"+list[i].mita_asioita_haluat_edistaa;  */
		
	}
	s=s+"</table>";
	document.getElementById("candidates").innerHTML=s;
}


</script>
	
 

    <h1>List of all candidates</h1>
    <p id='resultall'></p>
    <div id='candidates' onload='readAllCandidates();'>
    </div> 



</body>
</html>