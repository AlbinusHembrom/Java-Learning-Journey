import java.util.*;
public  class Even_Odd {
    public static void main(String[] args){
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        // Take the value from user
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        // Checking whether the number is even or odd
        // Then print the output
        if (num % 2 == 0)
        {
            System.out.println(num + " is an Even number.");
        }
        else
        {
            System.out.println(num + " is an Odd number");
        }
    }
}