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

<link rel="stylesheet" type="text/css" href="/html/mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>


<h2>Luo uusi kysymys</h2>
 <div class="container">
	<div class="row justify-content-center">
<% 	
String Kysymys = request.getParameter("kysymys");

%>

	<form action="/createquestion" method="post">
	
    <table border="1" align="center" cellpadding="5"
      style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
      <tr>
        <td>Kysymys</td>
        <td><input type="text" name="kysymys" required></td>
      </tr>
      <tr>
        <td>Järjestys numero</td>
        <td><input type="text" name="kysjar" required></td>
      </tr>
      <tr>
        <td align="center"><input type="submit" name="Action"
          value="Edit"></td>
      </tr>
    </table>
    </form>
    </div>
    </div>




</body>
</html>