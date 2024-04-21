import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bucket {
    private static int comparacoes = 0;
    private static int movimentos = 0;

    public static void main(String[] args) {
        List<Integer> numeros = lerNumerosDoArquivo("dados500_mil.txt");
        long inicioExecucao = System.currentTimeMillis();
        ordenacaoPorBalde(numeros);
        long fimExecucao = System.currentTimeMillis();
        System.out.println("Números ordenados usando Ordenação por Balde:");
        System.out.println(numeros);
        long tempoExecucao = fimExecucao - inicioExecucao;
        System.out.println("Tempo de execução: " + tempoExecucao + " milissegundos");
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Quantidade de movimentações: " + movimentos);
    }

    public static List<Integer> lerNumerosDoArquivo(String nomeArquivo) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.trim().isEmpty()) continue; 
                String[] tokens = linha.split(",\\s+");
                for (String token : tokens) {
                    try {
                        int num = Integer.parseInt(token.trim());
                        numeros.add(num);
                    } catch (NumberFormatException e) {
                        System.err.println("Ignorando token inválido: " + token);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("Números lidos do arquivo:");
        System.out.println(numeros);
    
        return numeros;
    }

    public static void ordenacaoPorBalde(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) return;

        int valorMaximo = Collections.max(arr);
        int valorMinimo = Collections.min(arr);

        int numBaldes = (valorMaximo - valorMinimo) / arr.size() + 1;
        List<List<Integer>> baldes = new ArrayList<>(numBaldes);
        for (int i = 0; i < numBaldes; i++) {
            baldes.add(new ArrayList<>());
        }

        for (int num : arr) {
            int indiceBalde = (num - valorMinimo) / arr.size();
            baldes.get(indiceBalde).add(num);
            movimentos++;
        }

        for (List<Integer> balde : baldes) {
            Collections.sort(balde);
            movimentos += balde.size();
        }

        int indice = 0;
        for (List<Integer> balde : baldes) {
            for (int num : balde) {
                arr.set(indice++, num);
                movimentos++;
            }
        }
    }
}
