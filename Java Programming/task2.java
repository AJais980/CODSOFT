import java.util.*;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int subjects[] = new int[n];
        int sum = 0;
        System.out.print("Enter marks of each subject: ");
        for (int i = 0; i < n; i++) {
            subjects[i] = sc.nextInt();
            sum += subjects[i];
        }
        double avg = (sum * 1.0) / n;
        System.out.println("Total Marks Obtained: " + sum + "/" + 100 * n);
        System.out.println("Average Percentage: " + avg);
        String Grade;
        if (avg >= 90 && avg <= 100) {
            Grade = "A+";
        } else if (avg >= 80) {
            Grade = "A";
        } else if (avg >= 70) {
            Grade = "B";
        } else if (avg >= 60) {
            Grade = "C";
        } else if (avg >= 50) {
            Grade = "D";
        } else if (avg >= 40) {
            Grade = "E";
        } else {
            Grade = "F";
        }
        System.out.println("Grade: " + Grade);
        sc.close();
    }
}
