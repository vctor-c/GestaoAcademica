package entities;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	private String matricula;
	private String curso;
	
	private ArrayList<Processo> processos = new ArrayList<>();


	public Aluno(String nome, String cpf, String email, String telefone, String matricula, String curso) {
		super(nome, cpf, email, telefone);
		this.matricula = matricula;
		this.curso = curso;
	}
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public void addProcesso(Processo processos) {
		this.processos.add(processos);
	}

	public void removeProcesso(Processo processos) {
		this.processos.remove(processos);
	}
	
	public ArrayList<Processo> getListProcessos() {
		return processos;
	}

	@Override
	public String toString() {
		return "\nMatricula: " + matricula + "\nNome: " + super.getNome() + "\nCpf: " + super.getCpf() + "\nEmail: "
				+ super.getEmail() + "\nTelefone: " + super.getTelefone() + "\nCurso: " + curso;
	}

}
