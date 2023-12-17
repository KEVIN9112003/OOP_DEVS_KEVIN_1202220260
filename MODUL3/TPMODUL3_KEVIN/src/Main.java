import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();

        int studentID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter student ID:");
                studentID = scanner.nextInt();
                if (studentID == 1202220260) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer for student ID.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for student ID.");
                scanner.nextLine();
            }
        }

        scanner.nextLine();

        System.out.println("Enter courses to enroll in (separated by commas):");
        String coursesInput = scanner.nextLine();
        String[] courses = coursesInput.split(",");

        Student student = new Student(studentName, studentID);
        for (String course : courses) {
            student.enrollInCourse(course.trim());
        }

        ArrayList<String> course101Students = new ArrayList<>();
        course101Students.add("Haris");
        course101Students.add("Metta");

        ArrayList<String> course102Students = new ArrayList<>();
        course102Students.add("Windy");
        course102Students.add("Amilia");

        System.out.println("\nCourse ID: 101,");
        System.out.println("Course Name: Pemrograman Berbasis Objek");
        for (String studentInCourse : course101Students) {
            System.out.println("- Student: " + studentInCourse);
        }

        System.out.println("\nCourse ID: 102,");
        System.out.println("Course Name: Statistika Industri");
        for (String studentInCourse : course102Students) {
            System.out.println("- Student: " + studentInCourse);
        }

        System.out.println("\n" + student.getUserDetails());

        Teacher teacher = new Teacher("Pak Yoga Raditya", 12345);
        teacher.teachClass("Pemodelan Proses Bisnis");

        Admin admin = new Admin("Hudza", 54321);
        admin.manageSystem("the university system");

        scanner.close();
    }
}
