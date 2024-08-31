import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of subjects.
        System.out.print("Enter the number of subjects: ");
        int Subjects = scanner.nextInt();

        // Array to store the marks for each subject
        int[] marks = new int[Subjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < Subjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate the average percentage
        double Percentage = (double) totalMarks / Subjects;

        // Determine the grade based on the average percentage
        String grade;
        if (Percentage >= 90) {
            grade = "A+";
        } else if (Percentage >= 80) {
            grade = "A";
        } else if (Percentage >= 70) {
            grade = "B+";
        } else if (Percentage >= 60) {
            grade = "B";
        } else if (Percentage >= 50) {
            grade = "C";
        } else if (Percentage >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display the results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + Percentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
