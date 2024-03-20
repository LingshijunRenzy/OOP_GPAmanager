package grade;
public class GPAcalculator {
    public static void main(String[] args) {
        Student student = new Student("Alice", "123456");

        Course course1 = new Course("Math", 3, 85);
        Course course2 = new Course("English", 2, 78);
        Course course3 = new Course("Physics",2,74);
        student.addCourse(course1);
        student.addCourse(course2);
        student.addCourse(course3);
        student.displayStudentInfo();

        double totalGPA = student.calculateTotalGPA();
        System.out.println("Total GPA: " + totalGPA);
    }
}
