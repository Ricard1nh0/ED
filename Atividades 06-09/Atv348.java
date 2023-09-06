import java.util.Scanner;

public class Atv348 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int L;
            String[] nomes = new String[5];
            double[] pr1 = new double[5];
            double[] pr2 = new double[5];
            double[] media = new double[5];

            for (L = 0; L <= 4; L++) {
                System.out.print("\nDigite " + (L + 1) + "º nome: ");
                nomes[L] = input.nextLine();

                System.out.print("Digite a 1ª nota: ");
                pr1[L] = input.nextDouble();

                System.out.print("Digite a 2ª nota: ");
                pr2[L] = input.nextDouble();

                media[L] = (pr1[L] + pr2[L]) / 2;
                input.nextLine(); 
            }

            System.out.println("\n\n\n\t\t\t\tRELACAO FINAL\n");
            for (L = 0; L <= 4; L++) {
                System.out.println("\n" + (L + 1) + " - " + nomes[L]);
                System.out.println(pr1[L] + "\t" + pr2[L] + "\t" + media[L]);
            }
        }
    }
}
