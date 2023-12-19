import java.util.Scanner;
import java.util.Stack;

public class InvertePalavras {

    public static String inverterPalavras(String frase) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            
            if (Character.isLetter(caractere)) {
                pilha.push(caractere);
            } else {
                while (!pilha.isEmpty()) {
                    resultado.append(pilha.pop());
                }
                resultado.append(caractere);
            }
        }
        
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop());
        }
        
        return resultado.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite uma frase:");
            String frase = scanner.nextLine();

            String resultado = inverterPalavras(frase);

            System.out.println("Frase invertida: " + resultado);
        }
    }
}
