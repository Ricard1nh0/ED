import java.util.Scanner;

public class Atv490 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palavras = new String[10];

        
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite palavra em letras minusculas " + (i + 1) + ": ");
            palavras[i] = scanner.nextLine();
        }

 
        for (int i = 0; i < 10; i++) {
            String palavraAlterada = trocarCaractere(palavras[i], 'c', '*');
            System.out.println((i + 1) + " - " + palavraAlterada);
            int caracteresRetirados = contarCaractere(palavras[i], 'c');
            System.out.println("Caracteres retirados: " + caracteresRetirados);
        }
    }

    public static String trocarCaractere(String palavra, char caractere, char substituto) {
        char[] vetor = palavra.toCharArray();

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == caractere) {
                vetor[i] = substituto;
            }
        }

        return new String(vetor);
    }

    public static int contarCaractere(String palavra, char caractere) {
        int cont = 0;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == caractere) {
                cont++;
            }
        }

        return cont;
    }
}
