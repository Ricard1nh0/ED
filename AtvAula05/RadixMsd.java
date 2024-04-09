import java.util.Arrays;
import java.time.Duration;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RadixMsd {
    public static void radixSortMSD(int[] array) {
        if (array.length == 0) return;
        int max = Arrays.stream(array).max().getAsInt();
        int exp = 1;
        while (max / exp > 0) {
            countingSort(array, exp);
            exp *= 10;
        }
    }

    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[20]; 
    
        Arrays.fill(count, 0);
    
        for (int i = 0; i < n; i++) {
            count[((array[i] / exp) % 10) + 10]++; 
        }
    
        for (int i = 1; i < 20; i++) { 
            count[i] += count[i - 1];
        }
    
        for (int i = n - 1; i >= 0; i--) {
            output[count[((array[i] / exp) % 10) + 10] - 1] = array[i];
            count[((array[i] / exp) % 10) + 10]--;
        }
    
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        LocalDateTime tempoInicio = LocalDateTime.now();
        
        int[] array = lerNumerosDoArquivo("dados100_mil.txt");
        if (array.length > 0) {
            radixSortMSD(array);
            System.out.println("Array ordenado: " + Arrays.toString(array));
        } else {
            System.out.println("O arquivo está vazio ou não pôde ser lido.");
        }
        
        LocalDateTime tempoFinal = LocalDateTime.now();

        Duration duracao = Duration.between(tempoInicio, tempoFinal);

        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;
        long segundos = duracao.getSeconds() % 60;
        long miliSegundos = duracao.toMillis() % 1000;

        String tempoFormatado = String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, miliSegundos);

        System.out.println("Tempo de Execução: " + tempoFormatado);
    }

    public static int[] lerNumerosDoArquivo(String caminhoArquivo) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] numerosString = linha.split(", ");
                for (String numeroStr : numerosString) {
                    numeros.add(Integer.parseInt(numeroStr.trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numeros.stream().mapToInt(Integer::intValue).toArray();
    }
}
