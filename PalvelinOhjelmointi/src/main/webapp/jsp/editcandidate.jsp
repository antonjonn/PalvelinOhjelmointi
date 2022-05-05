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
<link rel="stylesheet" type="text/css" href="/html/mycssfilesomewhere.css">
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
function editcandidate(form){
	 const queryString = window.location.search;
	  const urlParams = new URLSearchParams(queryString);
	 const ehdokas_id = urlParams.get('id');
	var ehdokas= new Object();
	ehdokas.ehdokas_id=ehdokas_id;
	ehdokas.sukunimi=form.sukunimi.value;
	ehdokas.etunimi=form.etunimi.value;
	ehdokas.puolue=form.puolue.value;
	ehdokas.kotipaikkakunta=form.paikkakunta.value;
	ehdokas.ika=form.ika.value;
	ehdokas.miksi_eduskuntaan=form.miksi_eduskuntaan.value;
	ehdokas.mita_asioita_haluat_edistaa=form.mita_edistaa.value;
	ehdokas.ammatti=form.ammatti.value;
	var jsonEhdokas=JSON.stringify(ehdokas);
	var xmlhttp=new XMLHttpRequest();
	
	xmlhttp.open("PUT", "/rest/editcandidate/edit", true);
	xmlhttp.setRequestHeader("Content-type", "application/json");
	xmlhttp.send(jsonEhdokas);
	location.reload();
}
function printOneCandidate(list){
	var s=" <table border='1'>";
	//for (i in list){//or for (var i=0;i<list.length;i++){
		
		s=s+"<tr class='clickable-row' >";
		 s=s+"<tr>  <td> <b>Nimi: </b>" + list.etunimi + " " +  list.sukunimi + "</td>";
		 s=s+"<tr> <td> <b>Ika: </b>" + list.ika + "</td>";
		 s=s+"<tr> <td> <b>Puolue: </b>" + list.puolue + "</td>";
		 s=s+"<tr>  <td> <b>Ammatti: </b>" + list.ammatti + "</td>";
		 s=s+"<tr>  <td> <b>Kotipaikkakunta: </b>" + list.kotipaikkakunta + "</td>";
		 s=s+"<tr>  <td> <b>Miksi eduskuntaan: </b>" + list.miksi_eduskuntaan + "</td>";
		 s=s+"<tr>  <td> <b> Mita asioita haluat edistaa: </b>" + list.mita_asioita_haluat_edistaa + "</td>";

	s=s+"</table>";
	document.getElementById("candidates").innerHTML=s;
	document.getElementsByName("sukunimi")[0].value=list.sukunimi;
	document.getElementsByName("etunimi")[0].value=list.etunimi;
	document.getElementsByName("ika")[0].value=list.ika;
	document.getElementsByName("ammatti")[0].value=list.ammatti;
	document.getElementsByName("puolue")[0].value=list.puolue;
	document.getElementsByName("mita_edistaa")[0].innerHTML=list.mita_asioita_haluat_edistaa;
	document.getElementsByName("miksi_eduskuntaan")[0].innerHTML=list.miksi_eduskuntaan;
	document.getElementsByName("paikkakunta")[0].value=list.kotipaikkakunta;
}

	

</script>
	
 <h1>Candidate</h1>
 <div class="container">
	<div class="row justify-content-center">
    <p id='resultall'></p>
    <div id='candidates'>
    </div> 
    
     <h2>Edit Candidate Information</h2>
     
<form>
	Sukunimi:<input type='text' name='sukunimi' value=''><br>
	Etunimi: <input type='text' name='etunimi' value=''><br>
	Puolue:<input type='text' name='puolue' value=''><br>
	Kotipaikkakunta: <input type='text' name='paikkakunta' value=''><br>
	Ika:<input type='text' name='ika' value=''><br>
	Miksi eduskuntaan?:<textarea name='miksi_eduskuntaan'> </textarea><br>
	Mita asioita haluat edistaa?:<textarea name='mita_edistaa' > </textarea><br>
	Ammatti<input type='text' name='ammatti' value=''><br>
	<input type='button' name='ok' value='Send' onclick="editcandidate(this.form);">
	</form>
    </div> 
</div> 


</body>
</html>