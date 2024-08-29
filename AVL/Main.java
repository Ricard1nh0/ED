import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AVLTree arvore = new AVLTree();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(1001) - 500; // Números de -500 a 500
            arvore.inserir(numero);
        }

        System.out.println("Árvore após inserções:");
        arvore.imprimirFatoresBalanceamento();

        for (int i = 0; i < 20; i++) {
            int numero = random.nextInt(1001) - 500;
            arvore.deletar(numero);
        }

        System.out.println("\nÁrvore após remoções:");
        arvore.imprimirFatoresBalanceamento();
    }
}
