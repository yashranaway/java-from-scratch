<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .error { color: red; }
        .success { color: green; }
    </style>
</head>
<body>
    <h2>User Management System</h2>
    
    <%-- JSP Declaration --%>
    <%!
        private static final String DB_URL = "jdbc:sqlite:users.db";
        
        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL);
        }
    %>
    
    <%-- Error Handling --%>
    <%
        String errorMessage = null;
        String successMessage = null;
        
        try {
            // Process form submission
            if ("POST".equals(request.getMethod())) {
                String action = request.getParameter("action");
                
                if ("add".equals(action)) {
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    int age = Integer.parseInt(request.getParameter("age"));
                    
                    try (Connection conn = getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(
                             "INSERT INTO users (name, email, age) VALUES (?, ?, ?)")) {
                        pstmt.setString(1, name);
                        pstmt.setString(2, email);
                        pstmt.setInt(3, age);
                        pstmt.executeUpdate();
                        successMessage = "User added successfully!";
                    }
                }
            }
        } catch (Exception e) {
            errorMessage = "Error: " + e.getMessage();
        }
    %>
    
    <%-- Display Messages --%>
    <c:if test="${not empty errorMessage}">
        <p class="error">${errorMessage}</p>
    </c:if>
    <c:if test="${not empty successMessage}">
        <p class="success">${successMessage}</p>
    </c:if>
    
    <%-- Add User Form --%>
    <h3>Add New User</h3>
    <form method="post" action="">
        <input type="hidden" name="action" value="add">
        <p>
            Name: <input type="text" name="name" required><br>
            Email: <input type="email" name="email" required><br>
            Age: <input type="number" name="age" required><br>
            <input type="submit" value="Add User">
        </p>
    </form>
    
    <%-- User List --%>
    <h3>User List</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        
        <%
            try (Connection conn = getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY id")) {
                
                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getInt("id") %></td>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getString("email") %></td>
                        <td><%= rs.getInt("age") %></td>
                        <td>
                            <a href="editUser.jsp?id=<%= rs.getInt("id") %>">Edit</a>
                            <a href="deleteUser.jsp?id=<%= rs.getInt("id") %>" 
                               onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
        <%
                }
            } catch (SQLException e) {
                errorMessage = "Database error: " + e.getMessage();
            }
        %>
    </table>
    
    <%-- Session Information --%>
    <h3>Session Information</h3>
    <p>
        Session ID: <%= session.getId() %><br>
        Creation Time: <fmt:formatDate value="${session.creationTime}" pattern="yyyy-MM-dd HH:mm:ss"/><br>
        Last Accessed: <fmt:formatDate value="${session.lastAccessedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
    </p>
    
    <%-- Application Information --%>
    <h3>Application Information</h3>
    <p>
        Server Info: <%= application.getServerInfo() %><br>
        Servlet Version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
        Context Path: <%= request.getContextPath() %>
    </p>
</body>
</html> 