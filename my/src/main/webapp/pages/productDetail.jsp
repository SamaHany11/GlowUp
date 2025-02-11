<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlets.Product" %>

<%
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        response.sendRedirect("home.jsp");   
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><%= product.getName() %> - Details</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>
    <header>
        <div class="logo">GlowUp Jewelry</div>
        <nav>
            <ul>
                <li><a href="<%= request.getContextPath() %>/home">Home</a></li>
                <li><a href="<%= request.getContextPath() %>/products">Products</a></li>
                <li><a href="<%= request.getContextPath() %>/logout">Logout</a></li>
            </ul>
        </nav>
    </header>

   <div class="container">
    <div class="product-card">
       <img src="<%= product.getImageUrl() %>" 

             alt="<%= product.getName() %>" class="product-image">
        <h3><%= product.getName() %></h3>
        <p>Price: $<%= product.getPrice() %></p>
        <p>Description: <%= product.getDescription() %></p>
    </div>
</div>

    <footer>
        <p>&copy; 2024 GlowUp Jewelry. All rights reserved.</p>
    </footer>
</body>
</html>
