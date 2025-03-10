package model;

public class Carro extends Veiculo{
	@Override
	public double calcularCustoLocacao(int dias) {
		return dias * 100;
	}
	
	public Carro(String placa, String modelo, String ano) {
		super();
		this.ano = ano;
		this.placa = placa;
		this.modelo = modelo;
		
	}
	
}
