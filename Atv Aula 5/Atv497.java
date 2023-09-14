import java.util.Scanner;

public class Atv497 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];

        for (int L = 0; L < 10; L++) {
            System.out.print("Digite numero " + (L + 1) + ": ");
            num[L] = scanner.nextInt();
        }

        System.out.print("Digite numero de busca: ");
        int n = scanner.nextInt();

        ordena(num, 10);

        int posicao = busca(num, 10, n);

        System.out.println("\nVETOR");
        for (int L = 0; L < 10; L++) {
            System.out.println((L + 1) + " - " + num[L]);
        }

        if (posicao != -1) {
            System.out.println("\nEncontrado na posição no vetor: " + (posicao + 1));
        } else {
            System.out.println("\nNão ENCONTRADO");
        }
    }

    public static int busca(int[] vet, int tam, int chave) {
        int ini = 0;
        int fim = tam - 1;

        while (ini <= fim) {
            int meio = (ini + fim) / 2;

            if (chave == vet[meio]) {
                return meio;
            } else if (chave < vet[meio]) {
                fim = meio - 1;
            } else {
                ini = meio + 1;
            }
        }

        return -1;
    }

    public static void ordena(int[] vet, int tam) {
        for (int L1 = 0; L1 < tam - 1; L1++) {
            for (int c1 = L1 + 1; c1 < tam; c1++) {
                if (vet[L1] > vet[c1]) {
                    int aux = vet[L1];
                    vet[L1] = vet[c1];
                    vet[c1] = aux;
                }
            }
        }
    }
}
