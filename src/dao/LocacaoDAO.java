package dao;
import model.Veiculo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import exception.VeiculoIndisponivelEx;
import model.Locacao;
import model.Cliente;
import model.Cliente;
public class LocacaoDAO {
	
    private static final String ARQUIVO_JSON = "locacoes.json";
    private List<Locacao> locacoes;
    private PersistenciaJSON<Locacao> persistencia;
    
    public LocacaoDAO() {
        persistencia = new PersistenciaJSON<>();
        locacoes = new ArrayList<>();
        carregarLocacoes();
    }
    
    private void carregarLocacoes() {
        Type tipoListaLocacoes = new TypeToken<ArrayList<Locacao>>() {}.getType();
        List<Locacao> locacoesCarregadas = persistencia.carregar(ARQUIVO_JSON, tipoListaLocacoes);
        if (locacoesCarregadas != null) {
            locacoes = locacoesCarregadas;
        }
    }
    
    private void salvarLocacoes() {
        persistencia.salvar(ARQUIVO_JSON, locacoes);
    }
    
    public void removerLocacao(String idLocacao) {
        locacoes.removeIf(locacao -> locacao.getIdLocacao().equals(idLocacao));
        salvarLocacoes();
    }
    
    public Locacao buscarLocacaoPorId(String idLocacao) {
        return locacoes.stream()
                .filter(locacao -> locacao.getIdLocacao().equals(idLocacao))
                .findFirst()
                .orElse(null);
    }
    
    public List<Locacao> listarTodasLocacoes() {
        return locacoes;
    }
    
    public void atualizarLocacao(Locacao locacaoAtualizada) {
        for (int i = 0; i < locacoes.size(); i++) {
            if (locacoes.get(i).getIdLocacao().equals(locacaoAtualizada.getIdLocacao())) {
                locacoes.set(i, locacaoAtualizada);
                salvarLocacoes();
                break;
            }
        }
    }
    
    public List<Locacao> buscarLocacoesPorCliente(String cpfCliente) {
        List<Locacao> locacoesCliente = new ArrayList<>();
        for (Locacao locacao : locacoes) {
            if (locacao.getCpf().equals(cpfCliente)) {
                locacoesCliente.add(locacao);
            }
        }
        return locacoesCliente;
    }
    
    public List<Locacao> buscarLocacoesPorVeiculo(String placaVeiculo) {
        List<Locacao> locacoesVeiculo = new ArrayList<>();
        for (Locacao locacao : locacoes) {
            if (locacao.getPlaca().equals(placaVeiculo)) {
                locacoesVeiculo.add(locacao);
            }
        }
        return locacoesVeiculo;
    }
}