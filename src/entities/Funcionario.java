package entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

public abstract class Funcionario {

	private Integer id;
	private String nome;
	private String setor;
	private Integer horasTrabalhadas;
	private Double valorPorHora;
	private Double salario = 0d;
	
	public Integer getId() {
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
	
	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public Double getValorPorHora() {
		return valorPorHora;
	}
	
	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void cadastrar() {
		this.id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário: "));
		this.nome = JOptionPane.showInputDialog("Nome do funcionário: ");
		this.valorPorHora = Double.parseDouble(JOptionPane.showInputDialog("Valor por hora: "));
		this.horasTrabalhadas = Integer.parseInt(JOptionPane.showInputDialog("Horas trabalhadas: "));
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
	
	public void pagamento(double taxa) {
		
		salario += horasTrabalhadas * valorPorHora;
		
		salario += salario * taxa/100;
	}


}
