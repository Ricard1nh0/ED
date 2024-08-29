class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int chave;
        Node esquerda, direita, pai;
        boolean cor;

        Node(int chave) {
            this.chave = chave;
            cor = RED;
        }
    }

    private Node raiz;

    private void rotacaoEsquerda(Node no) {
        Node direita = no.direita;
        no.direita = direita.esquerda;

        if (direita.esquerda != null)
            direita.esquerda.pai = no;

        direita.pai = no.pai;

        if (no.pai == null)
            raiz = direita;
        else if (no == no.pai.esquerda)
            no.pai.esquerda = direita;
        else
            no.pai.direita = direita;

        direita.esquerda = no;
        no.pai = direita;
    }

    private void rotacaoDireita(Node no) {
        Node esquerda = no.esquerda;
        no.esquerda = esquerda.direita;

        if (esquerda.direita != null)
            esquerda.direita.pai = no;

        esquerda.pai = no.pai;

        if (no.pai == null)
            raiz = esquerda;
        else if (no == no.pai.direita)
            no.pai.direita = esquerda;
        else
            no.pai.esquerda = esquerda;

        esquerda.direita = no;
        no.pai = esquerda;
    }

    private void balancearInsercao(Node no) {
        Node pai, avo;

        while (no != raiz && no.pai != null && no.pai.cor == RED) {
            pai = no.pai;

            if (pai.pai == null) {
                break;
            }

            avo = pai.pai;

            if (pai == avo.esquerda) {
                Node tio = avo.direita;

                if (tio != null && tio.cor == RED) {
                    avo.cor = RED;
                    pai.cor = BLACK;
                    tio.cor = BLACK;
                    no = avo;
                } else {
                    if (no == pai.direita) {
                        no = pai;
                        rotacaoEsquerda(no);
                    }
                    pai.cor = BLACK;
                    avo.cor = RED;
                    rotacaoDireita(avo);
                }
            } else {
                Node tio = avo.esquerda;

                if (tio != null && tio.cor == RED) {
                    avo.cor = RED;
                    pai.cor = BLACK;
                    tio.cor = BLACK;
                    no = avo;
                } else {
                    if (no == pai.esquerda) {
                        no = pai;
                        rotacaoDireita(no);
                    }
                    pai.cor = BLACK;
                    avo.cor = RED;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.cor = BLACK;
    }

    public void inserir(int chave) {
        Node novoNo = new Node(chave);
        Node pai = null;
        Node atual = raiz;

        while (atual != null) {
            pai = atual;
            if (novoNo.chave < atual.chave)
                atual = atual.esquerda;
            else
                atual = atual.direita;
        }

        novoNo.pai = pai;

        if (pai == null)
            raiz = novoNo;
        else if (novoNo.chave < pai.chave)
            pai.esquerda = novoNo;
        else
            pai.direita = novoNo;

        balancearInsercao(novoNo);
    }


    public boolean contem(int chave) {
        Node atual = raiz;
        while (atual != null) {
            if (chave < atual.chave)
                atual = atual.esquerda;
            else if (chave > atual.chave)
                atual = atual.direita;
            else
                return true;
        }
        return false;
    }
}
