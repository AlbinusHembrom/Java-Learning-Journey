        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Academic Dashboard - Semester IV</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .display-card {
            border: none;
            border-radius: 20px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            background-color: white;
        }
        .table thead {
            background-color: #4e73df;
            color: white;
            font-size: 0.8rem;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        .avg-column { background-color: #f8f9fc; font-weight: bold; }
        .status-badge { font-size: 0.75rem; padding: 0.4em 0.8em; border-radius: 50px; }

        @media print {
            .no-print { display: none; }
            .display-card { box-shadow: none; border: 1px solid #ddd; }
        }
    </style>
</head>
<body>

<%
    // SESSION CHECK: If the user tries to access this page after the 30m timeout
    String savedPass = (String) session.getAttribute("savedPass");
    if (savedPass == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    List<Map<String, String>> students = null;%>

<div class="container-fluid py-5">
    <div class="row justify-content-center">
        <div class="col-xl-11">
            <div class="card display-card p-4 shadow">

                <div class="d-flex justify-content-between align-items-center mb-4 no-print">
                    <div>
                        <h2 class="fw-bold text-dark mb-0">Academic <span class="text-primary">Dashboard</span></h2>
                        <p class="text-muted small mb-0"><i class="bi bi-database-check"></i> Connected to project_db</p>
                    </div>
                    <div class="btn-group">
                        <a href="index.jsp" class="btn btn-outline-primary border-2">
                            <i class="bi bi-plus-circle"></i> Add Student
                        </a>
                        <button onclick="window.print()" class="btn btn-primary">
                            <i class="bi bi-printer"></i> Print Report
                        </button>
                    </div>
                </div>

                <div class="row mb-4 no-print">
                    <div class="col-md-6">
                        <div class="input-group shadow-sm">
            <span class="input-group-text bg-white border-end-0">
                <i class="bi bi-search text-primary"></i>
            </span>
                            <input type="text" id="searchInput" onkeyup="filterTable()"
                                   class="form-control border-start-0 ps-0"
                                   placeholder="Search by Roll No or Student Name...">
                        </div>
                    </div>
                    <div class="col-md-6 text-md-end pt-2">
        <span class="badge bg-light text-dark border">
            Showing <span id="visibleCount"><%=(students != null) ? students.size() : 0%></span> Records
        </span>
                    </div>

                </div>

                <div class="table-responsive">
                    <table class="table table-hover table-bordered align-middle text-center">
                        <thead>
                        <tr>
                            <th>Roll No</th>
                            <th class="text-start">Name</th>
                            <th>OOPS</th>
                            <th>TAFL</th>
                            <th>Maths-IV</th>
                            <th>OS</th>
                            <th>Python</th>
                            <th>UHV</th>
                            <th class="avg-column">Average</th>
                            <th>Grade</th>
                            <th>Result</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            students = (List<Map<String, String>>) request.getAttribute("students");
                            int totalPass = 0;
                            int totalStudents = 0;

                            if (students != null && !students.isEmpty()) {
                                totalStudents = students.size();
                                for (Map<String, String> s : students) {
                                    // Null-safe parsing
                                    int m1 = Integer.parseInt(s.getOrDefault("oops", "0"));
                                    int m2 = Integer.parseInt(s.getOrDefault("tafl", "0"));
                                    int m3 = Integer.parseInt(s.getOrDefault("maths4", "0"));
                                    int m4 = Integer.parseInt(s.getOrDefault("os", "0"));
                                    int m5 = Integer.parseInt(s.getOrDefault("python", "0"));
                                    int m6 = Integer.parseInt(s.getOrDefault("uhv", "0"));

                                    double average = (m1 + m2 + m3 + m4 + m5 + m6) / 6.0;

                                    String grade;
                                    String gradeClass;
                                    if (average >= 90) {
                                        grade = "A+";
                                        gradeClass = "text-success";
                                    } else if (average >= 80) {
                                        grade = "A";
                                        gradeClass = "text-primary";
                                    } else if (average >= 70) {
                                        grade = "B";
                                        gradeClass = "text-info";
                                    } else if (average >= 60) {
                                        grade = "C";
                                        gradeClass = "text-warning";
                                    } else if (average >= 50) {
                                        grade = "D";
                                        gradeClass = "text-secondary";
                                    } else {
                                        grade = "F";
                                        gradeClass = "text-danger";
                                    }

                                    boolean isPass = average >= 33;
                                    if (isPass) totalPass++;
                        %>
                        <tr>
                            <td class="fw-bold text-muted"><%=s.getOrDefault("id", "??")%></td>
                            <td class="text-start fw-bold"><%=s.getOrDefault("name", "N/A")%></td>
                            <td><%=m1%></td>
                            <td><%=m2%></td>
                            <td><%=m3%></td>
                            <td><%=m4%></td>
                            <td><%=m5%></td>
                            <td><%=m6%></td>
                            <td class="avg-column text-primary">
                                <%=String.format("%.2f", average)%>%
                            </td>
                            <td class="fw-bold <%=gradeClass%>"><%=grade%></td>
                            <td>
                                <% if (isPass) { %>
                                <span class="badge bg-success-soft text-success border border-success status-badge">PASS</span>
                                <% } else { %>
                                <span class="badge bg-danger-soft text-danger border border-danger status-badge">FAIL</span>
                                <% } %>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="11" class="py-5 text-muted">No records available.</td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>

                <div class="mt-4 pt-3 border-top d-flex justify-content-between align-items-center">
                    <div class="text-muted small">
                        <strong>Stats:</strong> <%=totalStudents%> Enrolled | <%=totalPass%> Passed
                    </div>
                    <div class="text-muted" style="font-size: 0.7rem;">
                        Calculation Method: $$ \text{Average} = \frac{\sum_{i=1}^{6} \text{Subject}_i}{6} $$
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function filterTable() {
        // 1. Get the search string
        let input = document.getElementById("searchInput");
        let filter = input.value.toLowerCase();

        // 2. Get the table body and all its rows
        let tableBody = document.querySelector("table tbody");
        let rows = tableBody.getElementsByTagName("tr");
        let visibleCount = 0;

        // 3. Loop through rows and hide those that don't match
        for (let i = 0; i < rows.length; i++) {
            // Skip the "No records found" row if it exists
            if (rows[i].cells.length < 2) continue;

            // We search in Roll No (Cell 0) and Name (Cell 1)
            let rollNo = rows[i].cells[0].textContent || rows[i].cells[0].innerText;
            let name = rows[i].cells[1].textContent || rows[i].cells[1].innerText;

            let combinedText = (rollNo + " " + name).toLowerCase();

            if (combinedText.indexOf(filter) > -1) {
                rows[i].style.display = ""; // Show
                visibleCount++;
            } else {
                rows[i].style.display = "none"; // Hide
            }
        }

        // 4. Update the "Showing X Records" badge
        document.getElementById("visibleCount").innerText = visibleCount;
    }
</script>
</body>
</html>