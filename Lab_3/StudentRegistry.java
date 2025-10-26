import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private final Map<Integer, Student> studentMap;

    public StudentRegistry() {
        this.studentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        int recordBookNumber = student.getStudentID();
        studentMap.put(recordBookNumber, student);
        System.out.println(" Студент с ID " + recordBookNumber + " добавлен/обновлен.");
    }

    public Student findStudent(int recordBookNumber) {
        Student student = studentMap.get(recordBookNumber);
        if (student != null) {
            System.out.println(" Найден студент: " + student.getFirstName() + " " + student.getLastName());
        } else {
            System.out.println(" Студент с ID " + recordBookNumber + " не найден.");
        }
        return student;
    }

    public boolean removeStudent(int recordBookNumber) {
        if (studentMap.remove(recordBookNumber) != null) {
            System.out.println(" Студент с ID " + recordBookNumber + " удален.");
            return true;
        }
        System.out.println(" Ошибка удаления: Студент с ID " + recordBookNumber + " не найден.");
        return false;
    }
    
    public void displayAllStudents() {
        System.out.println("\n--- Реестр студентов (Всего: " + studentMap.size() + ") ---");
        studentMap.forEach((id, student) -> System.out.println("ID " + id + ": " + student));
    }

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();

        Student s1 = new Student(1001, "Иван", "Петров", 20, 4.5);
        Student s2 = new Student(1002, "Мария", "Сидорова", 19, 4.9);
        
        registry.addStudent(s1);
        registry.addStudent(s2);

        registry.displayAllStudents();

        registry.findStudent(1001); 

        Student s1Updated = new Student(1001, "Иван", "Петров", 21, 4.6);
        registry.addStudent(s1Updated); 

        registry.removeStudent(1002);
        registry.findStudent(1002); 
        
        registry.displayAllStudents();
    }
}