import java.util.*;

public class Ejercicios {

    public static void eliminaClavesSinValor(Map<String, String> map) {/*
    Escribe, en el menor número de líneas de código posible, una funcionalidad que elimine todas las entradas de un
    Map cuyo valor sea null.
     */
       map.entrySet().removeIf(entry -> Objects.isNull(entry.getValue()));
    }

    public static  Map<String, String> intercambiarClaves(Map<String, String> map) {
        HashMap<String,String> nuevoMapa = new HashMap<>();
        Set<String> nuevoSet = new HashSet<>();
        for (Map.Entry<String, String> iterator : map.entrySet()) {
            String getKey = iterator.getKey();
            String getValue = iterator.getValue();
            if(!nuevoSet.add(getValue)) {
                throw new IllegalArgumentException("No se puede tener valores duplicados en el mapa");
            }
            nuevoSet.add(getValue);
            nuevoMapa.put(getValue,getKey);
        }
        return nuevoMapa;
    }

    public static void imprimirStrings(String[] cadenas) {
        TreeSet<String> treeSetPorLongitud = new TreeSet<>(new ComparadorPorLongitud());

        Collections.addAll(treeSetPorLongitud, cadenas);

        for (String cadena : treeSetPorLongitud) {
            System.out.println(cadena);
        }
    }

    static class ComparadorPorLongitud implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int comparacionPorLongitud = Integer.compare(s1.length(), s2.length());
            if (comparacionPorLongitud != 0) {
                return comparacionPorLongitud;
            }
            return s1.compareTo(s2);
        }
    }

    public static void main(String[] args) {
        String[] stringPrueba = {"b","a","jose","ala"};
        imprimirStrings(stringPrueba);
    }
}