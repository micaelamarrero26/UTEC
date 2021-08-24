import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAOPersona {
	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CUENTA FROM PERSONA";
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONA";
	public static int cuentaPersonas() {
		int cuenta = 0;
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_PERSONAS);
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				cuenta = resultado.getInt("CUENTA");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return cuenta;
	}
	
	public static LinkedList<String> findAll(){
		LinkedList<String> personas = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_PERSONAS);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				String persona = resultado.getString("NOMBRE1") + " " + resultado.getString("APELLIDO1");
				personas.add(persona);
			}
			return personas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
