package webdvan.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entrega implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idCliente;
	private long idAssociado;
	private long idRota;
	private long idEnderecoSaida;
	private long idEnderecoChegada;
	
	public Entrega() {
		
	}

	public Entrega(long id, long idCliente, long idAssociado, long idRota, long idEnderecoSaida,
			long idEnderecoChegada) {
		this.id = id;
		this.idCliente = idCliente;
		this.idAssociado = idAssociado;
		this.idRota = idRota;
		this.idEnderecoSaida = idEnderecoSaida;
		this.idEnderecoChegada = idEnderecoChegada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public long getIdRota() {
		return idRota;
	}

	public void setIdRota(long idRota) {
		this.idRota = idRota;
	}

	public long getIdEnderecoSaida() {
		return idEnderecoSaida;
	}

	public void setIdEnderecoSaida(long idEnderecoSaida) {
		this.idEnderecoSaida = idEnderecoSaida;
	}

	public long getIdEnderecoChegada() {
		return idEnderecoChegada;
	}

	public void setIdEnderecoChegada(long idEnderecoChegada) {
		this.idEnderecoChegada = idEnderecoChegada;
	}
	
	
}
