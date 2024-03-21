package grade;
import java.util.Scanner;
import java.util.ArrayList;

public class Commander {
    
    final String[] commands = {
        "exit",
        "add Course",
        "add Student",
        "show Info"
        //都不区分大小写的，但不能省略空格
    };

    public Commander(){
        System.out.println("Command List:\n------------------");
        for (String string : commands) {
            System.out.println(string);
        }
        System.out.println("------------------");
    }

    ArrayList<Student> students = new ArrayList<>();


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
                        }
                    }
                    break;
                }
                System.out.println("not found");
            }
        } else {
            System.out.println("not found");
        }
        scan.close();
    }

    private void addStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.print("student name:");
        String name = scan.nextLine();
        System.out.print("student ID:");
        String ID = scan.nextLine();
        Student student = new Student(name, ID);
        students.add(student);
        scan.close();
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

    private void runMethods(int code){
        switch (code) {
            case 1:
                addCourse();
                break;
            case 2:
                addStudent();
                break;
            case 3:
                showInfo();
                break;
            default:
                break;
        }
    }

    public void startGetCommand(){
        Scanner scan  = new Scanner(System.in);
        String getStr;
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