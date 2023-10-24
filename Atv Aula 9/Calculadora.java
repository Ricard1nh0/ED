import java.util.*;

class Calculadora {
    private Set<Character> operadores = new HashSet<>(Arrays.asList('+', '-', '*', '/'));
    private Map<Character, Integer> precedencia = new HashMap<>();

    public Calculadora() {
        precedencia.put('+', 1);
        precedencia.put('-', 1);
        precedencia.put('*', 2);
        precedencia.put('/', 2);
    }

    public String paraPosfixa(String expressao) {
        StringBuilder resultado = new StringBuilder();
        Deque<Character> pilha = new ArrayDeque<>();

        for (char token : expressao.toCharArray()) {
            if (Character.isDigit(token)) {
                resultado.append(token);
            } else if (operadores.contains(token)) {
                resultado.append(" ");
                while (!pilha.isEmpty() && operadores.contains(pilha.peek()) &&
                        precedencia.get(pilha.peek()) >= precedencia.get(token)) {
                    resultado.append(pilha.pop()).append(" ");
                }
                pilha.push(token);
            }
        }

        while (!pilha.isEmpty()) {
            resultado.append(" ").append(pilha.pop());
        }

        return resultado.toString().trim();
    }

    public double calcular(String posfixa) {
        return 0;
    }
}


