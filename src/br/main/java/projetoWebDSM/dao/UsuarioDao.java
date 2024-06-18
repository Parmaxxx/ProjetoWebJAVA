package projetoWebDSM.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import projetoWebDSM.model.Usuario;

public class UsuarioDao {

	public void cadastrarUsuario(Usuario user) {
		
		String sql= "insert into usuario values(null,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getNome());
			pStatement.setString(2, user.getLogin());
			pStatement.setString(3, user.getSenha());
			pStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();			}
		}
	}
	
	public Usuario BuscarUsuarioPorID(long id) {
		String sql = "select * from usuario where idUsuario = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Usuario user = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setLong(1, id);
			rs = pStatement.executeQuery();
			if(rs!=null && rs.next()) {
				user = new Usuario();
				user.setidUsuario(rs.getLong("idUsuario"));
				user.setNome(rs.getString("nome"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
					
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();			}
		}
		
		
		
		return user;
	}
	
	public ArrayList<Usuario> BuscarUsuariosPorLogin(String login){
		String sql = "select * from usuario where login like '%"+login+"%'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Usuario user = null;
		ArrayList<Usuario> usuarios = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if(rs!=null) {
				usuarios = new ArrayList<Usuario>();
				while(rs.next()) {
					user = new Usuario();
					user.setidUsuario(rs.getLong("idUsuario"));
					user.setNome(rs.getString("nome"));
					user.setLogin(rs.getString("login"));
					user.setSenha(rs.getString("senha"));
					usuarios.add(user);	
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();			}
		}
		
		
		return usuarios;
	}
	
	
	public void ExcluirProduto(long idUsuario) {
		String sql = "delete from usuario where idUsuario = ?";
		PreparedStatement pStatement=null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setLong(1, idUsuario);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();			}
		}
	}
	
	public void AlterarProduto(Usuario user) {
		String sql = "update usuario set nome = ?, login = ?, senha = ? where idUsuario = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getNome());
			pStatement.setString(2, user.getLogin());
			pStatement.setString(3, user.getSenha());
			pStatement.setLong(4, user.getidUsuario());
			pStatement.execute();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}
				
		
		
	}
	
	
	
	
	
}
