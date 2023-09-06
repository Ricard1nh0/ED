import java.util.Scanner;

public class Atv360 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int[] ultDia = { 20, 19, 20, 20, 20, 20, 21, 22, 22, 22, 21, 21 };
            String[] signo = new String[12];
            int data, dia, mes;


            for (int i = 0; i < 12; i++) {
                System.out.print("\nDigite o signo: ");
                signo[i] = input.nextLine();

                System.out.print("Digite o último dia do mês " + (i + 1) + ": ");
                ultDia[i] = input.nextInt();
                input.nextLine(); 
            }


            System.out.print("\nDigite a data no formato ddmm ou 9999 para terminar: ");
            data = input.nextInt();

            while (data != 9999) {
                dia = data / 100;
                mes = data % 100;
                mes--;

                if (dia > ultDia[mes]) {
                    mes = (mes + 1) % 12;
                }

                System.out.println("\nSigno: " + signo[mes] + "\n");

                System.out.print("Digite a data no formato ddmm ou 9999 para terminar: ");
                data = input.nextInt();
            }
        }
    }
}

