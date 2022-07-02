package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Processo {
	
	private ArrayList<Historico> historico = new ArrayList<>();
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private int numero;
	private String finalidade;
	private String descricao;
	private String dataEntrada;
	private Boolean concluido;
	private Date data = new Date();
	private Setor setorDestino;
	private String parecer = "Aguardando Atendimento";
	
	
	
	public Processo(int numero, String finalidade, String descricao, Setor setorDestino) {
		this.numero = numero;
		this.finalidade = finalidade;
		this.descricao = descricao;
		this.dataEntrada = sdf1.format(data);
		this.setorDestino = setorDestino;
		this.concluido = false;
	}
	
	
	public String getParecer() {
		return parecer;
	}
	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Setor getSetorDestino() {
		return setorDestino;
	}

	public void setSetorDestino(Setor setorDestino) {
		this.setorDestino = setorDestino;
	}

	public Boolean estaConcluido() {
		return concluido;
	}

	public void setStatus(Boolean concluido) {
		this.concluido = concluido;
	}
	
	

	public Boolean getConcluido() {
		return concluido;
	}


	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}


	public String getStatus() {
		return this.concluido == true ? "Concluido" : "Em analise";

	}
	
	public void addHistorico(Historico historico) {
		this.historico.add(historico);
	}

	public void removeHistorico(Historico historico) {
		this.historico.remove(historico);
	}
	
	public ArrayList<Historico> getListHistorico() {
		return historico;
	}

	public String toString() {
		return "\nNumero do Processo: " + numero + "\nFinalidade: " + finalidade + "\nDescricao: " + descricao
				+ "\nData de Entrada: " + dataEntrada + "\n" + setorDestino + "\nStatus do processo: "
				+ this.getStatus() + "\nParecer: " + parecer + "\n" ;
	}

}
