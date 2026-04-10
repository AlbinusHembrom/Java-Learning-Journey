import java.util.*;

public class Calculator_Method {

    // Method 1: Addition
    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    // Method 2: Subtraction
    public static int sub(int num1, int num2) {
        return num1 - num2;
    }
    // Method 2: Multiplication
    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Method 2: Division
    public static String divide(int num1, int num2) {
        if (num2 == 0) {
            return "Not Defined";
        }
        return String.valueOf(num1 / num2);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Enter two numbers from user
        System.out.print("Enter 1st number : ");
        int num1 = sc.nextInt();
        System.out.print("Enter 2nd number : ");
        int num2 = sc.nextInt();

        // Call methods and print value
        System.out.println("Addition of two number : " + add(num1,num2));
        System.out.println("Subtraction of two number : " + sub(num1,num2));
        System.out.println("Product of two number : " + multiply(num1,num2));
        System.out.println("Division of two number : " + divide(num1,num2));
    }
}