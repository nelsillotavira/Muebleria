package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Hernandez Tolentino Jose Alberto
 */
public class conectar {
    Connection conectar=null;
public Connection conexion() {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/muebleria?user=root&password=");

} catch (ClassNotFoundException | SQLException e) {
System.out.print(e.getMessage());
}
return conectar;
}
}
