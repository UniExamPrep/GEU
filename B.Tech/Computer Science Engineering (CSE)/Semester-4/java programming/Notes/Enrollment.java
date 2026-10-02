package enrollment;

import student.Student;
import course.Course;

public class Enrollment {
    private Student student;
    private Course course;
    private String enrollmentDate;
    
    // Constructor
    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }
    
    // Getters
    public Student getStudent() {
        return student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public String getEnrollmentDate() {
        return enrollmentDate;
    }
    
    // Method to get enrollment info
    public String getEnrollmentInfo() {
        return "Enrollment Details:" +
               "\n-----------------" +
               "\n" + student.getStudentInfo() + 
               "\n\n" + course.getCourseInfo() + 
               "\n\nEnrollment Date: " + enrollmentDate;
    }
} 