public class Course {
    private int id;
    private String name;
    private int credits;
    private double grade;
    
    public Course(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.grade = 0.0;
    }
    
    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", grade=" + grade +
                '}';
    }
} 