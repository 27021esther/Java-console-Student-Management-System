import java.sql.*;
import java.util.Scanner;

public class StudentService {

    Scanner sc=new Scanner(System.in);

    public void addStudent(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("First name: ");
            String f=sc.nextLine();

            System.out.print("Last name: ");
            String l=sc.nextLine();

            System.out.print("Email: ");
            String e=sc.nextLine();

            System.out.print("DOB(yyyy-mm-dd): ");
            String d=sc.nextLine();

            PreparedStatement ps=con.prepareStatement(
                    "insert into students(first_name,last_name,email,date_of_birth) values(?,?,?,?)");

            ps.setString(1,f);
            ps.setString(2,l);
            ps.setString(3,e);
            ps.setDate(4,Date.valueOf(d));

            ps.executeUpdate();
            System.out.println("Student added");

        }catch(Exception e){System.out.println(e);}
    }

    public void viewStudents(){
        try{
            Connection con=DBConnection.getConnection();

            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from students");

            while(rs.next()){
                System.out.println(
                        rs.getInt("id")+" "+
                                rs.getString("first_name")+" "+
                                rs.getString("last_name")+" "+
                                rs.getString("email")+" "+
                                rs.getDate("date_of_birth"));
            }

        }catch(Exception e){System.out.println(e);}
    }

    public void viewStudent(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Student ID: ");
            int id=sc.nextInt();

            PreparedStatement ps=con.prepareStatement(
                    "select * from students where id=?");

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(
                        rs.getInt(1)+" "+
                                rs.getString(2)+" "+
                                rs.getString(3)+" "+
                                rs.getString(4)+" "+
                                rs.getDate(5));
            }

        }catch(Exception e){System.out.println(e);}
    }

    public void updateStudent(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Student ID: ");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.print("New email: ");
            String email=sc.nextLine();

            PreparedStatement ps=con.prepareStatement(
                    "update students set email=? where id=?");

            ps.setString(1,email);
            ps.setInt(2,id);

            ps.executeUpdate();
            System.out.println("Updated");

        }catch(Exception e){System.out.println(e);}
    }

    public void deleteStudent(){
        try{
            Connection con=DBConnection.getConnection();

            System.out.print("Student ID: ");
            int id=sc.nextInt();

            PreparedStatement ps=con.prepareStatement(
                    "delete from students where id=?");

            ps.setInt(1,id);

            ps.executeUpdate();
            System.out.println("Deleted");

        }catch(Exception e){System.out.println(e);}
    }

}