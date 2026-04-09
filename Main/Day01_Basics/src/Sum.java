import java.util.*;

public class Sum {
    public static void main(String[] args){
        // Create a variable to enter the value
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        // Perform operation
        // display result
        System.out.println("Sum: " + (a + b));
        sc.close();
    }
}
