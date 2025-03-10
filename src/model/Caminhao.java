package model;

public class Caminhao extends Veiculo{
	
	@Override
	public double calcularCustoLocacao(int dias) {
		return dias * 50;
	}
	
	public Caminhao(String placa, String modelo, String ano) {
		super();
		this.ano = ano;
		this.placa = placa;
		this.modelo = modelo;
		
	}
}
