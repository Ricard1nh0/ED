import java.util.Scanner;

public class Atv485 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[6];
        String[] caracteres = new String[6];

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o caractere " + (i + 1) + ": ");
            caracteres[i] = scanner.next();
        }

        System.out.println();
        multiplicarVetor(numeros, caracteres, 6);

        System.out.println();
    }

    public static void multiplicarVetor(int[] vetorNumeros, String[] vetorCaracteres, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            System.out.println();
            for (int w = 0; w < vetorNumeros[i]; w++) {
                System.out.print(vetorCaracteres[i]);
            }
        }
    }
}
