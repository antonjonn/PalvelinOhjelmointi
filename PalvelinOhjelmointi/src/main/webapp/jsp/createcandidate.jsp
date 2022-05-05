<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

  <head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="/html/mycssfilesomewhere.css">
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Luo uusi ehdokas</title>
  </head>

  <body>
  <script>
function redirect(form){
	var ehdokas= new Object();
	ehdokas.ehdokas_id= 0;
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
	xmlhttp.onreadystatechange = function() {
		window.location.href="/showcandidate";
	}
	xmlhttp.open("POST", "/rest/candidatecreation/new", true);
	xmlhttp.setRequestHeader("Content-type", "application/json");
	xmlhttp.send(jsonEhdokas);
}
	</script>
    <h1>Fill in!</h1>
     <div class="container">
	<div class="row justify-content-center">
    

	<form>
	Sukunimi:<input type='text' name='sukunimi' value=''><br>
	Etunimi: <input type='text' name='etunimi' value=''><br>
	Puolue:<input type='text' name='puolue' value=''><br>
	Kotipaikkakunta: <input type='text' name='paikkakunta' value=''><br>
	Ika:<input type='text' name='ika' value=''><br>
	Miksi eduskuntaan?:<input type='text' name='miksi_eduskuntaan' value=''><br>
	Mita asioita haluat edistaa?:<input type='text' name='mita_edistaa' value=''><br>
	Ammatti<input type='text' name='ammatti' value=''><br>
	<input type='button' name='ok' value='Send' onclick="redirect(this.form);">
	</form>
	</div>
	</div>
  </body>
  
</html>