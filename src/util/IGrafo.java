package util;
/**
 * Interface com os métodos básicos de qualquer grafo.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 * @since 16 abr. 2016
 */
public interface IGrafo {	
	
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o número de vértices em G.
	 * @return numVertices - Número de vértices do grafo.
	 */
	public int numVertices();
	/*___________________________________________________________________________________________*/
	
	/**
	 * Retorna o número de arestas em G.
	 * @return numArestas - Número de arestas do grafo.
	 */
	public int numArestas();
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna um iterador para os vértices em G.
	 * @return iteradorVertices - Iterador de vértices do grafo.
	 */
	public IIterador iteradorVertices();
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna um iterador para as arestas em G.
	 * @return iteradorArestas - Iterador de arestas do grafo.
	 */
	public IIterador iteradorArestas();
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o vértice inicial em G.
	 * @return verticeInicial - Vértice inicial do grafo.
	 */
	public Vertice verticeInicio();
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o vértice inicio do grafo.
	 * @param v - Novo vértice inicio do grafo.
	 */
	public void alteraInicio(Vertice v);
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o grau do vértice recebido em G.
	 * @param vet - Vértice que será retornado o grau.
	 * @return grau - Grau do vértice recebido do grafo.
	 */
	public int grauVertice(Vertice vet);
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna um iterador para os vértices adjacentes a v.
	 * @param v - Vértice que contém os vértices adjacentes.
	 * @return iteradorVerticesAdjacentes - Iterador para os vértices adjacentes a v.
	 */
	public IIterador verticesAdjacentes(Vertice v);
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna um iterador para as arestas incidentes a v.
	 * @param v - Vértice que contém as arestas incidentes.
	 * @return iteradorArestasIncidentes - Iterador das aresta incidentes em v.
	 */
	public IIterador arestasIncidentes(Vertice v);
	/*___________________________________________________________________________________________*/
	/**
	 * Verifica se os vértices v e w são adjacentes.
	 * @param v - Vértice que será usado para a verificação.
	 * @param w - Vértice que será usado para a verificação.
	 * @return true - Caso sejam adjacentes, false - Caso não sejam adjacentes.
	 */
	public boolean adjacentes(Vertice v, Vertice w);
	/*___________________________________________________________________________________________*/
	/**
	 * Insere e retorna uma aresta entre os vértices v e w, armazenando o objeto o.
	 * @param v - Vértice que irá ser adjacente ao novo vértice.
	 * @param w - Vértice que irá ser adjacente ao novo vértice.
	 * @param o - Objeto a ser inserido no novo vértice.
	 * @return verticeInserido - Vértice criado entre os vértices v e w.
	 */
	public Vertice inserir(Vertice v, Vertice w, Object o);
	/*___________________________________________________________________________________________*/
	/**
	 * Insere um vértice em G.
	 * @param w - Vértice que será adjacente ao que será criado.
	 * @param o - Objeto a ser inserido no grafo.
	 * @return v - Vértice criado.
	 */
	public Vertice inserir(Vertice w, Object o);
	/*___________________________________________________________________________________________*/
}
