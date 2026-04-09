import java.util.*;
public  class Palindrome_Check {
    public static void main(String[] args) {
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        // Take the value from user
        System.out.println("Enter a number or String: ");
        String str = sc.nextLine();
        // Taking Empty string to store reverse string
        String reverseString = "";
        // Storing the length of string
        int strLength = str.length();
        // Iteration for reversing and storing it in reverseString
        for (int i = (strLength - 1); i >= 0; i--)
        {
            reverseString = reverseString + str.charAt(i);
        }
        // Checking for Palindrome and Print th output
        if (str.equalsIgnoreCase(reverseString))
        {
            System.out.println(str + " is a Palindrome.");
        }
        else
        {
            System.out.println(str + " is not a Palindrome");
        }
        sc.close();
    }
}