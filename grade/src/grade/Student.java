package grade;
import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    String studentId;
    List<Course> courses;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public double calculateTotalGPA() {
        double totalGPA = 0.0;
        for (Course course : courses) {
            totalGPA += course.calculateGPA() * course.credit;
        }
        return totalGPA / getTotalCredits();
    }

    private int getTotalCredits() {
        int totalCredits = 0;
        for (Course course : courses) {
            totalCredits += course.credit;
        }
        return totalCredits;
    }

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println("Course Name: " + course.courseName + ", Credit: " + course.credit + ", Score: " + course.score);
        }
    }
}

