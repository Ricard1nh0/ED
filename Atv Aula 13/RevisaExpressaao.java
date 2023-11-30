import java.util.Scanner;
import java.util.Stack;

public class RevisaExpressaao {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a expressão: ");
            String expressao = scanner.nextLine();

            if (verificarParametrizacao(expressao)) {
                System.out.println("Expressão correta.");
            } else {
                System.out.println("Expressão incorreta.");
            }
        }
    }

    public static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty() || !verificarCorrespondencia(pilha.pop(), caractere)) {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }

    public static boolean verificarCorrespondencia(char aberto, char fechado) {
        return (aberto == '(' && fechado == ')') ||
               (aberto == '[' && fechado == ']') ||
               (aberto == '{' && fechado == '}');
    }
}
