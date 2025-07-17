package lab10;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class UniversityDbCLI {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "rn$77";

        Scanner in = new Scanner(System.in);
        int choice = 0;

        try (
             Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("1. View All Students");
            System.out.println("2. Add a New Student");
            System.out.println("3. Update Student GPA");
            System.out.println("4. Delete a Student");
            System.out.println("5. Exit the Program");

            do {
                System.out.print("Choice: ");
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        String strSelect = "select * from students";
                        ResultSet rst = stmt.executeQuery(strSelect);

                        while (rst.next()) {
                            int student_id = rst.getInt("student_id");
                            String name = rst.getString("name");
                            Date dob = rst.getDate("dob");
                            String email = rst.getString("email");
                            double gpa = rst.getDouble("gpa");

                            System.out.println(student_id + ", " + name + ", " + dob + ", " + email + ", " + gpa);
                        }
                        break;

                    case 2:
                        System.out.print("student_id: ");
                        int student_id = in.nextInt();
                        in.nextLine();
                        System.out.print("name: ");
                        String name = in.nextLine();
                        System.out.print("dob: ");
                        String dob = in.nextLine();
                        System.out.print("email: ");
                        String email = in.nextLine();
                        System.out.print("gpa: ");
                        double gpa = in.nextDouble();

                        String strInsert = "insert into students values(" + student_id + ", '" + name + "', '" + dob + "', '" + email + "', " + gpa + ")";
                        stmt.executeUpdate(strInsert);
                        break;

                    case 3:
                        System.out.print("student_id: ");
                        int update_student_id = in.nextInt();
                        System.out.print("new gpa: ");
                        double update_gpa = in.nextDouble();

                        String strUpdate = "update students set gpa = " + update_gpa + " where student_id = " + update_student_id;
                        stmt.executeUpdate(strUpdate);
                        break;

                    case 4:
                        System.out.print("student_id: ");
                        int delete_student_id = in.nextInt();
                        String strDelete = "delete from students where student_id = " + delete_student_id;
                        stmt.executeUpdate(strDelete);
                        break;
                }

            } while (choice != 5);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
