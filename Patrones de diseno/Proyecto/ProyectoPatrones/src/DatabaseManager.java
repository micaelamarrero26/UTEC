import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DatabaseManager {
	private static Connection databaseConnection;
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "PROYECTO";
	private static String CLAVE = "1234";

	static {

		databaseConnection = null;
		try {//¿Tenemos vinculada la clase en nuestro proyecto?
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Se encontro el Driver para Oracle DB / La libreria necesaria esta referenciada");


			try {
				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);

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
	
	public static Connection getConnection() {
		return databaseConnection;
	}
	
	public static void cerrarConexion(Connection connection) {
		try {//Intentamos cerrar la conexion
			connection.close();
			System.out.println("Conexion cerrada con exito, ya no es posible acceder a la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}
	
}
