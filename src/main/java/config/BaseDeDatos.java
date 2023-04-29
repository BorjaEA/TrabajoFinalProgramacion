package config;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class BaseDeDatos {
	public static final String cadenaConexion = "jdbc:mysql://localhost/prueba";
	public static final String usuarioBD = "root";
	public static final String passBD = "";

	public static ResultSet consultar(String query) {
		// Conectar y crear un statement
		// hacer la consulta que diga query. Si es un select, hacerlo con executeQuery,
		// y devolver el resultset que la funcion te devuelve
		// Si no es un select, hacerlo con executeUpdate, y devlover null del tirón.
		// cerrar statement
		// cerrar conexion
		try (Connection conn = DriverManager.getConnection(cadenaConexion, usuarioBD, passBD);
				Statement stmt = conn.createStatement();) {

			if (query.contains("SELECT") || query.contains("select")) {
				return stmt.executeQuery(query);
			} else {
				stmt.executeUpdate(query);
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static boolean insertar(String tabla, ArrayList<String> datos)  {
		try (Connection conn = DriverManager.getConnection(cadenaConexion, usuarioBD, passBD);
				Statement stmt = conn.createStatement();) {
			if (!stmt.executeQuery("SELECT nombre FROM usuario WHERE nombre ='" + datos.get(0) + "'").isBeforeFirst()) {
				String sql = "INSERT INTO " + tabla + " (";
				
				ResultSet rs = stmt.executeQuery("select * from " + tabla + "");
				ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();
				// Retrieving the list of column names
				int nColum = rsMetaData.getColumnCount();
				ArrayList <String> tipos = new ArrayList<>();
				for (int i = 1; i <= nColum; i++) {
					tipos.add(rsMetaData.getColumnTypeName(i));
					if(i != nColum) {
						sql += rsMetaData.getColumnName(i)+", ";
					}else {
						sql += rsMetaData.getColumnName(i);
					}
				}
				sql += ") VALUES (";
				for (int i = 1; i <= nColum; i++) {
					if(i != nColum) {
						sql += "?,";
					}else {
						sql += "?)";
					}
				}
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				for (int i = 1; i <= nColum; i++) {
					switch (rsMetaData.getColumnTypeName(i)) {
					case "VARCHAR" -> pStmt.setString(i, datos.get(i-1));
					case "INT" -> pStmt.setInt(i, Integer.parseInt(datos.get(i-1)));
					case "NUMERIC" -> pStmt.setBigDecimal(i, new BigDecimal(datos.get(i-1)));
					case "DATE" -> {
						SimpleDateFormat formato1 = new SimpleDateFormat("dd-MM-yyyy");
						java.util.Date date = formato1.parse(datos.get(i-1));
						pStmt.setDate(i,new java.sql.Date(date.getTime()));
					}
					}
				}
				
				
				pStmt.executeUpdate();
				pStmt.close();
				
				
				


				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
