package controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import model.Cliente;
import model.Locacao;
import model.Pagamento;
import model.Veiculo;

public class LocacaoController {
    private List<Locacao> locacoes;
    private List<Veiculo> veiculos;
    
    public LocacaoController(List<Locacao> locacoes, List<Veiculo> veiculos) {
        this.locacoes = locacoes;
        this.veiculos = veiculos;
    }
    
    public void alugarVeiculo(Cliente cliente, String placaVeiculo, LocalDate retirada, LocalDate devolucao) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placaVeiculo);
        
        if (veiculo == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }
        
        if (!veiculo.isDisponivel()) {
            System.out.println("Veículo já está alugado!");
            return;
        }
        
        Locacao locacao = new Locacao(cliente, veiculo, retirada, devolucao);
        locacoes.add(locacao);
        veiculo.setDisponivel(false); 
        
        System.out.println("Locação realizada com sucesso! Valor estimado: R$" + locacao.calcularValor());
    }
    
    public void devolverVeiculo(String placaVeiculo, LocalDate dataRealDevolucao) {
        Locacao locacao = buscarLocacaoPorVeiculo(placaVeiculo);
        
        if (locacao == null) {
            System.out.println("Nenhuma locação encontrada para este veículo!");
            return;
        }
        
        Veiculo veiculo = locacao.getVeiculo();
        veiculo.setDisponivel(true);
        
        long diasPrevistos = ChronoUnit.DAYS.between(locacao.getDataRetirada(), locacao.getDataDevolucao());
        long diasReais = ChronoUnit.DAYS.between(locacao.getDataRetirada(), dataRealDevolucao);
        
        double valorTotal = locacao.calcularValor();
        double multa = 0;
        
        if (diasReais > diasPrevistos) {
            multa = (diasReais - diasPrevistos) * 50;
            System.out.println("Multa por atraso: R$" + multa);
        }
        
        double valorFinal = valorTotal + multa;
        Pagamento pagamento = new Pagamento(locacao.getIdLocacao(), valorFinal, dataRealDevolucao, metodoPagamento); List<Pagamento> pagamentos = pagamentoDAO.carregar(); pagamentos.add(pagamento); pagamentoDAO.salvar(pagamentos);
        
        System.out.println("Devolução concluída! Valor total a pagar: R$" + valorFinal);
    }
    
    public void listarVeiculosDisponiveis() {
        System.out.println("Veículos Disponíveis para Locação:");
        for (Veiculo v : veiculos) {
            if (v.isDisponivel()) {
                System.out.println("Placa: " + v.getPlaca() + " | Modelo: " + v.getModelo());
            }
        }
    }
    
    public void listarVeiculosLocados() {
        System.out.println("Veículos Locados:");
        for (Veiculo v : veiculos) {
            if (!v.isDisponivel()) {
                System.out.println("Placa: " + v.getPlaca() + " | Modelo: " + v.getModelo());
            }
        }
    }
    
    private Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
    
    private Locacao buscarLocacaoPorVeiculo(String placa) {
        for (Locacao locacao : locacoes) {
            if (locacao.getVeiculo().getPlaca().equalsIgnoreCase(placa)) {
                return locacao;
            }
        }
        return null;
    }
}
