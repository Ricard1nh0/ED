import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AVLTree arvore = new AVLTree();
        Random random = new Random();

        // Inserindo 100 números aleatórios na árvore AVL
        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(1001) - 500; // Números de -500 a 500
            arvore.inserir(numero);
        }

        // Verificando o fator de balanceamento de cada nó após as inserções
        System.out.println("Árvore após inserções:");
        arvore.imprimirFatoresBalanceamento();

        // Removendo 20 números aleatórios da árvore
        for (int i = 0; i < 20; i++) {
            int numero = random.nextInt(1001) - 500;
            arvore.deletar(numero);
        }

        // Verificando o fator de balanceamento de cada nó após as remoções
        System.out.println("\nÁrvore após remoções:");
        arvore.imprimirFatoresBalanceamento();
    }
}
