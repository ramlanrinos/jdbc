import java.sql.*;

public class JdbcUpdateTest {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/:ebookshop";
            String username = "root";
            String password = "rn$77";
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();

            String strUpdate = "";
            int rows = stmt.executeUpdate(strUpdate);
            System.out.println(rows + "rows(s) affected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
