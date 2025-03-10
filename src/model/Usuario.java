package model;

import java.util.ArrayList;

public class Usuario {
	private String tipo;
    private String nome;
    private String email;
    private String senha;
    private static ArrayList<String> usuariosCadastrados = new ArrayList<>();
    private static ArrayList<String> senhasUsuarios = new ArrayList<>();
    
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public static boolean salvarUsuario(String nome, String senha) {
        if (nome.isEmpty() || senha.isEmpty()) {
            System.out.println("Nome e senha são obrigatórios.");
            return false;
        }
        
        if (usuariosCadastrados.contains(nome)) {
            System.out.println("Usuário já cadastrado.");
            return false;
        }
        
        usuariosCadastrados.add(nome);
        senhasUsuarios.add(senha);
        
        System.out.println("Usuário cadastrado com sucesso!");
        return true;
    }
    
	public String getTipo() {
		return tipo;
	}
}
