/*******************************************************************************
Autor: Gustavo Henrique.
Componente Curricular: MI - Programa��o.
Conclu�do em: 26/12/2016
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/
package util;

/**
 * Classe No - Define os n�'s da lista duplamente encadeada.
 * @author Gustavo Henrique.
 * @since 26 de Dezembro de 2015.
 */
public class No {

	private Object objeto = null; 	// Objeto do n�.
	private No next = null;			//Pr�ximo n� da lista. 
	private No after = null;		//Anterior n� da lista.
	
	/**
	 * Construtor - Cria um n� com o objeto recebido.
	 * @param objeto - Objeto a ser inserido no n�.
	 */
	public No(Object objeto){// Cria um n� com o objeto recebido.
		this.setObjeto(objeto);
	}

	/**
	 * Retorna o objeto do n�.
	 * @return objeto - Objeto do n�.
	 */
	public Object getObjeto() {
		return objeto;
	}

	/**
	 * Altera o objeto do n�.
	 * @param objeto - Objeto a ser inserido no n�;
	 */
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	/**
	 * Retorna a referencia para o pr�ximo n�.
	 * @return next - Referencia para o pr�ximo n�.
	 */
	public No getNext() {
		return next;
	}

	/**
	 * Altera a referencia para o pr�ximo n�.
	 * @param next - Referencia para o novo n�.
	 */
	public void setNext(No next) {
		this.next = next;
	}

	/**
	 * Retorna a referencia para o n� anterior.
	 * @return after - Referencia para o n� anterior.
	 */
	public No getAfter() {
		return after;
	}

	/**
	 * Altera a referencia para o n� anterior.
	 * @param after - Referencia para o novo n�.
	 */
	public void setAfter(No after) {
		this.after = after;
	}
}
