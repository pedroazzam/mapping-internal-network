package vlg.access.mapping.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverNetworkDAO {
	
	
	public List<DriverNetwork> selecionarDriversPorUserTable(String user_table) {
		List<DriverNetwork> drivers = new ArrayList<DriverNetwork>();
		try {
			String sql = "select * from " + user_table + " u join drivers d on u.id_drivers=d.id";
			
			System.out.println("o select eh: " + sql);
			
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DriverNetwork d = new DriverNetwork();
				//d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				d.setLetra(rs.getString("letra"));
				
				
				drivers.add(d);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
		}
		return drivers;
	}
	
	public List<DriverNetwork> selecionarDrivers() {
		List<DriverNetwork> drivers = new ArrayList<DriverNetwork>();
		try {
			String sql = "select * from drivers";
			
			System.out.println("o select eh: " + sql);
			
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DriverNetwork d = new DriverNetwork();
				//d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				d.setLetra(rs.getString("letra"));
				
				
				drivers.add(d);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
		}
		return drivers;
	}
	
	
	

}
