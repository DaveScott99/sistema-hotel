package application;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Atendente;
import entities.Camareiro;
import entities.Funcionario;
import entities.Manobrista;

public class Main {
	
	static List<Funcionario> funcionarios = new ArrayList<>();

	public static void main(String[] args) {

		menu();		
		
	}
	
	public static void menu() {
		
		int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: "
				+ "\n\n1 - Registrar funcionário"
				+ "\n2 - Listar funcionário"
				+ "\n3 - Sair\n\n", ""));
		
		switch (escolha) {
			case 1:
				cadastrarFuncionario();
				menu();
				break;
			case 2:
				listarFuncionarios();
				menu();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "ERRO: Opção inválida");
				menu();
				break;
		}

	}
	
	public static void cadastrarFuncionario() {
		
		String setor = JOptionPane.showInputDialog("Setor (Manobrista / Atendente / Camareiro): ").toUpperCase();
		
		switch (setor) {
			case "MANOBRISTA":
				Manobrista manobrista = new Manobrista();
				manobrista.cadastrar();
				manobrista.setSetor(setor);
				funcionarios.add(manobrista);
				menu();
				break;
			case "ATENDENTE":
				Atendente atendente = new Atendente();
				atendente.cadastrar();
				atendente.setSetor(setor);
				funcionarios.add(atendente);
				menu();
				break;
			case "CAMAREIRO":
				Camareiro camareiro = new Camareiro();
				camareiro.cadastrar();
				camareiro.setSetor(setor);
				funcionarios.add(camareiro);
				menu();
				break;
			default:
				JOptionPane.showMessageDialog(null, "ERRO: Cargo inválido");
				cadastrarFuncionario();
				break;
			}
		
	}
	
	public static void listarFuncionarios() {
		
		String listaFuncionarios = "Lista de Funcionários:\n";
		
		NumberFormat formatarSalario = NumberFormat.getCurrencyInstance();
		
		for(Funcionario func : funcionarios) {
			
			listaFuncionarios += "\nCÓDIGO: " + func.getId() 
								+ "\nNOME: " + func.getNome() 
								+ "\nCARGO: " + func.getSetor() 
								+ " \nSALÁRIO: " 
								+ formatarSalario.format(func.getSalario());
			
			listaFuncionarios += "\n--------------------";
		}
		
		int idFuncionario = Integer.parseInt(JOptionPane.showInputDialog(listaFuncionarios+ "\n\nCódigo: "));
		
		selecionarFuncionarioPorId(idFuncionario);
	
	}
	
	public static Funcionario buscarFuncionario(Integer id) {
		for (Funcionario func : funcionarios) {
			if (func.getId().equals(id)) {
				return func;
			}
		}
		return null;
	}
	
	public static void selecionarFuncionarioPorId(Integer id) {		
		
		Funcionario funcionarioSelecionado = buscarFuncionario(id);	
		
		if (funcionarioSelecionado instanceof Manobrista) {
			
			menuManobrista(funcionarioSelecionado);
			
		}
		else {
			if (funcionarioSelecionado instanceof Atendente) {
				
				menuAtendente(funcionarioSelecionado);
				
			}
			else {
				if (funcionarioSelecionado instanceof Camareiro) {
					
					menuCamareiro(funcionarioSelecionado);
					
				}
			}
		}
		
	}
	
	public static String exibirDados(Funcionario funcionario) {
		
		NumberFormat formatarSalario = NumberFormat.getCurrencyInstance();
		
		return "\nCÓDIGO: " + funcionario.getId() 
				+ "\nNOME: " + funcionario.getNome()
				+ "\nCARGO: " + funcionario.getSetor() 
				+ "\nSALÁRIO: " + formatarSalario.format(funcionario.getSalario());
		
	}
	
	public static void menuManobrista(Funcionario funcionario) {
		
		String menu = "\nEscolha uma opção: "
				+ "\n1 - Estacionar carros"
				+ "\n2 - Pagamento"
				+ "\n3 - Voltar\n\n";
		
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(exibirDados(funcionario) + "\n" + menu,  ""));
		
		switch (escolha) {
			case 1:
				int carros = Integer.parseInt(JOptionPane.showInputDialog("Quantos carros estacionados: "));
				((Manobrista) funcionario).setCarrosGuardados(carros);
				listarFuncionarios();
				break;
			case 2:
				double taxa = Integer.parseInt(JOptionPane.showInputDialog("Percentual de taxa: "));
				((Manobrista) funcionario).pagamento(taxa);
				listarFuncionarios();
				break;
			case 3:
				listarFuncionarios();
				break;
		
		}
	
	}
	
	public static void menuAtendente(Funcionario funcionario) {
		
		String menu = "\nEscolha uma opção: "
				+ "\n1 - Registrar estadia"
				+ "\n2 - Listar quartos"
				+ "\n3 - Pagamento"
				+ "\n4 - Voltar\n\n";
		
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(exibirDados(funcionario) + "\n" + menu, ""));
		
		switch (escolha) {
			case 1:
				((Atendente) funcionario).registrarEstadia();
				listarFuncionarios();
				break;
			case 2:
				((Atendente) funcionario).listarQuartos();
				listarFuncionarios();
				break;
			case 3:
				double taxa = Integer.parseInt(JOptionPane.showInputDialog("Percentual de taxa: "));
				((Atendente) funcionario).pagamento(taxa);
				listarFuncionarios();
				break;
			case 4:
				listarFuncionarios();
				break;
		}
		
	}
	
	public static void menuCamareiro(Funcionario funcionario) {
		
		String menu = "\nEscolha uma opção: "
				+ "\n1 - Arrumar quarto"
				+ "\n2 - Pagamento"
				+ "\n3 - Voltar\n\n";
		
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(exibirDados(funcionario) + "\n" + menu, ""));
		
		switch (escolha) {
			case 1:
				int quartos = Integer.parseInt(JOptionPane.showInputDialog("Quantos quartos arrumados: "));
				((Camareiro) funcionario).setQuartosArrumados(quartos);
				listarFuncionarios();
				break;
			case 2:
				double taxa = Integer.parseInt(JOptionPane.showInputDialog("Percentual de taxa: "));
				((Camareiro) funcionario).pagamento(taxa);
				listarFuncionarios();
				break;
			case 3:
				listarFuncionarios();
				break;
		}
	}
	
}
