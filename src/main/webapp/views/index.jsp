<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <p> Gagandeep Webpage </p>
   
  <%-- this is old code for num1 and num2 without seperate Model
  <form action="add">
   		Enter 1st number  : <input type="text" 	name="num1"><br>
	    Enter 2st number  : <input type="text" 	name="num2"><br>
	   	<input type="submit" >
	</form>
 --%> 
   
   <form action="addAlien" method="post">
   		Enter 1st id	  : <input type="text" 	name="aid"><br>
	    Enter 2st name  : <input type="text" 	name="aname"><br>
	   	<input type="submit" >
	</form>
	<hr>
	<form action="getAlien">
   		Enter Your ID	  : <input type="text" 	name="aid"><br>
	   	<input type="submit" >
	</form>
   <hr>
	<form action="getAlienByName">
   		Enter Your Name	  : <input type="text" 	name="aname"><br>
	   	<input type="submit" >
	</form>
   
   
</body>
</html>