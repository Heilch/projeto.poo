package dao;

import model.Veiculo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import exception.DuplicadoEx;

public class VeiculoDAO {
	
    private static final String ARQUIVO_JSON = "veiculos.json"; 
    private List<Veiculo> veiculos; 
    private PersistenciaJSON<Veiculo> persistencia; 
    
    public VeiculoDAO() {
        persistencia = new PersistenciaJSON<>(); 
        veiculos = new ArrayList<>(); 
        carregarVeiculos(); 
    }
    
    private void carregarVeiculos() {
        Type tipoListaVeiculos = new TypeToken<ArrayList<Veiculo>>() {}.getType(); 
        List<Veiculo> veiculosCarregados = persistencia.carregar(ARQUIVO_JSON, tipoListaVeiculos);
        if (veiculosCarregados != null) {
            veiculos = veiculosCarregados; 
        }
    }
    
    private void salvarVeiculos() {
        persistencia.salvar(ARQUIVO_JSON, veiculos); 
    }
    
    public void adicionarVeiculo(Veiculo veiculo) throws DuplicadoEx {
        if (buscarVeiculoPorPlaca(veiculo.getPlaca()) != null) {
            throw new DuplicadoEx("Veículo com placa " + veiculo.getPlaca() + " já cadastrado.");
        }
        veiculos.add(veiculo);
        salvarVeiculos();
    }
   
    public void removerVeiculo(String placa) {
        veiculos.removeIf(veiculo -> veiculo.getPlaca().equals(placa));
        salvarVeiculos(); 
    }
    
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculos.stream().filter(veiculo -> veiculo.getPlaca().equals(placa)).findFirst().orElse(null); 
    }
    
    public List<Veiculo> listarTodosVeiculos() {
        return veiculos; 
    }
    
    public void atualizarVeiculo(Veiculo veiculoAtualizado) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(veiculoAtualizado.getPlaca())) {
                veiculos.set(i, veiculoAtualizado); 
                salvarVeiculos(); 
                break;
            }
        }
    }
}