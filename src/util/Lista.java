package util;

public class Lista implements ILista {

	private No primeiro = null; 	// Refer�ncia para o primeiro objeto da lista.
	private No ultimo = null;   	// Refer�ncia para o ultimo objeto da lista.
	private int qNo = 0;		 	// Quantidade de n�'s da lista.

	/**
	 * Construtor padr�o da lista.
	 */
	public Lista(){
		
	}
	
	/**
	 * Verifica se a lista est� vazia, retorna true caso vazia ou false caso n�o.
	 * @return True - Caso vazia, False - Caso n�o esteja vazia.
	 */
	@Override
	public boolean estaVazia() {
		return primeiro == null;// Verifica se o primeiro n� existe.
	}

	/**
	 * Retorna o tamanho da lista
	 * @return qNo - Quantidade de n�'s da lista.
	 */
	@Override
	public int obterTamanho() {
		return qNo;// Retorna o tamanho da lista.
	}

	/**
	 * Insere um objeto no inicio da lista.
	 * @param o - Objeto a ser inserido no n�.
	 */
	@Override
	public void inserirInicio(Object o) {
		No novo = new No(o);// Cria o novo n� e adiciona o objeto.
		if(estaVazia()){// Verifica se a lista est� vazia.
			primeiro = novo;// Caso esteja vazia faz o primeiro e ultimo n� referenciar o novo n�.
			ultimo = primeiro;
		}
		else{//Caso n�o esteja vazia.
			novo.setNext(primeiro);// O novo n� referencia o primeiro.
			primeiro.setAfter(novo);// O primeiro referencia o anterior para o novo n�.
			primeiro = novo;// O primeiro referencia o novo n�.
		}
		qNo++;// Incrementa a quantidade de n�'s da lista.
	}

	/**
	 * Insere um objeto no final da lista.
	 * @param o - Objeto a ser inserido no n�.
	 */
	@Override
	public void inserirFinal(Object o) {

		if(estaVazia()){// Verifica se a lista est� vazia.
			inserirInicio(o);// Caso esteja insere no inicio.
		}
		else{// Caso a lista n�o esteja vazia
			No novo = new No(o);// Cria um n�.
			ultimo.setNext(novo);// Faz o ultimo n� referenciar o novo.
			novo.setAfter(ultimo);// Faz o novo referenciar o ultimo.
			ultimo = novo;// Ultimo referencia o novo.
			qNo++;// Incrementa a quantidade de n�'s.
		}
	}
	/**
	 * Remove um objeto do inicio da lista e retorna-o.
	 * @return null - Caso a lista esteja vazia, objRemover - Retorna o objeto removido.
	 */
	@Override
	public Object removerInicio() {// Remove um n� no inicio da lista.

		if(estaVazia()){// Verifica se esta vazia.
			return null;// Retorna null caso a lista esteja vazia.
		}
		else if(qNo == 1){// Caso exista apenas um n� na lista
			Object objRemover = primeiro.getObjeto();// Recebe o objeto a ser removido.
			primeiro = ultimo = null;// Faz a lista ficar vazia.
			qNo--;
			return objRemover;// Retorna o objeto removido.
		}
		else{// Caso n�o esteja vazia
			Object objRemover = primeiro.getObjeto();// Recebe o objeto a ser removido.
			No remover = primeiro;// Cria um n� para poder retirar a referencia do next e torna-la nulo.
			primeiro = primeiro.getNext();// O primeiro n� referencia o pr�ximo.
			primeiro.setAfter(null);// A referencia anterior do n� � nula, ja que vai ser removido o n� anterior.
			remover.setNext(null);// Retira a referencia do pr�ximo.
			qNo--;// Decrementa a quantidade de n�'s existentes.
			return objRemover;// Retorna o objeto removido.
		}
	}

	/**
	 * Remove um objeto no fim da lista e retorna-o.
	 * @return null - Caso a lista esteja vazia, Remover - Retorna o objeto removido.
	 */
	@Override
	public Object removerFinal() {

		if(estaVazia()){// Verifica se a lista esta vazia.
			return null;// Caso esteja retorna null.
		}
		else if (qNo == 1){// Verifica se existe apenas um n� na lista.
			return removerInicio();// Remove o n� do inicio, para retirar a referencia do primeiro e ultimo.
		}
		else{// Caso exista mais de um n�.
			No remover = ultimo;// Cria um n� para retirar a referencia do next desse n�.
			ultimo = ultimo.getAfter();// Ultimo se torna o anterior a ele.
			ultimo.setNext(null);// Apaga a referencia para o n� a ser removido.
			remover.setAfter(null);// Retira a referencia para o ultimo.
			qNo--;//Decrementa a quantidade de n�'s da lista.
			return remover.getObjeto();// Retorna o objeto removido.
		}
	}

	/**
	 * Remove o objeto na posi��o recebida em rela��o a lista e retorna-o.
	 * @param index - Posi��o a ser removida.
	 * @return null - Caso a lista esteja vazia, Remover - Retorna o objeto removido.
	 */
	@Override
	public Object remover(int index) {// Remove um n� na posi��o indicada.
		if(estaVazia() || index > qNo - 1 || index < 0){// Verifica se a lista est� vazia ou se a posi��o existe.
			return null;// Retorna nulo.
		}
		else if(index == 0){// Verifica se a posi��o a remover � no inicio.
			return removerInicio();// Retorna o objeto removido.
		}
		else if(index == qNo - 1){// Verifica se a posi��o a remover � no final.
			return removerFinal();// Retorna o objeto removido.
		}
		else{// Caso a posi��o exista, a lista n�o esteja vazia e a posi��o n�o seja no inicio nem no fim.
			No remover = primeiro.getNext();// Cria um n� para percorrer a lista e encontrar a posi��o a ser removida.
			No anterior, proximo;// Cria n�'s para trocar as referencias.
			for(int cont = 1; cont != index; cont++){// For para percorrer a lista e encontrar o n� a ser removido.
				remover = remover.getNext();// remover percorre a lista.
			}
			anterior = remover.getAfter();// anterior referencia o n� anterior do n� a ser removido.
			proximo = remover.getNext();// Pr�ximo referencia o pr�ximo n� do n� a ser removido.
			anterior.setNext(proximo);// anterior referencia o pr�ximo.
			proximo.setAfter(anterior);// Pr�ximo referencia o anterior.
			qNo--;//Decrementa a quantidade de n�s.
			return remover.getObjeto();// Retorna o objeto do n� removido.
		}
	}

	/**
	 * Retorna o objeto na posi��o recebida.
	 * @param index - Posi��o na lista.
	 * @return objeto - Objeto encontrado na posi��o.
	 */
	@Override
	public Object recuperar(int index) {
		if(estaVazia() || index < 0 || index > qNo - 1){// Verifica se a lista est� vazia ou se a posi��o existe.
			return null;// Retorna null.
		}
		else{
			No aux = primeiro;// Cria um n� para percorrer a lista.
			for(int cont = 0; cont != index; cont++){// Percorre a lista.
				aux = aux.getNext();
			}
			return aux.getObjeto();// Retorna o objeto na posi��o recebida.
		}
	}

	/**
	 * Retorna o iterador da lista.
	 * @return iterador - Iterador da lista.
	 */
	@Override
	public Iterador iterador() {// Cria um iterador da lista
		Iterador iterador = new Iterador(primeiro);// Cria um iterador passando o inicio da lista.
		return iterador;// Retorna o iterador criado.
	}
}
