import java.util.Scanner;

public class Atv495 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] nome = new String[5][20];

        for (int L = 0; L < 5; L++) {
            System.out.print("Digite nome " + (L + 1) + ": ");
            nome[L][0] = scanner.nextLine();
        }

        ordena(nome, 5);

        System.out.println("\nNOMES ORDENADOS");
        for (int L = 0; L < 5; L++) {
            System.out.println((L + 1) + " - " + nome[L][0]);
        }
    }

    public static void ordena(String[][] vetor, int tam) {
        String aux;

        for (int Li = 0; Li < tam - 1; Li++) {
            for (int ci = Li + 1; ci < tam; ci++) {
                if (vetor[Li][0].compareTo(vetor[ci][0]) > 0) {
                    aux = vetor[Li][0];
                    vetor[Li][0] = vetor[ci][0];
                    vetor[ci][0] = aux;
                }
            }
        }
    }
}
