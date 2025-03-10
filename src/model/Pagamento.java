package model;

import java.time.LocalDate;

public class Pagamento {
	private boolean idPagamento;
	private boolean idLocacao;
	private double valorPago;
	private LocalDate dataPagamento;
	private String metodoPagamento;
	
	public Pagamento(boolean idPagamento, boolean idLocacao, double valorPago, LocalDate dataPagamento, String metodoPagamento) {
	    this.idPagamento = idPagamento;
	    this.idLocacao = idLocacao;
	    this.valorPago = valorPago;
	    this.dataPagamento = dataPagamento;
	    this.metodoPagamento = metodoPagamento;
	}
	
	public boolean getIdPagamento() {
		return idPagamento;
	}
	
	public boolean getIdLocacao() {
       return idLocacao;
    }
	
	public double getValorPago() {
	    return valorPago;
	}
	
	public LocalDate getDataPagamento() {
	    return dataPagamento;
	}
	
	public String getMetodoPagamento() {
	    return metodoPagamento;
	}
	    
	public void setValorPago(double valorPago) {
	    this.valorPago = valorPago;
	}
	
	public void setDataPagamento(LocalDate dataPagamento) {
	   this.dataPagamento = dataPagamento;
	}
  
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
}
