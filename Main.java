import java.sql.*;
import java.util.Scanner;

public class Main {

    static final String url = "jdbc:mysql://localhost:3306/student_db";
    static final String user = "root";
    static final String password = "Anjan@123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");

            while (true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Delete Student");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    addStudent(con, sc);
                }
                else if (choice == 2) {
                    viewStudents(con);
                }
                else if (choice == 3) {
                    deleteStudent(con, sc);
                }
                else {
                    break;
                }
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addStudent(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        String query = "INSERT INTO students(name,course,marks) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setString(2, course);
        ps.setInt(3, marks);

        ps.executeUpdate();
        System.out.println("Student added!");
    }

    static void viewStudents(Connection con) throws Exception {

        String query = "SELECT * FROM students";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("\nID | Name | Course | Marks");

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("course") + " | " +
                rs.getInt("marks")
            );
        }
    }

    static void deleteStudent(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Student deleted!");
    }
}