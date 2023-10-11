
import java.util.Stack;
import java.util.Scanner;

public class inverterPalavras {

    public static String inverterPalavras(String input) {
        String[] palavras = input.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            Stack<Character> pilha = new Stack<>();
            for (char letra : palavra.toCharArray()) {
                pilha.push(letra);
            }
            StringBuilder palavraInvertida = new StringBuilder();
            while (!pilha.isEmpty()) {
                palavraInvertida.append(pilha.pop());
            }
            resultado.append(palavraInvertida).append(" ");
        }

        return resultado.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String entrada = scanner.nextLine();
        String resultado = inverterPalavras(entrada);
        System.out.println("Frase com palavras invertidas: " + resultado);
        scanner.close();
    }
}


