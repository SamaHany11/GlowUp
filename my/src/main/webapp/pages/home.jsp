<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="servlets.Product" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GlowUp Jewelry - Home</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <header>
        <div class="logo">GlowUp Jewelry</div>
        <nav>
            <ul>
                <li><a href="<%= request.getContextPath() %>/home">Home</a></li>
                <li><a href="<%= request.getContextPath() %>/products">Products</a></li>
                <li><a href="<%= request.getContextPath() %>/about">About Us</a></li>
                <li><a href="<%= request.getContextPath() %>/contact">Contact</a></li>
            </ul>
        </nav>
    </header>

    <h2>Our Jewelry Collection</h2>
    <div class="container">
    <% if (products != null && !products.isEmpty()) { %>
        <% for (Product product : products) { %>
            <div class="product-card">
              <img src="<%= product.getImageUrl() %>" 

                     alt="<%= product.getName() %>" class="product-image">
                <h3><%= product.getName() %></h3>
                <p>Price: $<%= product.getPrice() %></p>
                <a href="<%= request.getContextPath() %>/productDetail?id=<%= product.getId() %>">View Details</a>
            </div>
        <% } %>
    <% } else { %>
        <p>No products available</p>
    <% } %>
</div>

    <footer>
        <p>&copy; 2024 GlowUp Jewelry. All rights reserved.</p>
    </footer>
</body>
</html>
