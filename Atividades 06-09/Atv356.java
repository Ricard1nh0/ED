import java.util.Scanner;

public class Atv356 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int[] media = new int[15];
            String[] nomes = new String[15];
            String[] sit = new String[15];
            double[] pr1 = new double[15];
            double[] pr2 = new double[15];


            for (int L = 0; L <= 14; L++) {
                System.out.print("\nDigite o nome do aluno " + (L + 1) + ": ");
                nomes[L] = input.nextLine();

                while (nomes[L].length() > 30) {
                    System.out.println("\nNomes com até 30 caracteres. Tente novamente.");
                    System.out.print("\nDigite o nome do aluno " + (L + 1) + ": ");
                    nomes[L] = input.nextLine();
                }

                int t = 30 - nomes[L].length();
                for (int c = 1; c <= t; c++) {
                    nomes[L] += " ";
                }

                System.out.print("Digite a 1ª nota: ");
                pr1[L] = input.nextDouble();

                System.out.print("Digite a 2ª nota: ");
                pr2[L] = input.nextDouble();

                media[L] = (int) ((pr1[L] + pr2[L]) / 2 + 0.0001);

                if (media[L] >= 6) {
                    sit[L] = "AP";
                } else {
                    sit[L] = "RP";
                }

                input.nextLine(); 
            }


            System.out.println("\n\n\n\t\t\t\tRELACAO FINAL\n");
            for (int L = 0; L <= 14; L++) {
                System.out.println((L + 1) + "- " + nomes[L] + "\t" + pr1[L] + "\t" + pr2[L] + "\t" + media[L] + "\t" + sit[L]);
            }
        }
    }
}

