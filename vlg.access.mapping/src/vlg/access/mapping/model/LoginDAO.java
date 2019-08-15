package vlg.access.mapping.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vlg.access.mapping.model.ConnectionFactory;
import vlg.access.mapping.model.Login;

public class LoginDAO {
	private String usuarioLogadoDAOS;
	public String getUsuarioLogadoDAOS() {
		return usuarioLogadoDAOS;
	}

	public void setUsuarioLogadoDAOS(String usuarioLogadoDAOS) {
		this.usuarioLogadoDAOS = usuarioLogadoDAOS;
	}
	
	
	
	

		
	public Login selecionarPorLogin(String lg) {
		Login login = new Login();
		try {
			String sql = "select * from acessos where login =?";
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, lg);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				login.setId(rs.getInt("id"));
				login.setLogin(rs.getString("login"));
				login.setSenha(rs.getString("senha"));
				
				
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
		}
		return login;
	}
	
	
	public List<Login> selecionarPorUser(String lg) {
		List<Login> logins = new ArrayList<Login>();
		try {
			String sql = "select * from acessos where login=?";
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, lg);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Login l = new Login();
				l.setId(rs.getInt("id"));
				l.setNome(rs.getString("nome"));
				l.setLogin(rs.getString("login"));
				l.setSenha(rs.getString("senha"));
				l.setUser_Network(rs.getString("user_Network"));
				l.setSenha_Network(rs.getString("senha_Network"));
				
				
				logins.add(l);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
		}
		return logins;
	}
	
	public String MudarSenhaAcesso(String user, String novaSenha) {
		//UPDATE acessos SET senha='VLG1234' WHERE login='pedroazzam';
		
		try {
			String sql = "UPDATE acessos SET senha=? WHERE login=?";

			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, novaSenha);
			stmt.setString(2, user);

			stmt.execute();

			stmt.close();
			con.close();
			return "OK";
			
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
			return ex.getMessage();
		}
		
		
	}
		
	public List<Login> selecionartodos() {
		List<Login> logins = new ArrayList<Login>();
		try {
			String sql = "select * from Logins order by nome";
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Login l = new Login();
				l.setId(rs.getInt("id"));
				l.setNome(rs.getString("nome"));
				l.setLogin(rs.getString("login"));
				l.setSenha(rs.getString("senha"));
				
				
				logins.add(l);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
		}
		return logins;
	}
	
	
	

}
