import java.util.Scanner;

public class StudentName {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Taking name from the user
        System.out.println("Enter the Name: ");
        String name = sc.nextLine();

        // Calculating length of name
        int len = name.length();

        // Print the name and its length
        System.out.println("Student name : " +name);
        System.out.println("Length of the name : " +len);

        // Print the Student name in Upper and Lower case
        System.out.println("Student name in Upper Case : " +name.toUpperCase());
        System.out.println("Student name in Lower Case : " +name.toLowerCase());
        sc.close();
    }
}