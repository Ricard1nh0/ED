import java.util.Scanner;

public class TorresDeHanoi {

    public static long resolverHanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            return 1;
        }
        long movimentos = resolverHanoi(n - 1, origem, auxiliar, destino);
        movimentos++;
        movimentos += resolverHanoi(n - 1, auxiliar, destino, origem);
        return movimentos;
    }

    public static String formatarTempo(long milissegundos) {
        long segundos = milissegundos / 1000;
        long minutos = segundos / 60;
        long horas = minutos / 60;
        long milissegundosRestantes = milissegundos % 1000;
        segundos %= 60;
        minutos %= 60;
        horas %= 24;
        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundosRestantes);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o número de discos: ");
            int numDiscos = scanner.nextInt();

            long tempoInicial = System.currentTimeMillis();
            long movimentos = resolverHanoi(numDiscos, 'A', 'C', 'B');
            long tempoFinal = System.currentTimeMillis();

            long tempoGasto = tempoFinal - tempoInicial;
            String tempoFormatado = formatarTempo(tempoGasto);

            System.out.println("Número de movimentos: " + movimentos);
            System.out.println("Tempo gasto: " + tempoFormatado);
        }
    }
}








