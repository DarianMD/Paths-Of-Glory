package conexionBaseDeDatos;

import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;

import JuegoPaises.*;


public class ConexionBaseDatos {

	private static final String USUARIO = "DAW1_500091138497";
	private static final String PASSWORD = "A500091138497" ;
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";




	public ArrayList<Pais> getEquiposGuardados() {

		Connection con = null;
		String query = "SELECT * FROM PARTIDA";
		ArrayList<Pais> equipos = new ArrayList<Pais>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			con = DriverManager.getConnection(URL,USUARIO,PASSWORD);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while(rs.next()) {

				String nombre = rs.getString("NOMBRE");
				String tipo = rs.getString("TIPO");
				double vida = rs.getDouble("VIDA");

				Pais equipo = this.returnPaisTipoEspecificado(tipo, nombre);
				equipo.setVida(vida);

				equipos.add(equipo);
				

			}

			st.executeUpdate("TRUNCATE TABLE PARTIDA");
			System.out.println("Hehe");
			
			con.close();
			st.close();

		}catch(Exception e) {
			System.out.println(e);
		}
		return equipos;

	}


	public Pais returnPaisTipoEspecificado(String tipo,String nombre) {
		switch(tipo) {
		case"España":
			return new PaisEspania(nombre);

		case"Alemania":
			return new PaisAlemania(nombre);

		case "Francia":
			return new PaisFrancia(nombre);

		case "Italia":
			return new PaisItalia(nombre);

		case "Marruecos":
			return new PaisMarruecos(nombre);

		case "Noruega":
			return new PaisNoruega(nombre);

		case "Portugal":
			return new PaisPortugal(nombre);

		case "URSS":
			return new PaisURSS(nombre);

		case "USA":
			return new PaisUSA(nombre);

		case "Rumania":
			return new PaisRumania(nombre);
		}
		return null;
	}
	
	
	public void setPaisesBaseDatos(ArrayList<Pais> equipos) {
		
		Connection con = null;
		
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			con = DriverManager.getConnection(URL,USUARIO,PASSWORD);
			
			Statement st = con.createStatement();
			
			
			for(int i=0;i<equipos.size();i++) {
				String query = "INSERT INTO PARTIDA VALUES('"+ equipos.get(i).getNombre() + "','"+ equipos.get(i).getTipo() + "',"+ equipos.get(i).getVida() +")";
				st.execute(query);
				System.out.println("Valor insertadoo");
			}
			
			st.close();
			con.close();
			

		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	

}
