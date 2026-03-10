import java.sql.*;
import java.util.Scanner;

public class CourseService {

    Scanner sc=new Scanner(System.in);

    public void addCourse(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Course name: ");
            String name=sc.nextLine();

            System.out.print("Description: ");
            String d=sc.nextLine();

            PreparedStatement ps=con.prepareStatement(
                    "insert into courses(course_name,course_description) values(?,?)");

            ps.setString(1,name);
            ps.setString(2,d);

            ps.executeUpdate();
            System.out.println("Course added");

        }catch(Exception e){System.out.println(e);}
    }

    public void viewCourses(){
        try{
            Connection con=DBConnection.getConnection();

            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from courses");

            while(rs.next()){
                System.out.println(
                        rs.getInt(1)+" "+
                                rs.getString(2)+" "+
                                rs.getString(3));
            }

        }catch(Exception e){System.out.println(e);}
    }

    public void viewCourse(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Course ID: ");
            int id=sc.nextInt();

            PreparedStatement ps=con.prepareStatement(
                    "select * from courses where id=?");

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(
                        rs.getInt(1)+" "+
                                rs.getString(2)+" "+
                                rs.getString(3));
            }

        }catch(Exception e){System.out.println(e);}
    }

    public void updateCourse(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Course ID: ");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.print("New description: ");
            String d=sc.nextLine();

            PreparedStatement ps=con.prepareStatement(
                    "update courses set course_description=? where id=?");

            ps.setString(1,d);
            ps.setInt(2,id);

            ps.executeUpdate();
            System.out.println("Updated");

        }catch(Exception e){System.out.println(e);}
    }

    public void deleteCourse(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Course ID: ");
            int id=sc.nextInt();

            PreparedStatement ps=con.prepareStatement(
                    "delete from courses where id=?");

            ps.setInt(1,id);

            ps.executeUpdate();
            System.out.println("Deleted");

        }catch(Exception e){System.out.println(e);}
    }

}