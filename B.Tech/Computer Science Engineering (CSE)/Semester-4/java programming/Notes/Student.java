package student;

public class Student {
    private int studentId;
    private String name;
    private int age;
    
    // Constructor
    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }
    
    // Getters
    public int getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Method to get student info
    public String getStudentInfo() {
        return "Student ID: " + studentId + 
               "\nName: " + name + 
               "\nAge: " + age;
    }
} 