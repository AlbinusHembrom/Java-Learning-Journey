package com.example.webserver;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/addStudent")
public class AHStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 1. Capture Basic Info
        String id = request.getParameter("studentId");
        String name = request.getParameter("studentName");

        // Use the password from the form (hidden or visible)
        String dbPass = request.getParameter("dbPass");

        // 2. Capture all 6 Subject Marks
        String oops = request.getParameter("oops");
        String tafl = request.getParameter("tafl");
        String maths4 = request.getParameter("maths4");
        String os = request.getParameter("os");
        String python = request.getParameter("python");
        String uhv = request.getParameter("uhv");

        HttpSession session = request.getSession();

        // Safety: If the form didn't send a password, try to get the one already in the session
        if (dbPass == null || dbPass.isEmpty()) {
            dbPass = (String) session.getAttribute("savedPass");
        } else {
            // If the form DID send it, update the session to keep it fresh
            session.setAttribute("savedPass", dbPass);
        }

        String url = "jdbc:mysql://localhost:3306/project_db";
        String user = "root";

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, dbPass)) {
                // SQL query with 8 placeholders (ID, Name + 6 Subjects)
                String sql = "INSERT INTO students (id, name, oops, tafl, maths4, os, python, uhv) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Set Data
                pstmt.setInt(1, Integer.parseInt(id));
                pstmt.setString(2, name);
                pstmt.setInt(3, Integer.parseInt(oops));
                pstmt.setInt(4, Integer.parseInt(tafl));
                pstmt.setInt(5, Integer.parseInt(maths4));
                pstmt.setInt(6, Integer.parseInt(os));
                pstmt.setInt(7, Integer.parseInt(python));
                pstmt.setInt(8, Integer.parseInt(uhv));

                pstmt.executeUpdate();
            }

            // 3. SUCCESS REDIRECT
            // Set a message in the session to show on the index page
            session.setAttribute("message", "Record for " + name + " (Roll No: " + id + ") saved successfully!");
            response.sendRedirect("index.jsp");

        } catch (Exception e) {
            // 4. ERROR HANDLING
            // If something goes wrong, show the error so you can debug
            response.setContentType("text/html");
            response.getWriter().println("<div style='text-align:center; font-family:sans-serif; margin-top:50px; color:red;'>");
            response.getWriter().println("<h1>❌ Database Error</h1>");
            response.getWriter().println("<p>" + e.getMessage() + "</p>");
            response.getWriter().println("<a href='index.jsp'>Return to Home</a>");
            response.getWriter().println("</div>");
            e.printStackTrace();
        }
    }
}