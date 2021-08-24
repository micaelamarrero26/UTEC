import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Principal {

	static LinkedList<String> personas = null;
	public static void main(String[] args) {
		Connection connection = DatabaseManager.getConnection();
		System.out.println();
		System.out.println("********* DAO PERSONA **********");
		System.out.println();
		int cuenta = DAOPersona.cuentaPersonas();
		
		if(cuenta>0) {
			System.out.println("HAY " + cuenta + " REGISTROS EN LA TABLA PERSONA");
		} else {
			System.out.println("NO HAY REGISTROS EN LA TABLA PERSONA");
		}
		
		
		personas = DAOPersona.findAll();
		
		Ventana v = new Ventana();
		v.getFrame().setVisible(true);
		
		DatabaseManager.cerrarConexion(connection);
	}

}
