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
	private boolean foiVisitado = false;
	private Object objeto;

	
	public boolean foiVisitado() {
		return foiVisitado;
	}

	public void setFoiVisitado(boolean foiVisitado) {
		this.foiVisitado = foiVisitado;
	}
	
	/*___________________________________________________________________________________________*/
	/**
	 * Construtor da classe.	
	 * @param Object - Objeto do vértice.
	 */
	public Vertice(Object objeto){
		this.setObjeto(objeto);
		grau = 0;
		//listaArestas = new ArrayList<Aresta>();
	}

	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o grau do vértice.
	 * @return int - Grau do vértice.
	 */
	public int getGrau() {
		return grau;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o grau do vértice.
	 * @param int - Novo grau do vértice.
	 */
	public void setGrau(int grau) {
		this.grau = grau;
	}
	
	/*___________________________________________________________________________________________*/

	/**
	 * Retorna o objeto do vértice.
	 * @return Object - Objeto do vértice.
	 */
	public Object getObjeto() {
		return objeto;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o objeto do vértice.
	 * @param Object - Novo objeto do vértice.
	 */
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	/*___________________________________________________________________________________________*/
}
