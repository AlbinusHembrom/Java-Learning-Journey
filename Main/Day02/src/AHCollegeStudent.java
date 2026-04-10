import java.util.Scanner;

// Public parent class to hold general college info
class AHCollege {
    String ahCollegeName;
    String ahCollegeCity;

    // Method to show college details
    void ahDisplayCollege() {
        System.out.println("\n--- College Records ---");
        System.out.println("College: " + ahCollegeName);
        System.out.println("Location: " + ahCollegeCity);
    }
}

// Child class inheriting from AHCollege
class AHStudent extends AHCollege {
    String ahStudentName;
    int ahRollNumber;

    // Method to show student specific info
    void ahDisplayStudent() {
        System.out.println("Student Name: " + ahStudentName);
        System.out.println("Roll Number: " + ahRollNumber);
    }
}

public class AHCollegeStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating the object of the child class
        AHStudent ahObj = new AHStudent();

        // Taking input from the user
        System.out.print("Enter College Name: ");
        ahObj.ahCollegeName = sc.nextLine();

        System.out.print("Enter College City: ");
        ahObj.ahCollegeCity = sc.nextLine();

        System.out.print("Enter Student Name: ");
        ahObj.ahStudentName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        ahObj.ahRollNumber = sc.nextInt();

        // Accessing Parent class method using child object
        ahObj.ahDisplayCollege();

        // Accessing Child class method
        ahObj.ahDisplayStudent();

        sc.close();
    }
}