import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Connection connection = DatabaseManager.getConnection();
		//String apellido =  JOptionPane.showInputDialog("Ingrese el apellido a buscar: ");
		String idPersonaST = JOptionPane.showInputDialog("Id: ");
		Integer idPersona; // Integer es el tipo wrapper del tipo nativo int
		idPersona = Integer.parseInt(idPersonaST);

		String documento = JOptionPane.showInputDialog("Documento: ");
		String apellido1 = JOptionPane.showInputDialog("Apellido1: ");
		String apellido2 = JOptionPane.showInputDialog("Apellido2: ");
		String nombre1 = JOptionPane.showInputDialog("Nombre1: ");
		String nombre2 = JOptionPane.showInputDialog("Nombre2: ");

		String INSERT_PERSONA="INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2)"
				+ " values (?,?,?,?,?,?)";


		try {//Intentamos ejecutar el requerimiento sobre base de datos
			PreparedStatement statement=connection.prepareStatement(INSERT_PERSONA);
			statement.setInt(1, idPersona);
			statement.setString(2, documento);
			statement.setString(3, apellido1);
			statement.setString(4, apellido2);
			statement.setString(5, nombre1);
			statement.setString(6, nombre2);
			//Ejecutamos la sentencia
			int filasIngresadas = statement.executeUpdate();

			//Chequeamos que se haya agregado la nueva persona
			String consulta = "SELECT * FROM persona";
			System.out.println(consulta);

			Statement sentencia = connection.createStatement();
			ResultSet personaRS = sentencia.executeQuery(consulta);

			boolean hayCoincidencias = false;
			while (personaRS.next()) {
				if (!hayCoincidencias) hayCoincidencias = true;
				System.out.println(personaRS.getString("NOMBRE1") + " " + personaRS.getString("NOMBRE2"));

			} 
			if (!hayCoincidencias) {

				JOptionPane.showMessageDialog(null, "No hay datos para mostrar");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		DatabaseManager.cerrarConexion(connection);
	}

}
