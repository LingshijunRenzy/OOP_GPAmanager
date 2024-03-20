package grade;
import java.util.ArrayList;
import java.util.List;

class Course {
    String courseName;
    int credit;
    int score;

    public Course(String courseName, int credit, int score) {
        this.courseName = courseName;
        this.credit = credit;
        this.score = score;
    }

    public double calculateGPA() {
        if (score >= 90) {
            return 4.0;
        } else if (score >= 80) {
            return 3.0;
        } else if (score >= 70) {
            return 2.0;
        } else if (score >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}

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

