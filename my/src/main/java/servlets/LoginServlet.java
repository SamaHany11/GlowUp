package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/pages/login.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // التحقق من صحة البيانات (حاليًا بدون قاعدة بيانات)
        if ("admin".equals(username) && "1234".equals(password)) { 
            HttpSession session = request.getSession();
            session.setAttribute("user", username); // حفظ المستخدم في الجلسة
            response.sendRedirect("pages/home.jsp"); // تحويل المستخدم إلى الصفحة الرئيسية
        } else {
            response.getWriter().println("<h2>Invalid username or password!</h2>");
        }
    }
}

