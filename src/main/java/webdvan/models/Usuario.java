package webdvan.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	//1 - Cliente / 2 - Associado
	private int tipo;
	private String senha;
	
	@Column(unique=true)
	private String email;

	public Usuario(int tipo, String senha, String email) {
		super();
		this.tipo = tipo;
		this.senha = senha;
		this.email = email;
	}
	
	public Usuario() {
		
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

