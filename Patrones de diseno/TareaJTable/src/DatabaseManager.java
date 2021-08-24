
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String Connection_String = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String usuario = "JAVA";
	private static String contraseña = "JAVA";
	
	
	static{
		databaseConnection = null;
		try {//¿Tenemos vinculada la clase en nuestro proyecto?
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Se encontro el Driver para Oracle DB / La libreria necesaria esta referenciada");


			try {
				databaseConnection = DriverManager.getConnection(Connection_String, usuario, contraseña);

				System.out.println("Conexion creada con exito, es posible acceder a la base de datos!");


			} catch (SQLException e) {
				System.out.println("No logramos instanciar una conexion");
				e.printStackTrace();

			}


		}
		catch(ClassNotFoundException e) {
			System.out.println("No tienes el driver en tu build-path");
			e.printStackTrace();

		}
	}
	
	public static Connection getConnection(){
		return databaseConnection;
	}

}
