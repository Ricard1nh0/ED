import java.util.Scanner;

public class Atv346 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase;
        int op;

        do {
            System.out.println("\nMENU");
            System.out.println("1 - Imprime o comprimento da frase");
            System.out.println("2 - Imprime os dois primeiros e os dois últimos caracteres da frase");
            System.out.println("3 - Imprime a frase espelhada");
            System.out.println("4 - Termina o algoritmo");
            System.out.print("OPÇÃO: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Digite uma frase: ");
                    frase = scanner.nextLine();
                    int tam = frase.length();
                    System.out.println("Número de caracteres da frase: " + tam);
                    break;

                case 2:
                    System.out.print("Digite uma frase: ");
                    frase = scanner.nextLine();
                    if (frase.length() >= 4) {
                        System.out.println("Os dois primeiros caracteres: " + frase.substring(0, 2));
                        System.out.println("Os dois últimos caracteres: " + frase.substring(frase.length() - 2));
                    } else {
                        System.out.println("A frase não possui quatro caracteres para mostrar os dois primeiros e dois últimos.");
                    }
                    break;

                case 3:
                    System.out.print("Digite uma frase: ");
                    frase = scanner.nextLine();
                    StringBuilder fraseEspelhada = new StringBuilder(frase).reverse();
                    System.out.println("Frase espelhada: " + fraseEspelhada.toString());
                    break;

                case 4:
                    System.out.println("Fim do algoritmo");
                    break;

                default:
                    System.out.println("Opção não disponível");
                    break;
            }
        } while (op != 4);

        scanner.close();
    }
}
