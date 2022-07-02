package application;

import java.util.ArrayList;

import entities.Aluno;
import entities.Funcionario;
import entities.Setor;

public class Sistema {
	private ArrayList<Aluno> listAlunos = new ArrayList<Aluno>();
	private ArrayList<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
	private ArrayList<Setor> listSetores = new ArrayList<Setor>();

	public Sistema() {

	}

	public ArrayList<Aluno> getListAlunos() {
		return listAlunos;
	}

	public void setListAlunos(ArrayList<Aluno> listAlunos) {
		this.listAlunos = listAlunos;
	}

	public ArrayList<Funcionario> getListFuncionarios() {
		return listFuncionarios;
	}

	public void setListFuncionarios(ArrayList<Funcionario> listFuncionarios) {
		this.listFuncionarios = listFuncionarios;
	}

	public ArrayList<Setor> getListSetores() {
		return listSetores;
	}

	public void setListSetores(ArrayList<Setor> listSetores) {
		this.listSetores = listSetores;
	}

	public void adicionaAluno(Aluno aluno) {
		this.listAlunos.add(aluno);
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		this.listFuncionarios.add(funcionario);
	}

	public void adicionaSetor(Setor setor) {
		this.listSetores.add(setor);
	}

	public void removeSetor(Setor setor) {
		this.listSetores.remove(setor);
	}

	public void removeAluno(Aluno aluno) {
		this.listAlunos.remove(aluno);
	}

	public void removeFuncionario(Funcionario funcionario) {
		this.listFuncionarios.remove(funcionario);
	}

}
