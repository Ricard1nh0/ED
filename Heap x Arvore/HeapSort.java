import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] readArrayFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] numberStrings = line.split(",");
            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i].trim());
            }
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    public static void main(String args[]) {
        String filename = "dados500_mil.txt";
        
        int arr[] = readArrayFromFile(filename);

        if (arr.length == 0) {
            System.out.println("O arquivo está vazio ou houve um erro ao ler o arquivo.");
            return;
        }

        long inicio = System.currentTimeMillis();

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        long fim = System.currentTimeMillis();

        System.out.println("Array ordenado é");
        printArray(arr);

        long tempoTotal = fim - inicio;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String tempoFormatado = sdf.format(new Date(tempoTotal));

        System.out.println("Tempo de execução: " + tempoFormatado);
    }
}
