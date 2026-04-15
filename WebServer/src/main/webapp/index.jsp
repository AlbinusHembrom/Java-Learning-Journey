<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        body { background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); min-height: 100vh; font-family: 'Segoe UI', sans-serif; }
        .main-card { border: none; border-radius: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.1); background: white; }
        .form-label { font-weight: 600; color: #4e73df; }
        .subject-header { border-left: 4px solid #4e73df; padding-left: 10px; margin: 1.5rem 0; font-weight: bold; color: #5a5c69; }
        .session-badge { font-size: 0.75rem; vertical-align: middle; }
    </style>
</head>
<body>

<%
    // Check if the password was already saved in this session
    String savedPass = (String) session.getAttribute("savedPass");
    boolean hasSession = (savedPass != null && !savedPass.isEmpty());
%>

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-9">
            <div class="card main-card p-4 p-md-5">

                <div class="d-flex justify-content-between align-items-start mb-5">
                    <div>
                        <h1 class="display-5 fw-bold text-dark">Student <span class="text-primary">Portal</span></h1>
                        <p class="text-muted mb-0">AKTU Semester Report Card System</p>
                    </div>
                    <% if (hasSession) { %>
                    <a href="logout.jsp" class="btn btn-outline-danger btn-sm shadow-sm">
                        <i class="bi bi-box-arrow-right"></i> Logout
                    </a>
                    <% } %>
                </div>

                <div class="text-center mb-4">
                    <a href="viewStudents" class="btn btn-sm btn-outline-secondary">
                        📊 View Full Marksheet
                    </a>
                </div>

                <h4 class="mb-4">🚀 Add New Entry</h4>
                <form action="addStudent" method="post">

                    <div class="mb-4 bg-light p-3 rounded border">
                        <div class="d-flex justify-content-between align-items-center mb-2">
                            <label class="form-label mb-0">MySQL Connection</label>
                            <% if (hasSession) { %>
                            <span class="badge bg-success session-badge animate__animated animate__fadeIn">
                                    <i class="bi bi-shield-check"></i> Connected as Root
                                </span>
                            <% } %>
                        </div>

                        <% if (hasSession) { %>
                        <input type="hidden" name="dbPass" value="<%= savedPass %>">
                        <div class="form-text text-success small">
                            Using saved credentials. Your session is active for 30 minutes.
                        </div>
                        <% } else { %>
                        <input type="password" name="dbPass" class="form-control" placeholder="Enter MySQL Password" required>
                        <div class="form-text text-muted small">Enter your password once to keep the connection active.</div>
                        <% } %>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-4 mb-3">
                            <label class="form-label">Roll No</label>
                            <input type="number" name="studentId" class="form-control" required>
                        </div>
                        <div class="col-md-8 mb-3">
                            <label class="form-label">Student Name</label>
                            <input type="text" name="studentName" class="form-control" required>
                        </div>
                    </div>

                    <h5 class="subject-header">SUBJECT MARKS (0-100)</h5>
                    <div class="row g-3">
                        <div class="col-md-4"><label class="form-label">OOPS</label><input type="number" name="oops" class="form-control" required></div>
                        <div class="col-md-4"><label class="form-label">TAFL</label><input type="number" name="tafl" class="form-control" required></div>
                        <div class="col-md-4"><label class="form-label">MATHS-IV</label><input type="number" name="maths4" class="form-control" required></div>
                        <div class="col-md-4"><label class="form-label">OS</label><input type="number" name="os" class="form-control" required></div>
                        <div class="col-md-4"><label class="form-label">PYTHON</label><input type="number" name="python" class="form-control" required></div>
                        <div class="col-md-4"><label class="form-label">UHV</label><input type="number" name="uhv" class="form-control" required></div>
                    </div>

                    <button type="submit" class="btn btn-primary btn-lg w-100 mt-4 shadow">Save Student Report</button>
                </form>

                <hr class="my-5">

                <h4 class="mb-4">📂 Database Explorer</h4>
                <div class="p-4 rounded-3 border bg-light">
                    <form action="viewStudents" method="post" class="row g-2 align-items-end">
                        <div class="col-md-8">
                            <% if (hasSession) { %>
                            <div class="alert alert-secondary py-2 mb-0 small">
                                Ready to explore <strong>project_db</strong>
                                <input type="hidden" name="dbPass" value="<%= savedPass %>">
                            </div>
                            <% } else { %>
                            <input type="password" name="dbPass" class="form-control" placeholder="Enter MySQL Password" required>
                            <% } %>
                        </div>
                        <div class="col-md-4">
                            <button type="submit" class="btn btn-dark w-100 text-nowrap">View Records</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>