<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login Page</h2>
    
    <form action="<%= request.getContextPath() %>/login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>

        <button type="submit">Login</button>
    </form>

    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>
</html>
