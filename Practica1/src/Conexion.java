/**
 * @author Itzel Azucena Delgado D�az
 * @date 20/02/2022
 * 
 * Clase que nos ayuda a crear la conexi�n entre java y la base de datos. (lo busque en internet)
 *
 **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db_practica01";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {

			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexi�n con la base de datos OK. :D");
		}catch(SQLException e) {
			System.out.println("Error en la conexi�n");
			e.printStackTrace();
		}
		return conexion;
	}
	

}