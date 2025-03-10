package model;

public class Moto extends Veiculo{
	
	@Override
	public double calcularCustoLocacao(int dias) {
		return dias * 50;
	}
	
	public Moto(String placa, String modelo, String ano) {
		super();
		this.ano = ano;
		this.placa = placa;
		this.modelo = modelo;
		
	}
}
