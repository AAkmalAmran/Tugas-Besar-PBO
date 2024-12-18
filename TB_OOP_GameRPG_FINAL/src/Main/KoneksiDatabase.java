package Main;

import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDatabase {
    private String url = "jdbc:mysql://localhost:3306/tubespbo";
    private String username = "root";
    private String password = "";

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}
