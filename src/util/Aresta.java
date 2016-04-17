package util;

public class Aresta {

	private Vertice vertice1 = null;
	private Vertice vertice2 = null;
	private int peso = 0;
	
	public Aresta(Vertice vertice1, Vertice vertice2){
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}
	/**
	 * Retorna o vertice2 da aresta.
	 * @return vertice2 - Vértice 2 da aresta.
	 */
	public Vertice getVertice2() {
		return vertice2;
	}
	/**
	 * Altera o vertice2 da aresta.
	 * @param vertice2 - Novo vértice 2 da aresta.
	 */
	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}
	/**
	 * Retorna o vertice1 da aresta.
	 * @return vertice1 - Vértice 1 da aresta.
	 */
	public Vertice getVertice1() {
		return vertice1;
	}
	/**
	 * Altera o vertice1 da aresta.
	 * @param vertice1 - Novo vértice 1 da aresta.
	 */
	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}
	/**
	 * Retorna o valor peso da aresta.
	 * @return peso - Peso da aresta.
	 */
	public int getPeso() {
		return peso;
	}
	/**
	 * Altera o valor peso da aresta.
	 * @param peso - Novo valor peso da aresta.
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
}
