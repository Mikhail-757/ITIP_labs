import java.util.Objects;

public class Student {
    private final int studentID;
    private final String firstName;
    private final String lastName;
    private int age;
    private double gpa;

    public Student(int studentID, String firstName, String lastName, int age, double gpa) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gpa = gpa;
    }

    public int getStudentID() { 
        return studentID; 
    }
    
    public String getFirstName() { 
        return firstName; 
    }
    
    public String getLastName() { 
        return lastName; 
    }

    public void setAge(int age) { this.age = age; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }
    
    @Override
    public String toString() {
        return "Student{ID=" + studentID +
               ", Имя='" + firstName + '\'' +
               ", Фамилия='" + lastName + '\'' +
               ", Возраст=" + age +
               ", Средний балл=" + gpa +
               '}';
    }
}