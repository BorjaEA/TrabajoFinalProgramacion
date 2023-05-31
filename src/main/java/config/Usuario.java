package config;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import partida.Partida;

public class Usuario {
	String nombre = "";
	String contraseña = "";

	public String getNombre() {
		return nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public Usuario(String nombre, String contraseña) {
		if (!this.nombre.equals(nombre) && !this.contraseña.equals(contraseña) && !BaseDeDatos.comprobarUsuario(nombre)) {
			this.nombre = nombre;
			this.contraseña = contraseña;
			ArrayList<String> u = new ArrayList<>();
			u.add(nombre);
			u.add(contraseña);
			BaseDeDatos.insertar("usuario", u);
		}else {
			this.nombre = nombre;
			this.contraseña = contraseña;
		}

	}

	public void insertarPartida(Partida p) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(BaseDeDatos.cadenaConexion, BaseDeDatos.usuarioBD, BaseDeDatos.passBD);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		try {

			try {
				FileReader reader = new FileReader("./Partidas guardadas/save.txt");


				ArrayList<String> a = new ArrayList<>();
				BaseDeDatos.insertReader(conn, reader);

				reader = new FileReader("./Partidas guardadas/save.txt");
				String tmp = String.valueOf(BaseDeDatos.comprobarIdLongText(conn, "partidaguardada", reader));
				a.add(this.nombre);
				a.add(tmp);

				BaseDeDatos.insertar("usuario_partidaguardada", a);
				reader.close();
			} catch (SQLException | IOException e) {
				System.out.println(e.getMessage());
			}
			
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
