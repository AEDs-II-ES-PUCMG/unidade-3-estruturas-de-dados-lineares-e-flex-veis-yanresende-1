import java.util.NoSuchElementException;

public class Fila<E> {

    private Celula<E> frente;
    private Celula<E> tras;
    private int tamanho;

    public Fila() {
        Celula<E> sentinela = new Celula<E>();
        frente = sentinela;
        tras = sentinela;
        tamanho = 0;
    }

    public boolean vazia() {
        return frente == tras;
    }

    public int tamanho() {
        return tamanho;
    }

    public void enfileirar(E item) {
        Celula<E> novaCelula = new Celula<E>(item);
        tras.setProximo(novaCelula);
        tras = novaCelula;
        tamanho++;
    }

    public E desenfileirar() {
        E primeiro = consultarPrimeiro();
        Celula<E> removida = frente.getProximo();
        frente.setProximo(removida.getProximo());
        if (removida == tras) {
            tras = frente;
        }
        tamanho--;
        return primeiro;
    }

    public E consultarPrimeiro() {
        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na fila!");
        }
        return frente.getProximo().getItem();
    }

    public int contarOcorrencias(E itemBusca) {
        int contador = 0;
        Celula<E> atual = frente.getProximo();
        while (atual != null) {
            if (atual.getItem() != null && atual.getItem().equals(itemBusca)) {
                contador++;
            } else if (atual.getItem() == null && itemBusca == null) {
                contador++;
            }
            atual = atual.getProximo();
        }
        return contador;
    }

    public Fila<E> extrairLote(int numItens) {
        Fila<E> lote = new Fila<>();
        for (int i = 0; i < numItens && !this.vazia(); i++) {
            lote.enfileirar(this.desenfileirar());
        }
        return lote;
    }
}
