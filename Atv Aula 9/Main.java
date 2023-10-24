import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a expressão na notação infixa: ");
            String expressaoInfixa = scanner.nextLine();

            Calculadora calculadora = new Calculadora();

            String posfixa = calculadora.paraPosfixa(expressaoInfixa);
            double resultado = calculadora.calcular(posfixa);

            System.out.println("Infixa: " + expressaoInfixa);
            System.out.println("Posfixa: " + posfixa);
            System.out.println("Resultado: " + resultado);
        }
    }
}
