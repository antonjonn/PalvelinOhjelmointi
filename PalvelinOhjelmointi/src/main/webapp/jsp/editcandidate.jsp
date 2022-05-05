<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>
<%@ page import="services.CandidatePage"%>
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
<body onload='readCandidate();'>
	<h2>Vaalikone</h2>
	<ol>

	</ol>
	<h1></h1>
	<%
%>
<script>
function readCandidate(){
	 
	 const queryString = window.location.search;
	  const urlParams = new URLSearchParams(queryString);
	 const ehdokas_id = urlParams.get('id');
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsoncandidatelist=this.responseText;
		  //Add JSON string as a content of element resultall
		  //document.getElementById("resultall").innerHTML = jsoncandidatelist;
		  var candilist=JSON.parse(jsoncandidatelist);
		  
		 //Ehdokkaat ehdokas = JSON.parse(jsoncandidatelist);
		 
		  printOneCandidate(candilist);
	  }
	};
	
	xmlhttp.open("GET", "/rest/showcandidate/candidate/" + ehdokas_id, true);
	xmlhttp.send();	
}
function printOneCandidate(list){
	var s="<table border='1'>";
	//for (i in list){//or for (var i=0;i<list.length;i++){
		
		s=s+"<tr class='clickable-row' >";
		 s=s+"<tr>  <td> <b>Nimi: </b>" + list.etunimi + " " +  list.sukunimi + "</td>";
		 s=s+"<tr> <td> <b>Ika: </b>" + list.ika + "</td>";
		 s=s+"<tr> <td> <b>Puolue: </b>" + list.puolue + "</td>";
		 s=s+"<tr>  <td> <b>Ammatti: </b>" + list.ammatti + "</td>";
		 s=s+"<tr>  <td> <b>Kotipaikkakunta: </b>" + list.kotipaikkakunta + "</td>";
		 s=s+"<tr>  <td> <b>Miksi eduskuntaan: </b>" + list.miksi_eduskuntaan + "</td>";
		 s=s+"<tr>  <td> <b> Mita asioita haluat edistaa: </b>" + list.mita_asioita_haluat_edistaa + "</td>";
		 
		 //var Ehdokas = Object.Assign({}, list);
		//s=s+"<td>"+list[i].sukunimi;
		/* s=s+"<td>"+list[i].ika; 
		s=s+"<td>"+list[i].puolue; 
		s=s+"<td>"+list[i].ammatti; 
		s=s+"<td>"+list[i].kotipaikkakunta; 
		s=s+"<td>"+list[i].miksi_eduskuntaan; 
		s=s+"<td>"+list[i].mita_asioita_haluat_edistaa;  */
		
	//}
	s=s+"</table>";
	document.getElementById("candidates").innerHTML=s;
}

	

</script>
	
 <h1>Candidate</h1>
    <p id='resultall'></p>
    <div id='candidates' onload='readCandidate();'>
    </div> 

    



</body>
</html>