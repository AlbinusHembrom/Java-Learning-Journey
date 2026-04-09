import java.util.*;

class Calculator {
    // Method to add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    double add(double a, double b) {
        return a + b;
    }
}

public class OverLoading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Enter two integers to add: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Sum of 2 ints: " + calc.add(a, b));

        System.out.println("Enter two decimals to add: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.println("Sum of 2 doubles: " + calc.add(x, y));

        sc.close();
    }
}