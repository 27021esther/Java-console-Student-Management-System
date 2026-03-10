import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        StudentService ss=new StudentService();
        CourseService cs=new CourseService();
        MarksService ms=new MarksService();

        while(true){

            System.out.println("a Add Student");
            System.out.println("b View Students");
            System.out.println("c Update Student");
            System.out.println("d Delete Student");
            System.out.println("e Add Course");
            System.out.println("f Get All Courses");
            System.out.println("g View Course");
            System.out.println("h Update Course");
            System.out.println("i Delete Course");
            System.out.println("j Add Mark");
            System.out.println("k View Student Marks");
            System.out.println("l Update Student Mark");
            System.out.println("m Delete Student Mark");
            System.out.println("n Exit");
            System.out.print("Enter your choice: ");

            String ch=sc.next();

            switch(ch){

                case "a": ss.addStudent(); break;
                case "b": ss.viewStudents(); break;
                case "c": ss.updateStudent(); break;
                case "d": ss.deleteStudent(); break;
                case "e": cs.addCourse(); break;
                case "f": cs.viewCourses(); break;
                case "g": cs.viewCourse(); break;
                case "h": cs.updateCourse(); break;
                case "i": cs.deleteCourse(); break;
                case "j": ms.addMark(); break;
                case "k": ms.viewStudentMarks(); break;
                case "l": ms.updateMark(); break;
                case "m": ms.deleteMark(); break;
                case "n": System.exit(0);

            }

        }

    }
}