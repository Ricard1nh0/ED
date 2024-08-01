import java.util.*;

class Dijkstra {

    static class Aresta {
        String alvo;
        int peso;

        Aresta(String alvo, int peso) {
            this.alvo = alvo;
            this.peso = peso;
        }
    }

    static class Grafo {
        private final Map<String, List<Aresta>> vertices = new HashMap<>();

        void adicionarVertice(String nome, List<Aresta> arestas) {
            vertices.put(nome, arestas);
        }

        Map<String, Integer> dijkstra(String inicio) {
            final Map<String, Integer> distancias = new HashMap<>();
            final PriorityQueue<Aresta> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(aresta -> aresta.peso));
            final Map<String, String> anterior = new HashMap<>();

            for (String vertice : vertices.keySet()) {
                if (vertice.equals(inicio)) {
                    distancias.put(vertice, 0);
                } else {
                    distancias.put(vertice, Integer.MAX_VALUE);
                }
                filaPrioridade.add(new Aresta(vertice, distancias.get(vertice)));
                anterior.put(vertice, null);
            }

            while (!filaPrioridade.isEmpty()) {
                Aresta menor = filaPrioridade.poll();
                if (menor.peso == Integer.MAX_VALUE) break;

                for (Aresta vizinho : vertices.get(menor.alvo)) {
                    int alt = distancias.get(menor.alvo) + vizinho.peso;
                    if (alt < distancias.get(vizinho.alvo)) {
                        distancias.put(vizinho.alvo, alt);
                        filaPrioridade.add(new Aresta(vizinho.alvo, alt));
                        anterior.put(vizinho.alvo, menor.alvo);
                    }
                }
            }

            return distancias;
        }
    }

    public static void main(String[] args) {
        
        Grafo grafoEx1 = new Grafo();
        grafoEx1.adicionarVertice("A", Arrays.asList(new Aresta("B", 140), new Aresta("D", 85)));
        grafoEx1.adicionarVertice("B", Arrays.asList(new Aresta("A", 140), new Aresta("F", 26), new Aresta("H", 0), new Aresta("J", 0)));
        grafoEx1.adicionarVertice("C", Arrays.asList(new Aresta("D", 19), new Aresta("I", 126), new Aresta("F", 12)));
        grafoEx1.adicionarVertice("D", Arrays.asList(new Aresta("A", 85), new Aresta("E", 39), new Aresta("C", 19)));
        grafoEx1.adicionarVertice("E", Arrays.asList(new Aresta("D", 39), new Aresta("G", 30), new Aresta("I", 105)));
        grafoEx1.adicionarVertice("F", Arrays.asList(new Aresta("B", 26), new Aresta("C", 12), new Aresta("M", 67), new Aresta("L", 65), new Aresta("H", 100)));
        grafoEx1.adicionarVertice("G", Arrays.asList(new Aresta("E", 30), new Aresta("I", 74)));
        grafoEx1.adicionarVertice("H", Arrays.asList(new Aresta("B", 0), new Aresta("J", 0), new Aresta("L", 70), new Aresta("F", 100)));
        grafoEx1.adicionarVertice("I", Arrays.asList(new Aresta("C", 126), new Aresta("E", 105), new Aresta("G", 74), new Aresta("M", 30)));
        grafoEx1.adicionarVertice("J", Arrays.asList(new Aresta("B", 0), new Aresta("H", 0), new Aresta("N", 61)));
        grafoEx1.adicionarVertice("L", Arrays.asList(new Aresta("P", 31), new Aresta("H", 70), new Aresta("F", 65)));
        grafoEx1.adicionarVertice("M", Arrays.asList(new Aresta("I", 30), new Aresta("F", 67), new Aresta("P", 110)));
        grafoEx1.adicionarVertice("N", Arrays.asList(new Aresta("J", 61), new Aresta("P", 70)));
        grafoEx1.adicionarVertice("P", Arrays.asList(new Aresta("M", 110), new Aresta("L", 31), new Aresta("N", 70)));

        Map<String, Integer> distanciasEx1 = grafoEx1.dijkstra("A");
        System.out.println("Distâncias a partir do vértice A no Exercício 1: " + distanciasEx1);

        
        Grafo grafoEx2 = new Grafo();
        grafoEx2.adicionarVertice("Mercearia", Arrays.asList(new Aresta("B", 11), new Aresta("C", 5), new Aresta("D", 8)));
        grafoEx2.adicionarVertice("B", Arrays.asList(new Aresta("Mercearia", 11), new Aresta("D", 3), new Aresta("G", 8)));
        grafoEx2.adicionarVertice("C", Arrays.asList(new Aresta("Mercearia", 5), new Aresta("D", 2), new Aresta("E", 8)));
        grafoEx2.adicionarVertice("D", Arrays.asList(new Aresta("Mercearia", 8), new Aresta("B", 3), new Aresta("C", 2), new Aresta("E", 4), new Aresta("G", 12), new Aresta("H", 11)));
        grafoEx2.adicionarVertice("E", Arrays.asList(new Aresta("C", 8), new Aresta("D", 4), new Aresta("F", 15), new Aresta("H", 4)));
        grafoEx2.adicionarVertice("F", Arrays.asList(new Aresta("H", 7), new Aresta("E", 15), new Aresta("G", 3), new Aresta("H", 7)));
        grafoEx2.adicionarVertice("G", Arrays.asList(new Aresta("D", 12), new Aresta("F", 3), new Aresta("H", 2)));
        grafoEx2.adicionarVertice("H", Arrays.asList(new Aresta("D", 11), new Aresta("E", 4), new Aresta("F", 7), new Aresta("G", 2)));

        Map<String, Integer> distanciasEx2 = grafoEx2.dijkstra("Mercearia");
        System.out.println("Distâncias a partir da Mercearia no Exercício 2: " + distanciasEx2);
    }
}
