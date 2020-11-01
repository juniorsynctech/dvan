package webdvan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entrega {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long usuario;
	private long associado;
	private long enderecoSaida;
	private long enderecoChegada;
	
	public Entrega() {
		
	}
	
	public long getUsuario() {
		return usuario;
	}
	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}
	public long getAssociado() {
		return associado;
	}
	public void setAssociado(long associado) {
		this.associado = associado;
	}
	public long getEnderecoSaida() {
		return enderecoSaida;
	}
	public void setEnderecoSaida(long enderecoSaida) {
		this.enderecoSaida = enderecoSaida;
	}
	public long getEnderecoChegada() {
		return enderecoChegada;
	}
	public void setEnderecoChegada(long enderecoChegada) {
		this.enderecoChegada = enderecoChegada;
	}	
}
