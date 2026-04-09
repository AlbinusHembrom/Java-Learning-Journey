import java.util.*;
public  class Prime_Check {
    public static void main(String[] args) {
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        // Take the value from user
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= (num + 1); i++)
        {
            if ((num % i) == 0)
            {
                count = count + 1;
            }
        }
        if (count == 2)
        {
            System.out.println("The number " + num + " is a prime number.");
        }
        else
        {
            System.out.println("The number "+ num + " is not a prime number.");
        }
        sc.close();
    }
}