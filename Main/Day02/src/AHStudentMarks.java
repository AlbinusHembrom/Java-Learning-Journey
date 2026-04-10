import java.util.Scanner;

public class AHStudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        //Initialize the Array
        int[] ahMarks = new int[n];
        // Take user input to get the marks
        System.out.println("Enter marks of " + n + " Students: ");
        for (int i = 0; i < n; i++) {
            ahMarks[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            System.out.println("Student_" + (i+1) + " marks : " + ahMarks[i]);
        }
    }


}