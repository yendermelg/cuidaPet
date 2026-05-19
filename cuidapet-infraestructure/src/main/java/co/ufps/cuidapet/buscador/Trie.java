package co.ufps.cuidapet.buscador;
import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode raiz = new TrieNode();

    public void insertar(String palabra) {
        TrieNode actual = raiz;

        for (char c : palabra.toLowerCase().toCharArray()) {
            actual.hijos.putIfAbsent(c, new TrieNode());
            actual = actual.hijos.get(c);
        }

        actual.fin = true;
    }

    public List<String> buscarPorPrefijo(String prefijo) {
        List<String> resultados = new ArrayList<>();
        TrieNode actual = raiz;

        for(char c : prefijo.toLowerCase().toCharArray()) {

            if(!actual.hijos.containsKey(c)) {
                return resultados;
            }
            actual = actual.hijos.get(c);
        }

        dfs(actual, prefijo.toLowerCase(), resultados);

        return resultados;
    }

    private void dfs(TrieNode nodo, String palabra, List<String> resultados) {
        if(nodo.fin) {
            resultados.add(palabra);
        }

        for(char c : nodo.hijos.keySet()) {
            dfs(nodo.hijos.get(c), palabra + c, resultados);
        }
    }
}
