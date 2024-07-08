import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void printPreOrder() {
        printPreOrderRec(root);
    }

    void printPreOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            printPreOrderRec(root.left);
            printPreOrderRec(root.right);
        }
    }

    void printInOrder() {
        printInOrderRec(root);
    }

    void printInOrderRec(Node root) {
        if (root != null) {
            printInOrderRec(root.left);
            System.out.print(root.key + " ");
            printInOrderRec(root.right);
        }
    }

    void printPostOrder() {
        printPostOrderRec(root);
    }

    void printPostOrderRec(Node root) {
        if (root != null) {
            printPostOrderRec(root.left);
            printPostOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    void printLevelOrder() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

            if (tempNode.left != null)
                queue.add(tempNode.left);

            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Random rand = new Random();
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < 20) {
            numbers.add(rand.nextInt(101));
        }

        for (int num : numbers) {
            tree.insert(num);
        }

        System.out.println("Pre-Ordem:");
        tree.printPreOrder();
        System.out.println("\nIn-Ordem:");
        tree.printInOrder();
        System.out.println("\nPos-Ordem:");
        tree.printPostOrder();
        System.out.println("\nEm-Nivel:");
        tree.printLevelOrder();

        List<Integer> numList = new ArrayList<>(numbers);
        Collections.shuffle(numList);

        for (int i = 0; i < 5; i++) {
            tree.deleteKey(numList.get(i));
        }

        System.out.println("\n\nApós retirar 5 elementos:");

        System.out.println("Pre-Ordem:");
        tree.printPreOrder();
        System.out.println("\nIn-Ordem:");
        tree.printInOrder();
        System.out.println("\nPos-Ordem:");
        tree.printPostOrder();
        System.out.println("\nEm-Nivel:");
        tree.printLevelOrder();
    }
}
