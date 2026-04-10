import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args){
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        // Get input from the user
        System.out.println("Enter the first number: ");
        double num1 = sc.nextDouble();
        System.out.println("Enter the second number: ");
        double num2 = sc.nextDouble();
        // Get the desired operator
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        double result;

        // Perform operation based on the operator
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // Handle division by zero
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.print("Error! Operator is not correct");
                return;
        }
        // Display the result
        System.out.printf("%.2f %c %.2f = %.2f", num1, operator, num2, result);
        sc.close();
    }
}