import java.util.*;

public class Fibonacci_Series {
    public static void main(String[] args) {
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int count = sc.nextInt();
        int num1 = 0;
        int num2 = 1;
        int i = 1;
        System.out.println("Fibonacci series of " +count +" is : ");
        while (i <= count)
        {
            System.out.print(num1 + " ");

            // Logic calculate next term and swap

            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
            i++;
        }
    }
}

