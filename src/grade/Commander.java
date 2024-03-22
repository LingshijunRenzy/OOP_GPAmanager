package grade;

import java.util.ArrayList;
import java.util.Scanner;

public class Commander {

    private ArrayList<Student> students = new ArrayList<>();

    final String[] commands = {
        "exit",
        "add Course",
        "add Student",
        "delete Course",
        "delete Student",
        "show Info",
        //都不区分大小写的，但不能省略空格
    };

    public Commander(){
        //load student data
        FileManager fileManager = new FileManager();
        fileManager.ReadStudentData(students);

        System.out.println("Command List:\n------------------");
        for (String string : commands) {
            System.out.println(string);
        }
        System.out.println("------------------");
    }


    private void addCourse(){
        System.out.println("chose one student to add course XD:");
        for (Student student : students) {
            System.out.println(student.name);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("student:");
        String name = scan.nextLine();
        String getLine;
        if (students.isEmpty()!=true) {
            for (Student student : students) {
                if (name.equalsIgnoreCase(student.name)) {
                    while (true) {
                        System.out.print("Course name(or exit):");
                        getLine = scan.nextLine();
                        if (getLine.equalsIgnoreCase("exit")) {
                            break;
                        } else {
                            String courseName = getLine;
                            System.out.print("credit:");
                            String credit = scan.nextLine(); 
                            System.out.print("score:");
                            String score = scan.nextLine();
                            Course course = new Course(courseName, Integer.valueOf(credit).intValue(), Integer.valueOf(score).intValue());
                            student.addCourse(course);
                            System.out.println("course:" + courseName + " added!");
                        }
                    }
                    break;
                }
                else {
                    System.out.println("not found");
                }
            }
        } else {
            System.out.println("not found");
        }
    }

    private void addStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.print("student name:");
        String name = scan.nextLine();
        System.out.print("student ID:");
        String ID = scan.nextLine();
        Student student = new Student(name, ID);
        students.add(student);
        System.out.println("student:" + name + "(" + ID + ") added!");
    }

    private void deleteCourse(){
        System.out.println("chose one student to delete course XD:");
        for (Student student : students) {
            System.out.println(student.name);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("student:");
        String name = scan.nextLine();
        String getLine;
        if (students.isEmpty()!=true) {
            for (Student student : students) {
                if (name.equalsIgnoreCase(student.name)) {
                    while (true) {
                        System.out.print("Course name(or exit):");
                        getLine = scan.nextLine();
                        if (getLine.equalsIgnoreCase("exit")) {
                            break;
                        } else {
                            String courseName = getLine;
                            for (Course course : student.courses) {
                                if (courseName.equalsIgnoreCase(course.courseName)) {
                                    student.courses.remove(course);
                                    System.out.println("course:" + courseName + " deleted!");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                System.out.println("not found");
            }
        } else {
            System.out.println("not found");
        }
    }

    private void deleteStudent(){
        System.out.println("chose one student to delete XD:");
        for (Student student : students) {
            System.out.println(student.name);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("student:");
        String name = scan.nextLine();
        if (students.isEmpty()!=true) {
            for (Student student : students) {
                if (name.equalsIgnoreCase(student.name)) {
                    students.remove(student);
                    System.out.println("student:" + name + " deleted!");
                    break;
                }
                else {
                    System.out.println("not found");
                }
            }
        } else {
            System.out.println("not found");
        }
    }

    private void showInfo(){
        if (students.isEmpty()) {
            System.out.println("info not found");
        } else {
            for (Student student : students) {
                System.out.println("--------------------------");
                student.displayStudentInfo();
                System.out.println("--------------------------");
                //这两行分隔符能让展示的时候好看一点
            }
        }
    }

    private void exit(){
        //save student data
        FileManager fileManager = new FileManager();
        fileManager.WriteStudentData(students);
    }

    private void runMethods(int code){
        switch (code) {
            case 0:
                exit();
                break;
            case 1:
                addCourse();
                break;
            case 2:
                addStudent();
                break;
            case 3:
                deleteCourse();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                showInfo();
                break;
            default:
                break;
        }
    }

    public void startGetCommand(){
        Scanner scan  = new Scanner(System.in);
        String getStr = "";
        int stateCode; //命令执行状态码
        do {
            stateCode = 0;
            System.out.print("$:");
            getStr = scan.nextLine();
            //不区分大小写的字符串匹配，接收到exit则退出
            for (int i=0; i<commands.length; i++){
                if (getStr.equalsIgnoreCase(commands[i])) {
                    this.runMethods(i);
                    stateCode = 1;
                    break;
                }
            };
            if (stateCode == 0) {
                System.out.println("error command!");
            }
        } while (getStr.equalsIgnoreCase(commands[0])!=true);
        System.out.println("log out!");
        scan.close();
    }  
}