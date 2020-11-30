package webdvan.dto;

import java.util.ArrayList;
import java.util.List;

import webdvan.models.Endereco;
import webdvan.models.Usuario;

public class RequisicaoEntrega {
	public String nome;
	public String valor;
	public String cepOrigem;
	public String uf;
	public String cidade;
	public String bairro;
	public String logradouro;
	public String cepDestino;
	public String ufDestino;
	public String cidadeDestino;
	public String bairroDestino;
	public String logradouroDestino;
	public Long idAssociado;
	public long idRota;
	public Usuario user;
	
	
	public String getLogradouroDestino() {
		return logradouroDestino;
	}
	public void setLogradouroDestino(String logradouroDestino) {
		this.logradouroDestino = logradouroDestino;
	}
	public Long getIdAssociado() {
		return idAssociado;
	}
	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valo) {
		this.valor = valo;
	}
	public String getCepOrigem() {
		return cepOrigem;
	}
	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCepDestino() {
		return cepDestino;
	}
	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
	public String getUfDestino() {
		return ufDestino;
	}
	public void setUfDestino(String ufDestino) {
		this.ufDestino = ufDestino;
	}
	public String getCidadeDestino() {
		return cidadeDestino;
	}
	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}
	public String getBairroDestino() {
		return bairroDestino;
	}
	public void setBairroDestino(String bairroDestino) {
		this.bairroDestino = bairroDestino;
	}
	public List<Endereco> toEndereco() {
		Endereco enderecoOrigem = new Endereco();
		enderecoOrigem.setLogradouro(logradouro);
		enderecoOrigem.setBairro(bairro);
		enderecoOrigem.setCep(cepOrigem);
		enderecoOrigem.setCidade(cidade);
		enderecoOrigem.setUf(uf);
		enderecoOrigem.setUsuario(user);
		Endereco enderecoDestino = new Endereco();
		enderecoDestino.setBairro(bairroDestino);
		enderecoDestino.setCep(cepDestino);
		enderecoDestino.setCidade(cidadeDestino);
		enderecoDestino.setLogradouro(logradouroDestino);
		enderecoDestino.setUf(ufDestino);
		enderecoDestino.setUsuario(user);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(enderecoOrigem);
		enderecos.add(enderecoDestino);
		return enderecos;
	}
	
	
}
