import java.util.*;

public class AHCalculator_Method {

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
        int ahNum1 = sc.nextInt();
        System.out.print("Enter 2nd number : ");
        int ahNum2 = sc.nextInt();

        // Call methods and print value
        System.out.println("Addition of two number : " + add(ahNum1,ahNum2));
        System.out.println("Subtraction of two number : " + sub(ahNum1,ahNum2));
        System.out.println("Product of two number : " + multiply(ahNum1,ahNum2));
        System.out.println("Division of two number : " + divide(ahNum1,ahNum2));
    }
}