package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Golden Necklace", "Beautiful 18k gold necklace", 120.99, "https://i.pinimg.com/236x/31/e9/38/31e9389d5ff6b71793cf00603ce4d0f8.jpg" ));
        products.add(new Product(2, "Gold Ring", "Elegant sterling gold ring", 45.50, "https://i.pinimg.com/236x/15/a0/c7/15a0c713071e3d13f399e108cbf2e4fd.jpg" ));
        products.add(new Product(3, "Gold Earrings", "Luxury gold earrings", 350.75, "https://i.pinimg.com/236x/84/5e/19/845e19f452d6105d35a203ce71404637.jpg"));
        products.add(new Product(4, "Gold Bracelet", "Luxury gold Bracelet", 300.75, "https://i.pinimg.com/236x/65/72/b8/6572b868f2b726172d0a7665311abd1c.jpg"));
        products.add(new Product(5, "Gold Watch", "Luxury gold Watch", 950.75,"https://i.pinimg.com/236x/07/71/e5/0771e5b8ce7eba4031377deeda3bff38.jpg"));

        request.setAttribute("products", products);
        request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
    }
}

