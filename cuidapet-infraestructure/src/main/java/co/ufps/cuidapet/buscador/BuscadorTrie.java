package co.ufps.cuidapet.buscador;
import co.ufps.cuidapet.pet.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Esta clase BuscadorTrie implementa la interfaz AnimalRepositorio
 * utiliza una estructura de datos Trie para búsquedas rápidas y eficientes
 * de animales por nombre y un Map para el tipo de especie.
 */
public class BuscadorTrie implements AnimalRepositorio {
    //Mapa convina el filtro de especie y raza del animal para busqueda rapida
    private final Map<String, Trie> atributos = new HashMap();
    private final Map<String, Pet> animales = new HashMap();

    //Recibe una lista de animales para buscar entre ellas
    public BuscadorTrie(List<Pet> lista){
        for(Pet a:lista){
            String atributo1=a.getEspecie();
            String nombre=a.getRaza().toLowerCase().replaceAll("\\s+", "");

            if(this.atributos.containsKey(atributo1)){
                this.atributos.get(atributo1).insertar(nombre);
            }else{
                this.atributos.put(atributo1, new Trie());
                this.atributos.get(atributo1).insertar(nombre);
            }

            this.animales.put(nombre, a);
        }
    }

    //Metodo de busqueda que recibe el nombre del animal y especie si hay
    @Override
    public List<Pet> buscar(String nombre, String especie) {
        List<String> coincidencias = new ArrayList<>();
        List<Pet> animales=new ArrayList<>();

        if(nombre==null && especie==null){
            return animales;
        }

        String normalizado="";
        if(nombre!=null){
            normalizado = nombre.toLowerCase().replaceAll("\\s+", "");
        }

        if(especie != null) {
            Trie trie = atributos.get(especie);

            if(trie != null) {
                coincidencias.addAll(trie.buscarPorPrefijo(normalizado));
            }

        }else {

            for (Trie trie : atributos.values()) {
                coincidencias.addAll(trie.buscarPorPrefijo(normalizado));
            }
        }

        //Se usa busqueda difusa por que no encontro por el prefijo del arbol Trie
        if(coincidencias.isEmpty()) {
            coincidencias.addAll(this.busquedaDifusa(normalizado, especie));
        }

        //Teniendo las key con las coincidencias de la busqueda, se toman los animales coincidentes de la busqueda
        for(String key:coincidencias){
            animales.add(this.animales.get(key));
        }
        return animales;
    }

    //Busca cuando no se encuentra el prefijo
    private List<String> busquedaDifusa(String texto,String especie) {
        List<String> similares = new ArrayList<>();

        if(especie != null) {
            Trie trie = atributos.get(especie);

            if (trie != null) {
                List<String> palabras = trie.buscarPorPrefijo("");

                for (String palabra : palabras) {
                    int distancia = this.levenshtein(texto, palabra);

                    if (distancia <= 2) {
                        similares.add(palabra);
                    }
                }
            }

        }else {
            for (Trie trie : atributos.values()) {
                List<String> palabras = trie.buscarPorPrefijo("");

                for (String palabra : palabras) {
                    int distancia = levenshtein(texto, palabra);

                    if (distancia <= 2) {
                        similares.add(palabra);
                    }
                }
            }
        }

        return similares;
    }

    //Mide la cantidad de errores en la entrada de la busqueda
    private int levenshtein(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {

                int costo = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1,dp[i][j - 1] + 1),dp[i - 1][j - 1] + costo);
            }
        }

        return dp[a.length()][b.length()];
    }
}
