import java.util.*;
public  class Array_Search {
    public static void main(String[] args) {
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        // Take the value from user
        System.out.println("Enter the number of Elements: ");
        int n = sc.nextInt();

        // Initialize the array
        int[] arr = new int[n];

        // Fill the array with user input
        System.out.println("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        // Take user input for searching
        System.out.println("Enter the value to be searched: ");
        int key = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++)
        {

            if (arr[i] == key)
            {

                System.out.println("Element " + key + " found at index: " + i);
                found = true;
                break;
            }

        }
        if (!found)
        {
            System.out.println("Element " + key + " is not found in the array.");
        }
        sc.close();
    }
}