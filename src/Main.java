import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello from Java!");

    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mariadb?" +
          "user=root&password=mariadb");
      System.out.println("Connection created");

      Statement statement = conn.createStatement();
      statement.execute("USE mariadb;");

      String query = "SELECT * from MyTable;";
      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        String value = resultSet.getString(2);
        System.out.println(value);
      }

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }
}