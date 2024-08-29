import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AVLTree arvoreAVL = new AVLTree();
        RedBlackTree arvoreRubroNegra = new RedBlackTree();
        Random random = new Random();
        String arquivo = "dados100_mil.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            long tempoInicial, tempoFinal;

            linha = br.readLine();
            if (linha != null) {
                String[] numeros = linha.split(",\\s*"); 

                tempoInicial = System.currentTimeMillis();
                for (String numero : numeros) {
                    int valor = Integer.parseInt(numero);
                    arvoreAVL.inserir(valor);
                }
                tempoFinal = System.currentTimeMillis();
                System.out.println("Tempo de inserção na árvore AVL: " + (tempoFinal - tempoInicial) + " ms");

                tempoInicial = System.currentTimeMillis();
                for (String numero : numeros) {
                    int valor = Integer.parseInt(numero);
                    arvoreRubroNegra.inserir(valor);
                }
                tempoFinal = System.currentTimeMillis();
                System.out.println("Tempo de inserção na árvore Rubro-Negra: " + (tempoFinal - tempoInicial) + " ms");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 50000; i++) {
            int numero = random.nextInt(19999) - 9999;
            if (numero % 3 == 0) {
                arvoreAVL.inserir(numero);
                arvoreRubroNegra.inserir(numero);
            } else if (numero % 5 == 0) {
                arvoreAVL.deletar(numero);
            } else {
                int contagemAVL = contarOcorrencias(arvoreAVL, numero);
                int contagemRN = arvoreRubroNegra.contem(numero) ? 1 : 0;
            }
        }

        gerarRelatorioComparacao();
    }

    private static int contarOcorrencias(AVLTree arvore, int chave) {
        return 0; 
    }

    private static void gerarRelatorioComparacao() {
    }
}
