package webdvan.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import lombok.Data;

@Entity
@Data
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
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
			
}
