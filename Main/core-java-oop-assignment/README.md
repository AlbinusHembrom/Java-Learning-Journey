# Student Product Billing & Management System

**Developer:** ALBINUS HEMBROM

**Date:** April 12, 2026

**Course:** CORE & ADVANCE JAVA TRAINING

---

## What this project does
This is a console-based Java application built to manage student records and handle product billing. The goal was to take theoretical OOP concepts and apply them to a practical scenario—like a small training institute that needs to track students, employees, and sales.

## Core Concepts Applied
I used the following Java features to meet the assignment requirements:

* **Inheritance:** Created a `AHStudent` base class and extended it into `AHCollegeStudent`. This allowed me to reuse the basic student logic while adding college-specific fields.
* **Encapsulation:** The `AHProduct` class uses private variables with getters and setters. This keeps the price data secure from direct external changes.
* **Method Overloading:** The `AHProductBilling` class has overloaded methods to calculate totals whether the user buys 1, 2, or 3 products.
* **Static Keyword:** I used a static variable to keep a live count of how many Student objects were created during the program's run.
* **Strings & Arrays:** Used for formatting student names and storing subject marks.

## Setup & Environment
To run this project, you will need:
* **Java Development Kit (JDK):** Version 17 or higher is recommended.
* **IDE:** **IntelliJ IDEA** is the preferred platform, though any Java-based IDE (like Eclipse or VS Code) will work.
* **External Drive (Optional):** This project was developed and tested to run directly from a portable environment (E: Drive).

## How to Run
1. **Import Project:** Open **IntelliJ IDEA** and select "Open." Navigate to the `core-java-oop-assignment` folder.
2. **SDK Configuration:** Ensure your Project SDK is set to Java 17+ in `File > Project Structure`.
3. **Run Main:** Locate `src/AHMain.java` in the project sidebar, right-click the file, and select **'Run AHMain.main()'**.
4. **Console Interaction:** Use the IntelliJ Terminal to input data for students, employees, and product licenses.

## Sample Output
Below are the screenshots of the program execution. The first shows the data entry process, and the second shows the final billing and object tracking logic.

### Part 1: Data Entry
![Entry Process](screenshots/Output_1.png)

### Part 2: Final Bill and Static Count
![Final Results](screenshots/Output_2.png)