package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Historico {

	private String dataEncaminhamento;
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date data = new Date();
	private Setor setorDestino;
	private String parecer;
	private Boolean concluido;

	public Historico(boolean concluido, String parecer, Setor setorDestino) {
		this.dataEncaminhamento = sdf1.format(data);
		this.concluido = concluido; // retornar Em analise ou concluido
		this.setorDestino = setorDestino;
		this.setParecer(parecer);
	}

	public Setor getSetor() {
		return setorDestino;
	}

	public void setSetor(Setor setor) {
		this.setorDestino = setor;
	}

	public String getDataEncaminhamento() {
		return dataEncaminhamento;
	}

	public void setDataEncaminhamento(String dataEncaminhamento) {
		this.dataEncaminhamento = dataEncaminhamento;
	}

	public boolean isProcessoConcluido() {
		return concluido;
	}

	public void setProcessoConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	
	public String getStatus() {
		return this.concluido == true ? "Concluido" : "Em analise";

	}
	

	public String toString() {
		return "Data de Encaminhamento: " + dataEncaminhamento + "\nOrgao Destino: "
				+ setorDestino.getNome() + "\nParecer:\n" + parecer + "\nSituacao do Processo: " + this.getStatus() + "\n";
	}


}
