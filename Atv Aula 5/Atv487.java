import java.util.Scanner;

public class Atv487 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        inverter(numeros, 10);

        System.out.println("\nVETOR");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + " - " + numeros[i]);
        }
        System.out.println();
    }

    public static void inverter(int[] vetor, int max) {
        int k = max;
        for (int i = 0; i < max / 2; i++) {
            int aux = vetor[i];
            k--;
            vetor[i] = vetor[k];
            vetor[k] = aux;
        }
    }
}
