<%@page import="edu.todotask.controller.Task"%>
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
<%@include file="menu.jsp" %>
<input type="search" id="gsearch" name="gsearch">
<table class="table table-hover">
<thead>
<tr>
<th>Title</th>
<th>Status</th>
<th>ScheduedOn</th>
<th>UpdateOn</th>
</tr>
</thead>
<tbody>
<%


ArrayList<Task> list =(ArrayList<Task>) request.getAttribute("myTasks");
   for(Task t : list) {
	   
%>
<tr>
<td><%=t.getTitle()%></td>
<td><%=t.getStatus()%></td>
<td><%=t.getScheduledOn() %></td>
<td><%=t.getUpdateOn() %></td>
<td>
<a href='GetIdTask?id=<%=t.getId()%>'>Edit</a>
<a href='#?id=<%=t.getId()%>'>Delete</a>
</td>
</tr>
<%
}
%>
</tbody>

</table>
</body>
</html>