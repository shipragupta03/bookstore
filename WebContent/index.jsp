<%@page import="com.entity.UsersBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.BooksBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookServlet" method="get">

	UserName: <input type="text" name="userName" value="" required="true">
	<br/>
	<br/>
	<% 	List<UsersBO> usersList = (ArrayList<UsersBO>) session.getAttribute("usersList");
		List<BooksBO> booksList = (ArrayList<BooksBO>) request.getAttribute("booksList");
		for(BooksBO books: booksList)
		{
	%>
		<% out.println(books.getBookName());%><input type="checkbox" name="<%= books.getBookName()%>">
		<select name="quantity">
			<% for(int i=1;i<=10;i++){ %>
				<option><%=i%></option>
			<% } %>
		</select>
		<br/>
		
	<%
		}
	%>
	<br/>
	<br/>
	<button name="action" value="borrow">Borrow</button>
	<% if(!usersList.isEmpty() || usersList.size()>0){ %>
	<table>
		<tr>
			<th>UserName</th>
			<th>Book Name</th>
			<th>Quantity</th>
			<th>Modify</th>
			<th>Return</th>
		</tr>
		
		<% 
			for(UsersBO users: usersList){ %>
		<tr>
			<td style="display: none"><%= users.getUserId()%></td>
			<td><%= users.getUserName()%></td>
			<td><%= users.getBooks().getBookName()%></td>
			<td><%= users.getBooks().getQuantity()%></td>
			<td><a value="modify" href="BookServlet?button=modify&id=<%= users.getUserId()%>">Modify Quantity</a></td>
			<td><a value="return" href="BookServlet?button=return&id=<%= users.getUserId()%>">Return Book</a></td>
		</tr>
		<% } %>
	
	</table>
	<%} %>
</form>
</body>
</html>