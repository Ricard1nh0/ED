import java.util.Scanner;

public class Atv351 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int num;
            String[] nomes = new String[5];


            for (int L = 0; L <= 4; L++) {
                System.out.print("\nDigite o nome " + (L + 1) + ": ");
                nomes[L] = input.nextLine();
            }


            System.out.print("\nDigite o número da pessoa (1 a 5): ");
            num = input.nextInt();

            while (num < 1 || num > 5) {
                System.out.println("\nNúmero fora do intervalo (1 a 5). Tente novamente.");
                System.out.print("\nDigite o número da pessoa (1 a 5): ");
                num = input.nextInt();
            }


            System.out.println("\nNome correspondente ao número " + num + ": " + nomes[num - 1]);
        }
    }
}
