import java.util.*;
public  class Array_Sort {
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
        System.out.println("Original Array: " + Arrays.toString(arr));
        // Using Built-in sort method(Ascending order)
        Arrays.sort(arr);
        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));
        sc.close();
    }
}