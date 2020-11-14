package webdvan.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rota implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "cidade_origem")
	private String cidadeOrigem;
	@Column(name = "cidade_destino")
	private String cidadeDestino;
	@Column(name = "id_usuario")
	private long idUsuario;
	@Column(name = "consultaRota")
	private String consulta = (this.cidadeOrigem +" - "+this.cidadeDestino);
	
	public Rota() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCidadeOrigem() {
		return cidadeOrigem;
	}
	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}
	public String getCidadeDestino() {
		return cidadeDestino;
	}
	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
