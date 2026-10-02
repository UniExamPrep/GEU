package course;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;
    
    // Constructor
    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }
    
    // Getters
    public String getCourseId() {
        return courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public int getCredits() {
        return credits;
    }
    
    // Method to get course info
    public String getCourseInfo() {
        return "Course ID: " + courseId + 
               "\nCourse Name: " + courseName + 
               "\nCredits: " + credits;
    }
} 