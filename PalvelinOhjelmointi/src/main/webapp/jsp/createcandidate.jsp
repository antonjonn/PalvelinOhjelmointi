<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Luo uusi ehdokas</title>
  </head>

  <body>
    <h1>Fill in!</h1>
	//new form action when done
	<form action="/rest/candidatecreation/new" method="post">
	Sukunimi:<input type='text' name='sukunimi' value=''><br>
	Etunimi: <input type='text' name='etunimi' value=''><br>
	Puolue:<input type='text' name='puolue' value=''><br>
	Kotipaikkakunta: <input type='text' name='paikkakunta' value=''><br>
	Ika:<input type='text' name='ika' value=''><br>
	Miksi eduskuntaan?:<input type='text' name='miksi_eduskuntaan' value=''><br>
	Mita asioita haluat edistaa?:<input type='text' name='mita_edistaa' value=''><br>
	Ammatti<input type='text' name='ammatti' value=''><br>
	<input type='submit' name='ok' value='Send'>
	</form>
  </body>
</html>