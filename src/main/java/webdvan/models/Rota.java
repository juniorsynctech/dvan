package webdvan.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.Nullable;

@Entity
public class Rota implements Serializable {

	private static final long serialVersionUID = 1L;
	/* dados obg dvan */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Nullable
	private String nome;
	@Nullable @Column(name = "idassociado")  
	private long idAssociado;
	private double valor;
	private String horapartida;
	private String horachegada;
	private String diasrota;
	private String ceporigem;
	private String cepdestino;
	
	/*dados por viacep app */
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String ibge;
	 
	private String logradourodestino;
	private String complementodestino;
	private String bairrodestino;
	private String cidadedestino;
	private String ufdestino;
	private String ibgedestino;
	
	/*dados para Maps*/
	private String lat;
	private String lng;
	
	private String latdestino;
	private String lngdestino;
	
	public Rota() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getHorapartida() {
		return horapartida;
	}

	public void setHorapartida(String horapartida) {
		this.horapartida = horapartida;
	}

	public String getHorachegada() {
		return horachegada;
	}

	public void setHorachegada(String horachegada) {
		this.horachegada = horachegada;
	}

	public String getDiasrota() {
		return diasrota;
	}

	public void setDiasrota(String diasrota) {
		this.diasrota = diasrota;
	}

	public String getCeporigem() {
		return ceporigem;
	}

	public void setCeporigem(String ceporigem) {
		this.ceporigem = ceporigem;
	}

	public String getCepdestino() {
		return cepdestino;
	}

	public void setCepdestino(String cepdestino) {
		this.cepdestino = cepdestino;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getLogradourodestino() {
		return logradourodestino;
	}

	public void setLogradourodestino(String logradourodestino) {
		this.logradourodestino = logradourodestino;
	}

	public String getComplementodestino() {
		return complementodestino;
	}

	public void setComplementodestino(String complementodestino) {
		this.complementodestino = complementodestino;
	}

	public String getBairrodestino() {
		return bairrodestino;
	}

	public void setBairrodestino(String bairrodestino) {
		this.bairrodestino = bairrodestino;
	}

	public String getCidadedestino() {
		return cidadedestino;
	}

	public void setCidadedestino(String cidadedestino) {
		this.cidadedestino = cidadedestino;
	}

	public String getUfdestino() {
		return ufdestino;
	}

	public void setUfdestino(String ufdestino) {
		this.ufdestino = ufdestino;
	}

	public String getIbgedestino() {
		return ibgedestino;
	}

	public void setIbgedestino(String ibgedestino) {
		this.ibgedestino = ibgedestino;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLatdestino() {
		return latdestino;
	}

	public void setLatdestino(String latdestino) {
		this.latdestino = latdestino;
	}

	public String getLngdestino() {
		return lngdestino;
	}

	public void setLngdestino(String lngdestino) {
		this.lngdestino = lngdestino;
	}
	
	
	
}
