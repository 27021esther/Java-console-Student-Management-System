import java.sql.*;
import java.util.Scanner;

public class MarksService {

    Scanner sc=new Scanner(System.in);

    public void addMark(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Student ID: ");
            int sid=sc.nextInt();

            System.out.print("Course ID: ");
            int cid=sc.nextInt();

            System.out.print("Marks: ");
            float m=sc.nextFloat();

            PreparedStatement ps=con.prepareStatement(
                    "insert into marks values(?,?,?)");

            ps.setInt(1,sid);
            ps.setInt(2,cid);
            ps.setFloat(3,m);

            ps.executeUpdate();
            System.out.println("Mark added");

        }catch(Exception e){System.out.println(e);}
    }

    public void viewStudentMarks(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Student ID: ");
            int sid=sc.nextInt();

            PreparedStatement ps=con.prepareStatement(
                    "select * from marks where student_id=?");

            ps.setInt(1,sid);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(
                        rs.getInt(1)+" "+
                                rs.getInt(2)+" "+
                                rs.getFloat(3));
            }

        }catch(Exception e){System.out.println(e);}
    }

    public void updateMark(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Student ID: ");
            int sid=sc.nextInt();

            System.out.print("Course ID: ");
            int cid=sc.nextInt();

            System.out.print("New Marks: ");
            float m=sc.nextFloat();

            PreparedStatement ps=con.prepareStatement(
                    "update marks set marks=? where student_id=? and course_id=?");

            ps.setFloat(1,m);
            ps.setInt(2,sid);
            ps.setInt(3,cid);

            ps.executeUpdate();
            System.out.println("Updated");

        }catch(Exception e){System.out.println(e);}
    }

    public void deleteMark(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Student ID: ");
            int sid=sc.nextInt();

            System.out.print("Course ID: ");
            int cid=sc.nextInt();

            PreparedStatement ps=con.prepareStatement(
                    "delete from marks where student_id=? and course_id=?");

            ps.setInt(1,sid);
            ps.setInt(2,cid);

            ps.executeUpdate();
            System.out.println("Deleted");

        }catch(Exception e){System.out.println(e);}
    }

}