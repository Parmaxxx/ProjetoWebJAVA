package projetoWebDSM.model;

import java.util.ArrayList;

import projetoWebDSM.dao.UsuarioDao;

public class Usuario {

    private long idUsuario;

    private String nome;
    private String login;
    private String senha;

    public long getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario() {}
    public Usuario(long idUsuario, String nome, String login, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return ("\nID: " + idUsuario + "\nNome: " + nome + "\nLogin: " + login + "\nSenha: " + senha);
    }

	public void salvar() {
		new UsuarioDao().cadastrarUsuario(this);
		
	}
	public ArrayList<Usuario> BuscarUsuariosPorLogin(String login){
		return new UsuarioDao().BuscarUsuariosPorLogin(login);
	}
	public void excluir(long idUsuario) {
		new UsuarioDao().ExcluirProduto(idUsuario);
	}
	
	public Usuario buscarUsuarioPorId(long idUsuario) {
		return new UsuarioDao().BuscarUsuarioPorID(idUsuario);
	}
	
	public void alterar() {
		new UsuarioDao().AlterarProduto(this);
	}
}