package grade;

import com.alibaba.fastjson.annotation.JSONField;

class Course {
    @JSONField(name = "courseName",ordinal = 1)
    public String courseName;

    @JSONField(name = "credit",ordinal = 2)
    public int credit;

    @JSONField(name = "score",ordinal = 3)
    public int score;

    public Course(){}; // for JSON
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

