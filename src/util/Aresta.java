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
	 * Retorna o vértice de destino da aresta.
	 * @return Vertice - Vértice de destino
	 */
	public Vertice getVertice2() {
		return vertice2;
	}
	/**
	 * Altera o vértice de destino da aresta.
	 * @param Vertice - Novo vértice de destino da aresta.
	 */
	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}

	/**
	 * Retorna o vértice de origem da aresta.
	 * @return Vertice - Vértice de origem
	 */
	public Vertice getVertice1() {
		return vertice1;
	}
	/**
	 * Altera o vértice de origem da aresta.
	 * @param Vertice - Novo vértice de origem da aresta.
	 */
	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}
	/**
	 * Retorna o valor peso da aresta.
	 * @return int - Peso da aresta.
	 */
	public int getPeso() {
		return peso;
	}
	/**
	 * Altera o valor peso da aresta.
	 * @param int - Novo valor peso da aresta.
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
}
