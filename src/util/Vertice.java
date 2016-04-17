package util;
/**
 * Classe Vértice do Grafo.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 * @since 16 abr. 2016.
 *
 */

public class Vertice {

	private int grau;
	private Lista listaArestas;
	private Object objeto;

	/*___________________________________________________________________________________________*/
	/**
	 * Construtor da classe.	
	 * @param objeto - Objeto do vértice.
	 */
	public Vertice(Object objeto){
		this.setObjeto(objeto);
		grau = 0;
		setListaArestas(new Lista());
	}

	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o grau do vértice.
	 * @return grau - Grau do vértice.
	 */
	public int getGrau() {
		return grau;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o grau do vértice.
	 * @param grau - Novo grau do vértice.
	 */
	public void setGrau(int grau) {
		this.grau = grau;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna a lista de arestas do vértice.
	 * @return listaArestas - Lista de arestas do vértice.
	 */
	public Lista getListaArestas() {
		return listaArestas;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera a lista de arestas do vértice.
	 * @param listaArestas - Nova lista de arestas do vértice.
	 */
	public void setListaArestas(Lista listaArestas) {
		this.listaArestas = listaArestas;
	}
	/*___________________________________________________________________________________________*/

	/**
	 * Retorna o objeto do vértice.
	 * @return objeto - Objeto do vértice.
	 */
	public Object getObjeto() {
		return objeto;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o objeto do vértice.
	 * @param objeto - Novo objeto do vértice.
	 */
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	/*___________________________________________________________________________________________*/
}
