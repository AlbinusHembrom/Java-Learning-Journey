import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    double marks;
    Student(String name, int rollNumber, double inputMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = inputMarks;
    }

    void displayInfo() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Student's Marks: " +this.marks);
    }
}

public class StudentDetail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String inputName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int inputRoll = sc.nextInt();

        System.out.print("Enter the Marks: ");
        double inputMarks = sc.nextDouble();

        // Using 'new' keyword to create an object s1
        Student s1 = new Student(inputName, inputRoll, inputMarks);
        System.out.println("\n--- Student Details ---");
        s1.displayInfo();
        sc.close();
    }
}