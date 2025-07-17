import java.sql.*;

public class JdbcSelectTest {
    public static void main(String[] args) {
        try {
            // establish a connection
            String url = "jdbc:mysql://localhost:3306/ebookshop";
            String username = "root";
            String password = "rn$77";
            Connection conn = DriverManager.getConnection(url, username, password);

            // create a statement
            Statement stmt = conn.createStatement();

            String strSelect = "select title, price, qty from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            // execute the statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;

            // process the results
            while(rset.next()) {   // Repeatedly process each row
                // int id = rset.getInt("id");
                String title = rset.getString("title");  // retrieve a 'String'-cell in the row
                // String author = rset.getString("author");
                double price = rset.getDouble("price");  // retrieve a 'double'-cell in the row
                int    qty   = rset.getInt("qty");       // retrieve a 'int'-cell in the row
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
