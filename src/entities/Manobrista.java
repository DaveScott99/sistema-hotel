package entities;

public class Manobrista extends Funcionario {
	
	private int carrosGuardados;
	
	public int getCarrosGuardados() {
		return carrosGuardados;
	}
	
	public void setCarrosGuardados(int carrosGuardados) {
		this.carrosGuardados = carrosGuardados;
	}

	@Override
	public void pagamento(double taxa) {
		super.pagamento(carrosGuardados * taxa);
	}
	
}
