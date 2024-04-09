import java.util.Arrays;
import java.time.Duration;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array.length <= 1) return;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] array) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[mergedIndex++] = left[leftIndex++];
            } else {
                array[mergedIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            array[mergedIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            array[mergedIndex++] = right[rightIndex++];
        }
    }

    public static void main(String[] args) {
        LocalDateTime tempoInicio = LocalDateTime.now();
        
        int[] array = lerNumerosDoArquivo("dados100_mil.txt");
        if (array.length > 0) {
            mergeSort(array);
            System.out.println(Arrays.toString(array));
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
            String linha = br.readLine();
            String[] numerosString = linha.split(", ");
            for (String numeroStr : numerosString) {
                numeros.add(Integer.parseInt(numeroStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numeros.stream().mapToInt(Integer::intValue).toArray();
    }
}
