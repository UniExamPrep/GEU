import student.Student;
import course.Course;
import enrollment.Enrollment;

public class StudentManagementSystem {
    public static void main(String[] args) {
        System.out.println("Student Management System");
        System.out.println("=========================");
        
        // Create Student objects
        Student student1 = new Student(1001, "John Smith", 20);
        Student student2 = new Student(1002, "Emily Johnson", 22);
        
        // Create Course objects
        Course course1 = new Course("CS101", "Introduction to Programming", 3);
        Course course2 = new Course("CS202", "Data Structures", 4);
        
        // Create Enrollment objects
        Enrollment enrollment1 = new Enrollment(student1, course1, "2023-09-01");
        Enrollment enrollment2 = new Enrollment(student2, course2, "2023-09-05");
        
        // Display Student information
        System.out.println("\nStudent Information:");
        System.out.println("-------------------");
        System.out.println(student1.getStudentInfo());
        System.out.println("\n" + student2.getStudentInfo());
        
        // Display Course information
        System.out.println("\nCourse Information:");
        System.out.println("------------------");
        System.out.println(course1.getCourseInfo());
        System.out.println("\n" + course2.getCourseInfo());
        
        // Display Enrollment information
        System.out.println("\nEnrollment Information:");
        System.out.println("----------------------");
        System.out.println(enrollment1.getEnrollmentInfo());
        System.out.println("\n" + enrollment2.getEnrollmentInfo());
    }
} 