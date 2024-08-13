import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class No {
    int valor;
    No esquerdo, direito;

    public No(int valor) {
        this.valor = valor;
        esquerdo = direito = null;
    }
}

class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerdo = inserirRec(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = inserirRec(raiz.direito, valor);
        }

        return raiz;
    }

    public void percursoEmOrdem(No raiz) {
        if (raiz != null) {
            percursoEmOrdem(raiz.esquerdo);
            System.out.print(raiz.valor + " ");
            percursoEmOrdem(raiz.direito);
        }
    }

    public void balancearArvore() {
        int tamanho = criarVinha();
        criarArvoreBalanceada(tamanho);
    }

    private int criarVinha() {
        No avo = null;
        No pai = raiz;
        int tamanho = 0;

        while (pai != null) {
            No filhoEsquerdo = pai.esquerdo;
            if (filhoEsquerdo != null) {
                No temp = filhoEsquerdo.direito;
                filhoEsquerdo.direito = pai;
                pai.esquerdo = temp;

                if (avo == null) {
                    raiz = filhoEsquerdo;
                } else {
                    avo.direito = filhoEsquerdo;
                }

                pai = filhoEsquerdo;
            } else {
                avo = pai;
                pai = pai.direito;
                tamanho++;
            }
        }
        return tamanho;
    }

    private void criarArvoreBalanceada(int tamanho) {
        int m = maiorPotenciaDe2MenorOuIgualA(tamanho + 1) - 1;
        fazerRotacoes(tamanho - m);

        while (m > 1) {
            m /= 2;
            fazerRotacoes(m);
        }
    }

    private void fazerRotacoes(int contagem) {
        No avo = null;
        No pai = raiz;

        while (contagem > 0) {
            No filho = pai.direito;
            pai.direito = filho.esquerdo;
            filho.esquerdo = pai;

            if (avo == null) {
                raiz = filho;
            } else {
                avo.direito = filho;
            }

            avo = filho;
            pai = filho.direito;
            contagem--;
        }
    }

    private int maiorPotenciaDe2MenorOuIgualA(int n) {
        int x = 1;
        while (x <= n) {
            x = x * 2;
        }
        return x / 2;
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random aleatorio = new Random();
        Set<Integer> numerosUnicos = new HashSet<>();

        while (numerosUnicos.size() < 100) {
            int num = aleatorio.nextInt(101);
            if (numerosUnicos.add(num)) {
                arvore.inserir(num);
            }
        }

        System.out.println("Árvore binária em ordem (antes do balanceamento):");
        arvore.percursoEmOrdem(arvore.raiz);
        System.out.println();

        arvore.balancearArvore();

        System.out.println("Árvore binária em ordem (após o primeiro balanceamento):");
        arvore.percursoEmOrdem(arvore.raiz);
        System.out.println();

        while (numerosUnicos.size() < 120) {
            int num = 101 + aleatorio.nextInt(100);
            if (numerosUnicos.add(num)) {
                arvore.inserir(num);
            }
        }

        System.out.println("Árvore binária em ordem (após a inserção de 20 novos números):");
        arvore.percursoEmOrdem(arvore.raiz);
        System.out.println();

        arvore.balancearArvore();

        System.out.println("Árvore binária em ordem (após o segundo balanceamento):");
        arvore.percursoEmOrdem(arvore.raiz);
    }
}
