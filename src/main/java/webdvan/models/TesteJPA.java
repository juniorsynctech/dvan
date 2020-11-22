package webdvan.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TesteJPA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String valor;
	@OneToMany(mappedBy = "teste", cascade = CascadeType.PERSIST)
	private List<TesteJpaOutraTabela> teste = new ArrayList<>();
	
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
	public List<TesteJpaOutraTabela> getTeste() {
		return teste;
	}
	public void setTeste(TesteJpaOutraTabela teste) {
		this.teste.add(teste);
	}
	
	
	
	
	
}
