package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // معلومات الاتصال بقاعدة البيانات
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // تحقق من SID
        String dbUser = "hr"; 
        String dbPassword = "hr"; 

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // تحميل درايفر Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // إنشاء الاتصال بقاعدة البيانات
            conn = DriverManager.getConnection(url, dbUser, dbPassword);
            conn.setAutoCommit(false); // تعطيل الحفظ التلقائي

            // استعلام الإدراج
            String sql = "INSERT INTO USERS (username, password) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            int rowsInserted = pstmt.executeUpdate(); 

            if (rowsInserted > 0) {
                conn.commit(); // تأكيد الحفظ في قاعدة البيانات
                response.getWriter().println("<h2>Registration Successful!</h2>");
            } else {
                response.getWriter().println("<h2>Registration Failed!</h2>");
            }

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback(); // التراجع في حالة حدوث خطأ
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace(); // طباعة الخطأ في الكونسول
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
