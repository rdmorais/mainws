package mainWS;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	public boolean inserirUsuario(Usuario usuario) {
		
		try {
			Connection conn = ConectaMySQL.obtemConexao();
			
			String queryInserir = "INSERT INTO usuario VALUES (null, ?, ?, ?, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, usuario.getUsuario());
			ppStm.setString(2, usuario.getNome());
			ppStm.setString(3, usuario.getSenha());
			ppStm.setInt(4, usuario.getStatus());
			ppStm.setString(5, usuario.getCad_datahora());
			
			ppStm.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
public boolean atualizarUsuario(Usuario usuario) {
		
		try {
			Connection conn = ConectaMySQL.obtemConexao();
			
			String queryInserir = "UPDATE usuario SET (null, usuario = ?, nome = ?, senha = ?,  status = ?, cad_datahora = ? WHERE id = ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, usuario.getUsuario());
			ppStm.setString(2, usuario.getNome());
			ppStm.setString(3, usuario.getSenha());
			ppStm.setInt(4, usuario.getStatus());
			ppStm.setString(5, usuario.getCad_datahora());
			ppStm.setInt(6, usuario.getId());
			
			ppStm.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection conn = ConectaMySQL.obtemConexao();
			
			String queryInserir = "SELECT * FROM usuario";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()) {
				Usuario user = new Usuario();
				
				user.setId(rSet.getInt(1));
				user.setUsuario(rSet.getString(2));
				user.setNome(rSet.getString(3));
				user.setSenha(rSet.getString(4));
				user.setStatus(rSet.getInt(5));
				user.setCad_datahora(rSet.getString(6));
				
				lista.add(user);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public Usuario buscarUsuario(int id) {
		
		Usuario user = null;
		
		try {
			Connection conn = ConectaMySQL.obtemConexao();
			
			String queryInserir = "SELECT * FROM usuario WHERE id = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);			
			ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()) {
				user = new Usuario();
				user.setId(rSet.getInt(1));
				user.setUsuario(rSet.getString(2));
				user.setNome(rSet.getString(3));
				user.setSenha(rSet.getString(4));
				user.setStatus(rSet.getInt(5));
				user.setCad_datahora(rSet.getString(6));
			}else {
				return user;
			}
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
		
	}
	
	
	
	
	
}
