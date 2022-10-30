package entities;

public class Camareiro extends Funcionario {
	
	private int quartosArrumados;

	public int getQuartosArrumados() {
		return quartosArrumados;
	}

	public void setQuartosArrumados(int quartosArrumados) {
		this.quartosArrumados = quartosArrumados;
	}
	
	@Override
	public void pagamento(double taxa) {	
		super.pagamento(taxa * quartosArrumados);
	}	

}
