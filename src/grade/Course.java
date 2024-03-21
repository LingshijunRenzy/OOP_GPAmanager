package grade;

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

