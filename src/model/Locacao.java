package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao{
	private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private static int contador = 1;
	private int idLocacao;
	
	public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataRetirada, LocalDate dataDevolucao) {
		this.idLocacao = contador++;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
	}
	
    public Cliente getCliente() {
		return cliente;
	}
    
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public LocalDate getDataRetirada() {
		return dataRetirada;
	}
	
	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public Object getIdLocacao() {
		return idLocacao;
	}
	
	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}
	
	public double calcularValor() {
        long dias = ChronoUnit.DAYS.between(dataRetirada, dataDevolucao);
        return veiculo.calcularCustoLocacao((int) dias);
    }

	public Object getCpf() {
		return null;
	}

	public Object getPlaca() {
		return null;
	}
	
}
