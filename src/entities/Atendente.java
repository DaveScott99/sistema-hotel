package entities;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.enums.StatusQuarto;

public class Atendente extends Funcionario {
	
	private int hospedesAtendidos;
	
	private List<Quarto> quartos = new ArrayList<>();

	public int getHospedesAtendidos() {
		return hospedesAtendidos;
	}

	public void setHospedesAtendidos(int hospedesAtendidos) {
		this.hospedesAtendidos = hospedesAtendidos;
	}
	
	@Override
	public void pagamento(double taxa) {
		super.pagamento(hospedesAtendidos * taxa);
	}

	public void registrarEstadia() {
		
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Numero quarto: "));
		int andar = Integer.parseInt(JOptionPane.showInputDialog("Andar: "));
		double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do quarto: "));
		char classe = JOptionPane.showInputDialog("Classe: ").charAt(0); 
		
		Quarto quarto = new Quarto(numero, andar, preco, classe, registrarHospede());
		quarto.setStatus(StatusQuarto.OCUPADO);
		
		quartos.add(quarto);
		
		hospedesAtendidos++;
	}
	
	public Hospede registrarHospede() {
		
		String nome = JOptionPane.showInputDialog("Nome: ");
		String email = JOptionPane.showInputDialog("Email: ");
		String telefone = JOptionPane.showInputDialog("Telefone: ");
		
		Hospede hospede = new Hospede(nome, email, telefone);
		
		return hospede;
		
	}
	
	public void listarQuartos() {
		
		String listaQuartos = "Lista de Quartos";
		
		for (Quarto quarto : quartos) {
			listaQuartos += "\nQuarto nº: " + quarto.getNumeroQuarto() + " Andar: " + quarto.getAndar() + " " + quarto.getStatus() + " por " + quarto.getHospede().getNome();
		}
		
		JOptionPane.showMessageDialog(null, listaQuartos);

	}

}
