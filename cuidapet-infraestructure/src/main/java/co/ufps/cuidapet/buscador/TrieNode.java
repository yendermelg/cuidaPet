package co.ufps.cuidapet.buscador;
import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> hijos = new HashMap();
    boolean fin;
}
