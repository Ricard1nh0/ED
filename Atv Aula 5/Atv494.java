import java.util.Scanner;

public class Atv494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nome = new String[3];
        String[] ender = new String[3];
        String[] prof = new String[3];

        for (int L = 0; L < 3; L++) {
            System.out.print("Digite nome: ");
            nome[L] = scanner.nextLine();
            System.out.print("Digite endereco: ");
            ender[L] = scanner.nextLine();
            System.out.print("Digite profissao: ");
            prof[L] = scanner.nextLine();
        }

        for (int L = 0; L < 2; L++) {
            for (int c = L + 1; c < 3; c++) {
                if (nome[L].compareTo(nome[c]) > 0) {
                    troca(nome, L, c);
                    troca(ender, L, c);
                    troca(prof, L, c);
                }
            }
        }

        for (int L = 0; L < 3; L++) {
            System.out.println(nome[L] + "\t" + ender[L] + "\t" + prof[L]);
        }
    }

    public static void troca(String[] vetor, int i, int j) {
        String temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
