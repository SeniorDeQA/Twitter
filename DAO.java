package selenium;

import java.sql.*;

public class DAO {
	static Connection conn = null;
	
	
	//Definimos una conn, escuchando 3 tipos de excepciones
	public static void defineConnection(String cadenaConexion, String usuario, String clave) throws SQLException {
		String url = cadenaConexion; //"jdbc:mysql://localhost:3306/";
		String user = usuario;
		String password = clave;
		
		
		try {
			   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
			}
			catch(IllegalAccessException ex) {
			   System.out.println("Error: access problem while loading!");
			   System.exit(2);
			}
			catch(InstantiationException ex) {
			   System.out.println("Error: unable to instantiate driver!");
			   System.exit(3);
			}

		
		conn = DriverManager.getConnection(url, user, password);
		
	}

	static Connection getConnection() {
		return conn;
	}

	static void closeConnection() {
		conn = null;
		System.out.println("Cerrada conexión");
	}
	
	
	//Le pasamos un string sql a la clase, y la ejecuta
	static void resultadosPorNavegador(String QueNavegador){
		
		
		try {
			
			PreparedStatement pst = DAO.getConnection().prepareStatement("SELECT * FROM pruebas.resultados_selenium WHERE (Navegador = ?);");
			pst.setString(1, QueNavegador);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next() ){
				System.out.println (rs.getString ("Id") + " / " + rs.getString ("Fecha") + " / " + rs.getString("Tipo") + " / " + rs.getString("Resultado"));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("-- Fin consulta a BBDD --");
		}

	}
	
	static void insertaTrazaTest(String queTest, String QueNavegador, String debug, int resulTest){
		try {
			
			
			PreparedStatement pst = DAO.getConnection().prepareStatement("INSERT INTO pruebas.resultados_selenium (Proyecto,Tipo,Navegador,Resultado,Traza) VALUES ('Tuiter',?,?,?,?);");
			pst.setString(1, queTest);
			pst.setString(2, QueNavegador);
			pst.setInt(3, resulTest);
			pst.setString(4, debug);
			pst.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}

