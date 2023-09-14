import java.util.Scanner;

public class Atv493 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite numero " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        int ordenacao = verificarOrdem(numeros);

        if (ordenacao == 1) {
            System.out.println("ORDENACAO CRESCENTE");
        } else if (ordenacao == 2) {
            System.out.println("ORDENACAO DECRESCENTE");
        } else {
            System.out.println("NAO ESTA ORDENADO");
        }
    }

    public static int verificarOrdem(int[] vetor) {
        int crescente = 0;
        int decrescente = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] < vetor[i + 1]) {
                crescente++;
            } else if (vetor[i] > vetor[i + 1]) {
                decrescente++;
            }
        }

        if (crescente > 0 && decrescente == 0) {
            return 1; // Ordenação crescente
        } else if (decrescente > 0 && crescente == 0) {
            return 2; // Ordenação decrescente
        } else {
            return 0; // Não está ordenado
        }
    }
}
