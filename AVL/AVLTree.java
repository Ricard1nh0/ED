class AVLTree {
    class Node {
        int chave, altura;
        Node esquerda, direita;

        Node(int d) {
            chave = d;
            altura = 1;
        }
    }

    private Node raiz;

    int altura(Node N) {
        return (N == null) ? 0 : N.altura;
    }

    int obterFatorBalanceamento(Node N) {
        return (N == null) ? 0 : altura(N.esquerda) - altura(N.direita);
    }

    Node rotacaoDireita(Node y) {
        Node x = y.esquerda;
        Node T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    Node rotacaoEsquerda(Node x) {
        Node y = x.direita;
        Node T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    Node inserir(Node no, int chave) {
        if (no == null)
            return new Node(chave);

        if (chave < no.chave)
            no.esquerda = inserir(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = inserir(no.direita, chave);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balanceamento = obterFatorBalanceamento(no);

        if (balanceamento > 1 && chave < no.esquerda.chave)
            return rotacaoDireita(no);
        if (balanceamento < -1 && chave > no.direita.chave)
            return rotacaoEsquerda(no);
        if (balanceamento > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && chave < no.direita.chave) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    Node valorMinimoNo(Node no) {
        Node atual = no;

        while (atual.esquerda != null)
            atual = atual.esquerda;

        return atual;
    }

    Node deletarNo(Node raiz, int chave) {
        if (raiz == null)
            return raiz;

        if (chave < raiz.chave)
            raiz.esquerda = deletarNo(raiz.esquerda, chave);
        else if (chave > raiz.chave)
            raiz.direita = deletarNo(raiz.direita, chave);
        else {
            if ((raiz.esquerda == null) || (raiz.direita == null)) {
                Node temp = null;
                if (temp == raiz.esquerda)
                    temp = raiz.direita;
                else
                    temp = raiz.esquerda;

                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else
                    raiz = temp;
            } else {
                Node temp = valorMinimoNo(raiz.direita);
                raiz.chave = temp.chave;
                raiz.direita = deletarNo(raiz.direita, temp.chave);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura = Math.max(altura(raiz.esquerda), altura(raiz.direita)) + 1;
        int balanceamento = obterFatorBalanceamento(raiz);

        if (balanceamento > 1 && obterFatorBalanceamento(raiz.esquerda) >= 0)
            return rotacaoDireita(raiz);
        if (balanceamento > 1 && obterFatorBalanceamento(raiz.esquerda) < 0) {
            raiz.esquerda = rotacaoEsquerda(raiz.esquerda);
            return rotacaoDireita(raiz);
        }
        if (balanceamento < -1 && obterFatorBalanceamento(raiz.direita) <= 0)
            return rotacaoEsquerda(raiz);
        if (balanceamento < -1 && obterFatorBalanceamento(raiz.direita) > 0) {
            raiz.direita = rotacaoDireita(raiz.direita);
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    void inserir(int chave) {
        raiz = inserir(raiz, chave);
    }

    void deletar(int chave) {
        raiz = deletarNo(raiz, chave);
    }

    void imprimirFatoresBalanceamento(Node no) {
        if (no != null) {
            imprimirFatoresBalanceamento(no.esquerda);
            System.out.println("Nó: " + no.chave + " | Fator de balanceamento: " + obterFatorBalanceamento(no));
            imprimirFatoresBalanceamento(no.direita);
        }
    }

    void imprimirFatoresBalanceamento() {
        imprimirFatoresBalanceamento(raiz);
    }
}
