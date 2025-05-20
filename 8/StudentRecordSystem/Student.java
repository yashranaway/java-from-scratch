import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int id;
    private List<Course> courses;
    
    public Student(int id, String name, int age, String email) {
        super(name, age, email);
        this.id = id;
        this.courses = new ArrayList<>();
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public List<Course> getCourses() { return courses; }
    public void addCourse(Course course) { courses.add(course); }
    
    public double calculateGPA() {
        if (courses.isEmpty()) return 0.0;
        
        double totalPoints = 0;
        int totalCredits = 0;
        
        for (Course course : courses) {
            totalPoints += course.getGrade() * course.getCredits();
            totalCredits += course.getCredits();
        }
        
        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gpa=" + calculateGPA() +
                '}';
    }
} 