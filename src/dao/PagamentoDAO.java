package dao;

import com.google.gson.reflect.TypeToken;
import model.Pagamento;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    private static final String ARQUIVO_JSON = "pagamentos.json";
    private List<Pagamento> pagamentos; 
    private PersistenciaJSON<Pagamento> persistencia; 
    
    public PagamentoDAO() {
        persistencia = new PersistenciaJSON<>(); 
        pagamentos = new ArrayList<>(); 
        carregarPagamentos(); 
    }
 
    private void carregarPagamentos() {
        Type tipoListaPagamentos = new TypeToken<ArrayList<Pagamento>>() {}.getType(); 
        List<Pagamento> pagamentosCarregados = persistencia.carregar(ARQUIVO_JSON, tipoListaPagamentos); 
        if (pagamentosCarregados != null) {
            pagamentos = pagamentosCarregados; 
        }
    }
    
    private void salvarPagamentos() {
        persistencia.salvar(ARQUIVO_JSON, pagamentos);
    }
    
    public void adicionarPagamento(Pagamento pagamento) {
        if (pagamento != null) {
            pagamentos.add(pagamento); 
            salvarPagamentos(); 
        }
    }
    
    public void removerPagamento(String idPagamento) {
        pagamentos.removeIf(pagamento -> pagamento.getIdPagamento());
        salvarPagamentos(); 
    }
    
    public Pagamento buscarPagamentoPorId(String idPagamento) {
        return pagamentos.stream()
                .filter(pagamento -> pagamento.getIdPagamento()) 
                .findFirst() 
                .orElse(null); 
    }
    
    public List<Pagamento> listarTodosPagamentos() {
        return pagamentos; 
    }
    
    public void atualizarPagamento(Pagamento pagamentoAtualizado) {
        for (int i = 0; i < pagamentos.size(); i++) {
            if (pagamentos.get(i).getIdPagamento()) {
                pagamentos.set(i, pagamentoAtualizado);
                salvarPagamentos(); 
                break;
            }
        }
    }
    
    public List<Pagamento> buscarPagamentosPorLocacao(String idLocacao) {
        List<Pagamento> pagamentosLocacao = new ArrayList<>();
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getIdLocacao()) {
                pagamentosLocacao.add(pagamento); 
            }
        }
        return pagamentosLocacao; 
}
}
