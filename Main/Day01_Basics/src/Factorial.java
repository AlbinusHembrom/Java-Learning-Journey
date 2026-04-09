import java.util.*;

public class Factorial {
    public static void main(String[] args) {
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        // Enter the number in the variable a
        System.out.println("Enter the number: ");
        int a = sc.nextInt();
        // Take i as integer for iteration
        int i;
        // Take b as 1 for temporary value to store the value during operation
        long b = 1;
        // Check for value of a
        if (a == 1)
        {
            System.out.println("The factorial of 0 number is 1");
        }
        else
        {
            for(i=1;i<(a+1);i++)
            {
                b = b * i;
            }
            System.out.println("The factorial of the " + a +" number is : " + b);
        }
    }
}