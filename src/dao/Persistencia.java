package dao;
import java.awt.Window.Type;
import java.util.List;

public interface Persistencia<T> {
    void salvar(String arquivo, List<T> objetos); // Salva uma lista de objetos em um arquivo
    List<T> carregar(String arquivo, Type tipoLista); // Carrega uma lista de objetos de um arqui
	List<T> carregar(String arquivo, java.lang.reflect.Type tipoLista);
}