package webdvan.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String telefone;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	public Telefone(int tipo, String senha, String email, String telefone) {
		super(tipo, senha, email);
		this.telefone = telefone;
	}
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Telefone() {
		super();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	
	

}
