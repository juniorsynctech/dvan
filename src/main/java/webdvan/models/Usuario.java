package webdvan.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	//1 - Cliente / 2 - Associado
	protected int tipo;
	@Column(length = 15)
	protected String senha;
	@Column(length = 13)
	protected String telefone;
	
	@Column(unique=true)
	protected String email;
	@OneToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Endereco enderecos;

	public Usuario(int tipo, String senha, String email) {
		super();
		this.tipo = tipo;
		this.senha = senha;
		this.email = email;
	}
	
	public Usuario() {
		
	}
	
	

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}

