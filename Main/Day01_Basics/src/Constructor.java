import java.util.Scanner;

class Student {
    String name;
    int rollNumber;

    // CONSTRUCTOR: A special method used to initialize objects.
    // It must have the same name as the class and NO return type.
    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    void displayInfo() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Roll Number: " + this.rollNumber);
    }
}

public class Constructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String inputName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int inputRoll = sc.nextInt();

        // Using 'new' keyword to create an object s1
        Student s1 = new Student(inputName, inputRoll);

        System.out.println("\n--- Student Details ---");
        s1.displayInfo();

        sc.close();
    }
}
