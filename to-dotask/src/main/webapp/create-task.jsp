<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file= "menu.jsp" %>
	<div align="center">
		<h1>Create New Task</h1>
		<%String code=request.getParameter("c");
String color="";
String msg="";
if(code!=null)
{
switch(code)
  {
case "200":
color="green";
msg="Task Created Succesfully...";
break;
case "500":
color="red";
msg="Task Creation Failed...Please try to sometime";
break;
  }
}
%>
<%ArrayList<String> erros=(ArrayList<String>)request.getAttribute("errorList");
		if(erros!=null){
		for(String err:erros){
		%>
		<span style="color:red;"><%=err %></span><br>
		<%
		}
		}
		%>
		<h3 style="color:<%=color %>"><%=msg %></h3>
		<form action="view-task.jsp">
			Task title=<input name="title"> <br>
			<br> Task States:<select name="status">
				<option values="open">Open</option>
				<option values="inprogress">In-progress</option>
				<option values="close">Close</option>
			</select> <br>
			<br> Schedule On:
			<input type="date" name="scheduledOn"> <br>
			<br>
			<button type="submit">Create Task</button>
		</form>
	</div>

</body>
</html>