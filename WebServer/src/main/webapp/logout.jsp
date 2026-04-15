<%
    session.invalidate(); // Wipes the saved password
    response.sendRedirect("index.jsp");
%>