package webdvan.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	/* dados obg dvan */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Nullable @Column(name = "idassociado")  
	private long idAssociado;
	private String cep;
	
	/*dados por viacep app */
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	
	public Endereco () {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdAssociado() {
		return idAssociado;
	}
	public void setIdAssociado(long idAssociado) {
		this.idAssociado = idAssociado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
			
}
