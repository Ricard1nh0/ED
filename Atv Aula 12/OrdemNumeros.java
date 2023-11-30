import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    public void insertSorted(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null && data > current.next.data) {
                current = current.next;
            }

            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void printListAscending() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printListDescending() {
        Node current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

public class OrdemNumeros {
    public static void main(String[] args) {
        Set<Integer> numerosUnicos = new HashSet<>();

        
        while (numerosUnicos.size() < 1000) {
            Random random = new Random();
            numerosUnicos.add(random.nextInt(19999) - 999);
            //Lembrar de usar o valor (19999)
        }

        int[] vetor = numerosUnicos.stream().mapToInt(Integer::intValue).toArray();

        // Vetor
        System.out.println("Vetor gerado:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        //lista duplamente encadeada e inserir números ordenadamente
        DoublyLinkedList lista = new DoublyLinkedList();
        for (int num : vetor) {
            lista.insertSorted(num);
            System.out.print("Lista => ");
            lista.printListAscending();
        }

        System.out.println("\nLista em ordem crescente:");
        lista.printListAscending();

        System.out.println("\nLista em ordem decrescente:");
        lista.printListDescending();

        removerPrimos(lista);

        System.out.println("\nLista após remover números primos:");
        lista.printListAscending();
    }

    // Tirar Primos
    private static void removerPrimos(DoublyLinkedList lista) {
        Node current = lista.head;
        while (current != null) {
            if (isPrimo(current.data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    lista.head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }

    // Verificar número primo
    private static boolean isPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
