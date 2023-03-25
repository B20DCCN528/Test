<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddBook</title>
</head>
<body>
	<form action="books" method="post">
		Title: <input type="text" name="title"></br>
		Author: <input type="text" name="author"></br>
		Category: <input type="number" name="category"></br>
		Sold: <input type="number" name="sold"></br>
		<input type="submit" name="Add Book">
	</form>
</body>
</html>