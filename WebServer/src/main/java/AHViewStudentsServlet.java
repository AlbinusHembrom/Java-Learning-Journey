import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/viewStudents")
public class AHViewStudentsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String formPass = request.getParameter("dbPass");
        HttpSession session = request.getSession();
        session.setAttribute("savedPass", formPass);

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String dbPass = (String) session.getAttribute("savedPass");

        if (dbPass == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        List<Map<String, String>> studentList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/project_db";
        String user = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, dbPass);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

                while (rs.next()) {
                    Map<String, String> student = new HashMap<>();
                    student.put("id", rs.getString("id"));
                    student.put("name", rs.getString("name"));
                    // The 6 AKTU Subjects
                    student.put("oops", rs.getString("oops"));
                    student.put("tafl", rs.getString("tafl"));
                    student.put("maths4", rs.getString("maths4"));
                    student.put("os", rs.getString("os"));
                    student.put("python", rs.getString("python"));
                    student.put("uhv", rs.getString("uhv"));

                    studentList.add(student);
                }
            }

            request.setAttribute("students", studentList);
            request.getRequestDispatcher("display.jsp").forward(request, response);

        } catch (ClassNotFoundException e) {
            response.getWriter().println("<h1>Driver Error:</h1><p>Check if Connector J is in WEB-INF/lib</p>");
        } catch (SQLException e) {
            response.getWriter().println("<h1>Database Error:</h1><p>" + e.getMessage() + "</p>");
            response.getWriter().println("<br><a href='index.jsp'>Back to Home</a>");
        }
    }
}