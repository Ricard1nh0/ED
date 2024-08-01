import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

class No {
    int chave;
    No esquerda, direita;

    public No(int item) {
        chave = item;
        esquerda = direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }

    void inserir(int chave) {
        raiz = inserirRec(raiz, chave);
    }

    No inserirRec(No raiz, int chave) {
        if (raiz == null) {
            raiz = new No(chave);
            return raiz;
        }

        if (chave < raiz.chave)
            raiz.esquerda = inserirRec(raiz.esquerda, chave);
        else if (chave > raiz.chave)
            raiz.direita = inserirRec(raiz.direita, chave);

        return raiz;
    }

    void imprimirEmOrdem() {
        imprimirEmOrdemRec(raiz);
    }

    void imprimirEmOrdemRec(No raiz) {
        if (raiz != null) {
            imprimirEmOrdemRec(raiz.esquerda);
            System.out.print(raiz.chave + " ");
            imprimirEmOrdemRec(raiz.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        try {
            BufferedReader br = new BufferedReader(new FileReader("dados500_mil.txt"));
            String linha = br.readLine();
            String[] numeros = linha.split(",");

            long inicio = System.currentTimeMillis();

            for (String num : numeros) {
                // Removendo caracteres indesejados
                num = num.replaceAll("[^0-9]", "").trim();
                if (!num.isEmpty()) {
                    arvore.inserir(Integer.parseInt(num));
                }
            }

            long fim = System.currentTimeMillis();

            System.out.println("Números ordenados:");
            arvore.imprimirEmOrdem();
            System.out.println();

            long tempoTotal = fim - inicio;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String tempoFormatado = sdf.format(new Date(tempoTotal));

            System.out.println("Tempo de execução: " + tempoFormatado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
