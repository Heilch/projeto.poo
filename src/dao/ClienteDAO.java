package dao;

import model.Cliente;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import exception.DuplicadoEx;
import exception.FormatoInvalidoEx;

public class ClienteDAO {
    private static final String ARQUIVO_JSON = "clientes.json"; 
    private List<Cliente> clientes; 
    private PersistenciaJSON<Cliente> persistencia; 
    
    public ClienteDAO() {
        persistencia = new PersistenciaJSON<>(); 
        clientes = new ArrayList<>(); 
        carregarClientes(); 
    }
    
    
    private void carregarClientes() {
        Type tipoListaClientes = new TypeToken<ArrayList<Cliente>>() {}.getType(); 
        List<Cliente> clientesCarregados = persistencia.carregar(ARQUIVO_JSON, tipoListaClientes); 
        if (clientesCarregados != null) {
            clientes = clientesCarregados; 
        }
    }
    
    private void salvarClientes() {
        persistencia.salvar(ARQUIVO_JSON, clientes); 
    }
     
    public void adicionarCliente(Cliente cliente) throws DuplicadoEx, FormatoInvalidoEx {
        if (!validarCpf(cliente.getCpf())) {
            throw new FormatoInvalidoEx("CPF inválido.");
        }
        if (!validarTelefone(cliente.getTelefone())) {
            throw new FormatoInvalidoEx("Telefone inválido.");
        }
        if (!validarEmail(cliente.getEmail())) {
            throw new FormatoInvalidoEx("E-mail inválido.");
        }
        if (buscarClientePorCpf(cliente.getCpf()) != null) {
            throw new DuplicadoEx("Cliente com CPF " + cliente.getCpf() + " já cadastrado.");
        }
        if (buscarClientePorCpf(cliente.getCpf()) != null) {
            throw new DuplicadoEx("Cliente com CPF " + cliente.getCpf() + " já cadastrado.");
        }
        clientes.add(cliente);
        salvarClientes();
    }
    
    public void removerCliente(String cpf) {
        clientes.removeIf(cliente -> cliente.getCpf().equals(cpf)); 
        salvarClientes(); 
    }
    
    public Cliente buscarClientePorCpf(String cpf) {
        return clientes.stream()
        	.filter(cliente -> cliente.getCpf().equals(cpf)) 
            .findFirst() 
            .orElse(null); 
    }
    
    
    public List<Cliente> listarTodosClientes() {
        return clientes; 
    }
    
    public static boolean validarCpf(String cpf) {
	    return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
	}
	
	public static boolean validarTelefone(String telefone) {
	    return telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}");
	}
	
	public static boolean validarEmail(String email) {
	    return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	}
    
    public void atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(clienteAtualizado.getCpf())) {
                clientes.set(i, clienteAtualizado); 
                salvarClientes(); 
                break;
            }
        }
    }
}