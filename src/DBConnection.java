import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/weather_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    // IMPORTANT:
    // If you log in with: mysql -u root
    // leave this EMPTY ""
    // If you log in with: mysql -u root -p
    // put your password between the quotes
    private static final String PASSWORD = "";  

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
