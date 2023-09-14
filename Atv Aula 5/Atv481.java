import java.util.Scanner;

public class Atv481 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num, base;

        do {
            System.out.print("Digite um número maior ou igual a 0: ");
            num = scanner.nextInt();
        } while (num < 0);

        do {
            System.out.print("Digite a base em que deseja representá-lo (2-10): ");
            base = scanner.nextInt();
        } while (base < 2 || base > 10);

        int resultado = converte(num, base);

        System.out.println("Número em decimal: " + num);
        System.out.println("Número na base " + base + ": " + resultado);
    }

    public static int converte(int nnum, int nbase) {
        int nb = 0;
        int b = 0;

        while (nnum >= nbase) {
            int r = nnum % nbase;
            nb += Math.pow(10, b) * r;
            nnum = nnum / nbase;
            b++;
        }

        nb += Math.pow(10, b) * nnum;
        return nb;
    }
}

