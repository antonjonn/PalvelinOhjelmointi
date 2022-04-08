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


<h2>Muokkaa kysymyksiä</h2>
<% 	
Question f = (Question)request.getAttribute("question");
//String p = f.getKysymys();
out.println(f);

%>
	<form action="Update" method="post">
	
    <table border="1" align="center" cellpadding="5"
      style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
      <tr>
        <td>Kysymys ID</td>
        
        
        <td><input type="text" name="kysymys_id" required></td>
      </tr>
      <tr>
        <td>Kysymys</td>
        <td><input type="text" name="kysymys" required></td>
      </tr>
      <tr>
        <td align="center"><input type="submit" name="Action"
          value="Edit"></td>
      </tr>
    </table>
    </form>




</body>
</html>