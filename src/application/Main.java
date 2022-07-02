package application;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Aluno;
import entities.Funcionario;
import entities.Historico;
import entities.Processo;
import entities.Setor;

public class Main {

	static Sistema sistema = new Sistema();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Declaracao de setores
		sistema.adicionaSetor(new Setor(1, "Financeiro"));
		sistema.adicionaSetor(new Setor(2, "T.I"));
		sistema.adicionaSetor(new Setor(3, "Secretaria"));
		sistema.adicionaSetor(new Setor(4, "Biblioteca"));

		menu();// chama menu

		sc.close();
	}

	public static void menu() {// Menu

		int numeroCad = 0;
		System.out.println("Opcoes\n " + "1 - Cadastrar Solicitacao\n "
				+ "2 - Verificar lista de Setores e Processos\n" + " 9 - Sair");
		int numeroMenu = sc.nextInt();
		if (numeroMenu == 1) {
			System.out.println("1 - Sou Funcionario\n" + "2 - Sou aluno\n" + "9 - Sair");
			numeroCad = sc.nextInt();
			if (numeroCad == 1) {// Cadastro funcionario
				System.out.println("\n1 - Realizar Cadastro\n" + "2 - Tenho Cadastro\n" + "9 - Sair");
				int opcaocad = sc.nextInt();
				sc.nextLine();// Consumir resto da linha do nextInt
				if (opcaocad == 1) {
					cadastrofuncionario();
				} else if (opcaocad == 2) {
					checkfuncionario();
				}

			} else if (numeroCad == 2) {// Cadastro aluno
				System.out.println("\n1 - Realizar Cadastro\n" + "2 - Tenho Cadastro\n" + "9 - Sair");
				int opcaocad = sc.nextInt();
				sc.nextLine();// Consumir resto da linha do nextInt
				if (opcaocad == 1) {
					cadastroaluno();
				} else if (opcaocad == 2) {
					checkaluno();
				}
			} else if (numeroCad == 9) {
				return;
			}
		}  else if (numeroMenu == 2) {
			System.out.println("1 - Exibir Lista de Setores\n" + "2 - Consultar Lista de Processo por Setor\n"
					+ "3 - Consultar e Modificar Processos\n" + "9 - Sair\n");
			int selecOpcoes = sc.nextInt();
			sc.nextLine();// Consumir resto da linha do nextInt
			if (selecOpcoes == 1) {
				for (Setor x : sistema.getListSetores()) {// mostra setores cadastrados
					System.out.println(x);
				}
				menu();
			} else if (selecOpcoes == 2) {
				processosetor();
			} else if (selecOpcoes == 3) {
				consprocesso();
			} else if (selecOpcoes == 9) {
				menu();
			}
		} else if (numeroMenu == 9) {
			return;
		} else {
			System.out.println("Digite uma Opcao valida");
			menu();
		}

	}

	public static void processo(Aluno aluno, Funcionario funcionario) {// Cadastro de uma nova solicitacao
		int numProcesso = 0;
		
		for (Funcionario fun : sistema.getListFuncionarios()) {
			numProcesso += fun.getListProcessos().size();
		}

		for (Aluno aluno1 : sistema.getListAlunos()) {
			numProcesso += aluno1.getListProcessos().size();
		}
		////// NOVO PROCESSO/////
		System.out.print("Qual a Finalidade do Processo? ");
		String finalidade = sc.nextLine();
		System.out.println("Descricao do Processo: ");
		String descricao = sc.nextLine();
		System.out.println("Lista de setores:\n");
		for (Setor x : sistema.getListSetores()) {// mostra setores cadastrados
			System.out.println(x);
		}
		System.out.print("Digite o codigo do setor destino: ");
		int codsetor = sc.nextInt();

		Setor setorDestino = sistema.getListSetores().stream().filter(x -> codsetor == x.getCodigo()).findFirst()
				.orElse(null);
		if (setorDestino == null) {
			System.out.println("Setor Destino nao encontrado\n");
			menu();
		}
		if (aluno != null) {
			aluno.addProcesso(new Processo(numProcesso, finalidade, descricao, setorDestino));
		} else {
			funcionario.addProcesso(new Processo(numProcesso, finalidade, descricao, setorDestino));
		}
		System.out.println("Processo cadastrado com sucesso\n");

		sc.nextLine();// Consumir resto da linha do nextInt
		menu();
	}

	public static void consprocesso() {// Consulta em processo
		
		Processo selProcesso = null;
		Funcionario funcionario = null;
		Aluno aluno = null;
		
		System.out.print("Numero do Processo: \n");

		int numProc = sc.nextInt();

		for (Funcionario fun : sistema.getListFuncionarios()) {
			Processo aux = fun.getListProcessos().stream().filter(x -> x.getNumero() == numProc).findFirst()
					.orElse(null);
			if (aux != null) {
				selProcesso = aux;
				funcionario = fun;
			}
		}
		if (selProcesso == null) {

			for (Aluno aluno1 : sistema.getListAlunos()) {
				Processo aux = aluno1.getListProcessos().stream().filter(x -> x.getNumero() == numProc).findFirst()
						.orElse(null);
				if (aux != null) {
					selProcesso = aux;
					aluno = aluno1;
				}
			}
		}

		if (selProcesso == null) {
			System.out.println("Processo nao encontrado");
		} else {
			System.out.println("Dados do solicitante: ");
			if (aluno != null) {
				System.out.println(aluno + "\n");
			} else {
				System.out.println(funcionario + "\n");
			}
			System.out.println("Dados do Processo :\n" + selProcesso);
			System.out.println("1 - Alterar Status do Processo\n" + "2 - Alterar Setor do Processo\n"
					+ "3 - Alterar o parecer do Processo\n" + "4 - Historico do Processo\n" + "9 - Sair");
			int altProcesso = sc.nextInt();
			if (altProcesso == 1) {
				System.out.println("1 - Em analise\n" + "2 - Concluido\n");
				int aux = sc.nextInt();
				if (aux == 1) {
					selProcesso.setStatus(false);
				} else if (aux == 2) {
					selProcesso.setStatus(true);
				}
			} else if (altProcesso == 2) {
				System.out.print("Digite o codigo do setor destino: ");
				int codsetor = sc.nextInt();
				Setor setorDestino = sistema.getListSetores().stream().filter(x -> codsetor == x.getCodigo())
						.findFirst().orElse(null);
				if (setorDestino == null) {
					System.out.println("Setor Destino nao encontrado\n");
					menu();
				}
				selProcesso.setSetorDestino(setorDestino);
				selProcesso.addHistorico(new Historico(selProcesso.getConcluido(), selProcesso.getParecer(), setorDestino));
				
			} else if (altProcesso == 3) {
				sc.nextLine();// Consumir resto da linha do nextInt
				System.out.println("Qual o Parecer:");
				String parecer = sc.nextLine();
				selProcesso.setParecer(parecer);
				
			}
			
			else if (altProcesso == 4) {
				List<Historico> result = selProcesso.getListHistorico();
				
				for (Historico x : result) {
					System.out.println(x);
				}
			}
			
			else if (altProcesso == 9) {
				menu();
			}
		}

		menu();
	}

	public static void cadastrofuncionario() {// cadastro funcionario
		String nome = " ";
		String email = " ";
		String telefone = " ";
		String cpf = " ";
		String numRegistro = " ";

		System.out.print("Numero de Registro: ");
		numRegistro = sc.nextLine();
		final String numReg = numRegistro;
		Funcionario checkcad = sistema.getListFuncionarios().stream().filter(x -> numReg.equals(x.getNumeroRegistro()))
				.findFirst().orElse(null);
		if (checkcad != null) {
			System.out.println("Usuario ja cadastrado!");
			menu();
		}
		System.out.print("Nome: ");
		nome = sc.nextLine();
		System.out.print("Cargo: ");
		String cargo = sc.nextLine();
		System.out.print("Email: ");
		email = sc.nextLine();
		System.out.print("Telefone: ");
		telefone = sc.nextLine();
		System.out.print("CPF: ");
		cpf = sc.nextLine();
		sistema.adicionaFuncionario(new Funcionario(nome, cpf, email, telefone, numRegistro, cargo));
		Funcionario selFun = sistema.getListFuncionarios().stream().filter(x -> numReg.equals(x.getNumeroRegistro()))
				.findFirst().orElse(null);
		processo(null, selFun);
		sc.nextLine();// Consumir resto da linha do nextInt
		menu();
	}


	public static void cadastroaluno() {// Cadastro de aluno
		String nome = " ";
		String email = " ";
		String telefone = " ";
		String cpf = " ";
		String matriculaAluno = " ";

		System.out.print("Matricula: ");
		matriculaAluno = sc.nextLine();
		final String numMat = matriculaAluno;
		Aluno checkcad = sistema.getListAlunos().stream().filter(x -> numMat.equals(x.getMatricula())).findFirst()
				.orElse(null);
		if (checkcad != null) {
			System.out.println("Usuario ja cadastrado!");
			menu();
		}
		System.out.print("Nome: ");
		nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		System.out.print("Email: ");
		email = sc.nextLine();
		System.out.print("Telefone: ");
		telefone = sc.nextLine();
		System.out.print("CPF: ");
		cpf = sc.nextLine();
		sistema.adicionaAluno(new Aluno(nome, cpf, email, telefone, matriculaAluno, curso));
		Aluno selAluno = sistema.getListAlunos().stream().filter(x -> numMat.equals(x.getMatricula())).findFirst()
				.orElse(null);
		processo(selAluno, null);

		sc.nextLine();// Consumir resto da linha do nextInt
		menu();
	}

	public static void checkfuncionario() {// verifica se o professor esta cadastrado
		String checkCpf = "";

		System.out.print("Numero de Registro: ");
		String numReg = sc.nextLine();
		System.out.print("Digite o CPF cadastrado: ");
		checkCpf = sc.nextLine();
		Funcionario selFun = sistema.getListFuncionarios().stream().filter(x -> numReg.equals(x.getNumeroRegistro()))
				.findFirst().orElse(null);
		if (selFun != null && checkCpf.equals(selFun.getCpf())) {
			
			processo(null, selFun);
		} else {
			System.out.println("Numero de Registro e/ou CPF incorreto ou nao cadastrado");
		}

		menu();
	}

	public static void checkaluno() {// verifica se o aluno esta cadastrado
		
		String checkCpf = "";

		System.out.print("Numero da Matricula: ");
		String numMat = sc.nextLine();
		System.out.print("Digite o CPF cadastrado: ");
		checkCpf = sc.nextLine();
		Aluno selAluno = sistema.getListAlunos().stream().filter(x -> numMat.equals(x.getMatricula())).findFirst()
				.orElse(null);
		if (selAluno != null && checkCpf.equals(selAluno.getCpf())) {
			processo(selAluno, null);
		} else {
			System.out.println("Numero de Registro e/ou CPF incorreto ou nao cadastrado");
		}

		menu();
	}

	public static void processosetor() {// Confere lista de processos pro setor
		List<Processo> result = null;
		System.out.println("Digite o codigo do setor: ");
		int codSetor = sc.nextInt();
		Setor setorDestino = sistema.getListSetores().stream().filter(x -> codSetor == x.getCodigo()).findFirst()
				.orElse(null);
		if (setorDestino == null) {
			System.out.println("Setor nao encontrado");
			menu();
		}
		for (Funcionario fun : sistema.getListFuncionarios()) {
			result = fun.getListProcessos().stream().filter(x -> x.getSetorDestino() == setorDestino)
					.collect(Collectors.toList());
		}
		if (result != null) {
			for (Processo x : result) {
				System.out.println(x);
			}
		}
		result = null;
		for (Aluno aluno : sistema.getListAlunos()) {
			result = aluno.getListProcessos().stream().filter(x -> x.getSetorDestino() == setorDestino)
					.collect(Collectors.toList());
		}

		if (result != null) {
			for (Processo x : result) {
				System.out.println(x);
			}
		}
		sc.nextLine();// Consumir resto da linha do nextInt
		menu();
	}

}