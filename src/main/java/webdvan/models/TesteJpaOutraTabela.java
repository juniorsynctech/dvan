package webdvan.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class TesteJpaOutraTabela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String valor;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "teste_id")
	private TesteJPA teste;
	
	
	
	@Override
	public String toString() {
		return "Teste de id "+ id +"\n"
				+"Nome: "+ nome+"\n"
				+"Valor: "+ valor +"\n"
				+"Entidade pai:"+ teste.getNome() +" "+ teste.getValor();
	}

	public TesteJpaOutraTabela(Long id, String nome, String valor, TesteJPA teste) {
		this.nome = nome;
		this.valor = valor;
		this.teste = teste;
	}
	
	public TesteJpaOutraTabela() {
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
	public void setValor(String valor) {
		this.valor = valor;
	}
	public TesteJPA getTeste() {
		return teste;
	}
	public void setTeste(TesteJPA teste) {
		this.teste = teste;
	}
	
	
}
