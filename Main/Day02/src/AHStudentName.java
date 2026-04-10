import java.util.Scanner;

public class AHStudentName {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Taking name from the user
        System.out.println("Enter the Name: ");
        String ahName = sc.nextLine();

        // Calculating length of name
        int len = ahName.length();

        // Print the name and its length
        System.out.println("Student name : " +ahName);
        System.out.println("Length of the name : " +len);

        // Print the Student name in Upper and Lower case
        System.out.println("Student name in Upper Case : " +ahName.toUpperCase());
        System.out.println("Student name in Lower Case : " +ahName.toLowerCase());
        sc.close();
    }
}