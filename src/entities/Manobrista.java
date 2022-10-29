package entities;

public class Manobrista extends Funcionario {
	
	private int carrosGuardados;
	private double gorjeta;
	
	public int getCarrosGuardados() {
		return carrosGuardados;
	}
	
	public void setCarrosGuardados(int carrosGuardados) {
		this.carrosGuardados = carrosGuardados;
	}
	
	public double getGorjeta() {
		return gorjeta;
	}
	
	public void setGorjeta(double gorjeta) {
		this.gorjeta = gorjeta;
	}

	@Override
	public void abonoSalario(double taxa) {
		
		double percentualCarrosGuardados = carrosGuardados/100;
		
		super.abonoSalario(taxa + percentualCarrosGuardados);
	}
	
}
