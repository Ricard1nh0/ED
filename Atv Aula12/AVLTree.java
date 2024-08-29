class AVLTree {
    class No {
        int chave;
        No esquerda, direita;
        int altura;

        No(int chave) {
            this.chave = chave;
            altura = 1;
        }
    }

    private No raiz;

    private int altura(No no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    private int fatorDeBalanceamento(No no) {
        if (no == null)
            return 0;
        return altura(no.esquerda) - altura(no.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public No inserir(No no, int chave) {
        if (no == null)
            return new No(chave);

        if (chave < no.chave)
            no.esquerda = inserir(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = inserir(no.direita, chave);
        else
            return no; 

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = fatorDeBalanceamento(no);

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

    public void inserir(int chave) {
        raiz = inserir(raiz, chave);
    }

    private No menorValorNo(No no) {
        No atual = no;
        while (atual.esquerda != null)
            atual = atual.esquerda;

        return atual;
    }

    public No deletar(No raiz, int chave) {
        if (raiz == null)
            return raiz;

        if (chave < raiz.chave)
            raiz.esquerda = deletar(raiz.esquerda, chave);
        else if (chave > raiz.chave)
            raiz.direita = deletar(raiz.direita, chave);
        else {
            if ((raiz.esquerda == null) || (raiz.direita == null)) {
                No temp = raiz.esquerda != null ? raiz.esquerda : raiz.direita;

                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else 
                    raiz = temp;
            } else {
                No temp = menorValorNo(raiz.direita);

                raiz.chave = temp.chave;

                raiz.direita = deletar(raiz.direita, temp.chave);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura = Math.max(altura(raiz.esquerda), altura(raiz.direita)) + 1;

        int balanceamento = fatorDeBalanceamento(raiz);

        if (balanceamento > 1 && fatorDeBalanceamento(raiz.esquerda) >= 0)
            return rotacaoDireita(raiz);

        if (balanceamento > 1 && fatorDeBalanceamento(raiz.esquerda) < 0) {
            raiz.esquerda = rotacaoEsquerda(raiz.esquerda);
            return rotacaoDireita(raiz);
        }

        if (balanceamento < -1 && fatorDeBalanceamento(raiz.direita) <= 0)
            return rotacaoEsquerda(raiz);

        if (balanceamento < -1 && fatorDeBalanceamento(raiz.direita) > 0) {
            raiz.direita = rotacaoDireita(raiz.direita);
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    public void deletar(int chave) {
        raiz = deletar(raiz, chave);
    }

    public boolean contem(int chave) {
        return contem(raiz, chave);
    }

    private boolean contem(No no, int chave) {
        if (no == null) {
            return false;
        } else if (chave < no.chave) {
            return contem(no.esquerda, chave);
        } else if (chave > no.chave) {
            return contem(no.direita, chave);
        } else {
            return true;
        }
    }

    public void imprimirFatoresDeBalanceamento() {
        imprimirFatoresDeBalanceamento(raiz);
    }

    private void imprimirFatoresDeBalanceamento(No no) {
        if (no != null) {
            imprimirFatoresDeBalanceamento(no.esquerda);
            System.out.println("Nó: " + no.chave + ", Fator de Balanceamento: " + fatorDeBalanceamento(no));
            imprimirFatoresDeBalanceamento(no.direita);
        }
    }
}
