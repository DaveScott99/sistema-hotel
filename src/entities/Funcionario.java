package entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class Funcionario {

	private int id;
	private String nome;
	private String setor;
	private int horasTrabalhadas;
	private double valorPorHora;
	private double salario = 0;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public double getValorPorHora() {
		return valorPorHora;
	}
	
	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void cadastrar() {
		this.id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário: "));
		this.nome = JOptionPane.showInputDialog("Nome do funcionário: ");
		this.setor = JOptionPane.showInputDialog("Setor (Manobrista / Recepcionista / Faxineiro): ");
		this.valorPorHora = Double.parseDouble(JOptionPane.showInputDialog("Valor por hora: "));
	}
	
	public void mostrar() {
		
		String mensagem = "Cadastro de funcionario";
		
		mensagem += "\nCódigo: " + this.id;
		mensagem += "\nNome: " + this.nome;
		mensagem += "\nSetor: " + this.setor;
		
		NumberFormat converterNumero = DecimalFormat.getCurrencyInstance();
		
		mensagem += "\nSalario: " + converterNumero.format(this.salario);
		
		JOptionPane.showMessageDialog(null, mensagem);
				
	}
	
	public void pagamento() {
		salario = horasTrabalhadas * valorPorHora;
	}
	
	public void trabalhar() {
		int horas = Integer.parseInt(JOptionPane.showInputDialog("Quer trabalhar quantas horas: "));
		
		JOptionPane.showMessageDialog(null, "Trabalhando...");
		
		setHorasTrabalhadas(horas);
	}
	
	public void abonoSalario(double taxa) {
		salario += salario * taxa/100;
	}
	
}
