package webdvan.dto;

public class BuscaEntrega {
	
	private long idRota;
	private String nomeAssociado;
	private String contatoAssociado;	
	private String consulta;
	
	public BuscaEntrega() {
		
	}
	

	public long getIdRota() {
		return idRota;
	}

	public void setIdRota(long idRota) {
		this.idRota = idRota;
	}


	public String getNomeAssociado() {
		return nomeAssociado;
	}
	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}
	public String getContatoAssociado() {
		return contatoAssociado;
	}
	public void setContatoAssociado(String contatoAssociado) {
		this.contatoAssociado = contatoAssociado;
	}
	public String getConsulta() {
		return consulta;
	}
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	

	
}
