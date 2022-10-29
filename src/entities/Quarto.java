package entities;

import entities.enums.StatusQuarto;

public class Quarto {

	private int numeroQuarto;
	private int andar;
	private double preco;
	private char classe;
	
	private StatusQuarto status;
	
	private Hospede hospede;
	
	public Quarto(int numeroQuarto, int andar, double preco, char classe, Hospede hospede) {
		this.numeroQuarto = numeroQuarto;
		this.andar = andar;
		this.preco = preco;
		this.classe = classe;
		this.hospede = hospede;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	public int getAndar() {
		return andar;
	}
	
	public void setAndar(int andar) {
		this.andar = andar;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public StatusQuarto getStatus() {
		return status;
	}

	public void setStatus(StatusQuarto status) {
		this.status = status;
	}

	public char getClasse() {
		return classe;
	}

	public void setClasse(char classe) {
		this.classe = classe;
	}
	
	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	@Override
	public String toString() {
		return "Quarto [numeroQuarto=" + numeroQuarto + ", andar=" + andar + ", preco=" + preco + ", classe=" + classe
				+ ", status=" + status + "]";
	}
	
	
}
