import java.util.Scanner;

public class Atv483 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor1 = new int[4];
        int[] vetor2 = new int[4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + (i + 1) + "º número para o primeiro vetor: ");
            vetor1[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + (i + 1) + "º número para o segundo vetor: ");
            vetor2[i] = scanner.nextInt();
        }

        int produtoInterno = calcularProdutoInterno(vetor1, vetor2, 4);

        System.out.println("\nVETOR A\tVETOR B");
        for (int i = 0; i < 4; i++) {
            System.out.println(vetor1[i] + "\t" + vetor2[i]);
        }

        System.out.println("\nProduto interno: " + produtoInterno);
    }

    public static int calcularProdutoInterno(int[] vetor1, int[] vetor2, int quant) {
        int produto = 0;
        for (int i = 0; i < quant; i++) {
            produto += (vetor1[i] * vetor2[i]);
        }
        return produto;
    }
}
