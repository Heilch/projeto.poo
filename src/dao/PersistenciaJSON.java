package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PersistenciaJSON<T> implements Persistencia<T> {
	
    private Gson gson;
    
    public PersistenciaJSON() {
        gson = new GsonBuilder().setPrettyPrinting().create(); 
    }
    
    @Override
    public void salvar(String arquivo, List<T> objetos) {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(objetos, writer); 
        } catch (IOException e) {
            System.err.println("Erro ao salvar no arquivo JSON: " + e.getMessage());
        }
    }
    
    @Override
    public List<T> carregar(String arquivo, Type tipoLista) {
        try (FileReader reader = new FileReader(arquivo)) {
            return gson.fromJson(reader, tipoLista); 
        } catch (IOException e) {
            System.err.println("Erro ao carregar do arquivo JSON: " + e.getMessage());
            return null;
        }
    }

	@Override
	public List<T> carregar(String arquivo, java.awt.Window.Type tipoLista) {
		// TODO Auto-generated method stub
		return null;
	}
}
