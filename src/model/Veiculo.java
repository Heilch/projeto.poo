package model;

public abstract class Veiculo {
	protected String placa;
	protected String modelo;
	protected String ano;
	protected boolean disponivel;
	
	public abstract double calcularCustoLocacao(int dias);
	
	public String getPlaca() {
		return placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}	
	public Object getPlacaVeiculo() {
		return null;
	}
	
}

