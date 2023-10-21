<%@ page import="com.antiques.antiques.dbManager.DbManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%
    DbManager db = new DbManager();
    Connection conn = db.getConnection();
%>
<br/>
</body>
</html>