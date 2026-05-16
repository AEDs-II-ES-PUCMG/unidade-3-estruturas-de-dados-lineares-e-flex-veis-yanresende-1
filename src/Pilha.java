import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros
	 *         elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		if (numItens < 0) {
			throw new IllegalArgumentException("A quantidade de itens deve ser maior ou igual a zero.");
		}

		Pilha<E> invertida = new Pilha<E>();
		Pilha<E> resultado = new Pilha<E>();

		Celula<E> atual = topo;
		for (int i = 0; i < numItens; i++) {
			if (atual == fundo) {
				throw new IllegalArgumentException("A pilha não contém a quantidade de itens solicitada.");
			}
			invertida.empilhar(atual.getItem());
			atual = atual.getProximo();
		}

		while (!invertida.vazia()) {
			resultado.empilhar(invertida.desempilhar());
		}

		return resultado;
	}

	public void inverterTopo(int a){
		Pilha<E> invertida = new Pilha<E>();
		Pilha<E> auxiliar = new Pilha<E>();
		if(vazia()){
			throw new IllegalArgumentException("A pilha não contém itens para inverter.");
		}
		for (int i = 0; i < a && !vazia(); i++) {
			invertida.empilhar(this.desempilhar());
			}
		while (!invertida.vazia()) {
			auxiliar.empilhar(invertida.desempilhar());
		}
		while (!auxiliar.vazia()) {
			empilhar(auxiliar.desempilhar());
		}
		
	}
}