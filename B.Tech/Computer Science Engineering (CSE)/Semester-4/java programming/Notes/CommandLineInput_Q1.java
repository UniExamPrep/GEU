/*
1. Taking input from Command line and convert objects into primitive data type:
Write a java program to take input as a command line argument. Your name, course, university rollno and semester. Display the information.

Name: University
RollNo: Course:
          Semester:
*/

public class CommandLineInput_Q1 {
    public static void main(String[] args) {
        // Check if all required arguments are provided
        if (args.length < 4) {
            System.out.println("Please provide all required arguments:");
            System.out.println("java CommandLineInput_Q1 <name> <rollno> <course> <semester>");
            return;
        }

        // Get command line arguments
        String name = args[0];
        String rollNo = args[1];
        String course = args[2];
        String semester = args[3];

        // Display the information
        System.out.println("Name: " + name);
        System.out.println("RollNo: " + rollNo);
        System.out.println("Course: " + course);
        System.out.println("          Semester: " + semester);
    }
}
