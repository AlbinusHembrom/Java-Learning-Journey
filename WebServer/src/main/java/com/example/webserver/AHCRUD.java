package com.example.webserver; // Corrected package name

import java.sql.*;
import java.util.Scanner;

public class AHCRUD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Database Credentials
        String url = "jdbc:mysql://localhost:3306/project_db";
        String user = "root";

        System.out.print("Enter MySQL Password: ");
        String pass = sc.nextLine();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("✔ Connection Established with project_db!");

            while (true) {
                System.out.println("\n--- ADMIN PANEL (AHCRUD) ---");
                System.out.println("1. Add Student (CREATE)");
                System.out.println("2. View All (READ)");
                System.out.println("3. Update Marks (UPDATE)");
                System.out.println("4. Remove Student (DELETE)");
                System.out.println("5. Exit");
                System.out.print("Action: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: // CREATE
                        System.out.print("Roll No: "); int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("OOPS: "); int m1 = sc.nextInt();
                        System.out.print("TAFL: "); int m2 = sc.nextInt();
                        System.out.print("MATHS-IV: "); int m3 = sc.nextInt();
                        System.out.print("OS: "); int m4 = sc.nextInt();
                        System.out.print("PYTHON: "); int m5 = sc.nextInt();
                        System.out.print("UHV: "); int m6 = sc.nextInt();

                        String sqlIns = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement psIns = conn.prepareStatement(sqlIns);
                        psIns.setInt(1, id);
                        psIns.setString(2, name);
                        psIns.setInt(3, m1);
                        psIns.setInt(4, m2);
                        psIns.setInt(5, m3);
                        psIns.setInt(6, m4);
                        psIns.setInt(7, m5);
                        psIns.setInt(8, m6);
                        psIns.executeUpdate();
                        System.out.println("✔ Record successfully saved to MySQL.");
                        break;

                    case 2: // READ
                        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
                        System.out.println("\nID | Name | OOPS | TAFL | M4 | OS | PY | UHV");
                        System.out.println("-----------------------------------------------");
                        while (rs.next()) {
                            System.out.printf("%d | %s | %d | %d | %d | %d | %d | %d\n",
                                    rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                                    rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                        }
                        break;

                    case 3: // UPDATE
                        System.out.print("Enter Roll No to Update: ");
                        int upId = sc.nextInt();

                        System.out.println("\nSelect Subject to Update:");
                        System.out.println("1. OOPS  2. TAFL  3. MATHS4  4. OS  5. PYTHON  6. UHV");
                        int subChoice = sc.nextInt();

                        System.out.print("Enter New Marks (0-100): ");
                        int newMark = sc.nextInt();

                        String colName = "";
                        switch(subChoice) {
                            case 1: colName = "oops"; break;
                            case 2: colName = "tafl"; break;
                            case 3: colName = "maths4"; break;
                            case 4: colName = "os"; break;
                            case 5: colName = "python"; break;
                            case 6: colName = "uhv"; break;
                        }

                        if(!colName.isEmpty()) {
                            String sqlUp = "UPDATE students SET " + colName + " = ? WHERE id = ?";
                            PreparedStatement psUp = conn.prepareStatement(sqlUp);
                            psUp.setInt(1, newMark);
                            psUp.setInt(2, upId);
                            if(psUp.executeUpdate() > 0) System.out.println("✔ Marks updated successfully!");
                            else System.out.println("❌ Roll No not found.");
                        } else {
                            System.out.println("⚠ Invalid Subject Choice.");
                        }
                        break;

                    case 4: // DELETE
                        System.out.print("Enter Roll No to Delete: ");
                        int delId = sc.nextInt();
                        PreparedStatement psDel = conn.prepareStatement("DELETE FROM students WHERE id = ?");
                        psDel.setInt(1, delId);
                        if(psDel.executeUpdate() > 0) System.out.println("✔ Record removed from database.");
                        else System.out.println("❌ Roll No not found.");
                        break;

                    case 5: // EXIT
                        System.out.println("Exiting System. Goodbye!");
                        return;

                    default:
                        System.out.println("⚠ Selection not recognized. Please choose 1-5.");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Critical Error: " + e.getMessage());
        }
    }
}