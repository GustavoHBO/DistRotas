package util;
/**
 * Interface com os m�todos b�sicos de qualquer grafo.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 * @since 16 abr. 2016
 */
public interface IGrafo {	
	
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o n�mero de v�rtices em G.
	 * @return numVertices - N�mero de v�rtices do grafo.
	 */
	public int numVertices();
	/*___________________________________________________________________________________________*/
	
	/**
	 * Retorna o n�mero de arestas em G.
	 * @return numArestas - N�mero de arestas do grafo.
	 */
	public int numArestas();
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna um iterador para os v�rtices em G.
	 * @return iteradorVertices - Iterador de v�rtices do grafo.
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
	 * Retorna o v�rtice inicial em G.
	 * @return verticeInicial - V�rtice inicial do grafo.
	 */
	public Vertice verticeInicio();
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o v�rtice inicio do grafo.
	 * @param v - Novo v�rtice inicio do grafo.
	 */
	public void alteraInicio(Vertice v);
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o grau do v�rtice recebido em G.
	 * @param vet - V�rtice que ser� retornado o grau.
	 * @return grau - Grau do v�rtice recebido do grafo.
	 */
	public int grauVertice(Vertice vet);
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna um iterador para os v�rtices adjacentes a v.
	 * @param v - V�rtice que cont�m os v�rtices adjacentes.
	 * @return iteradorVerticesAdjacentes - Iterador para os v�rtices adjacentes a v.
	 */
	public IIterador verticesAdjacentes(Vertice v);
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna um iterador para as arestas incidentes a v.
	 * @param v - V�rtice que cont�m as arestas incidentes.
	 * @return iteradorArestasIncidentes - Iterador das aresta incidentes em v.
	 */
	public IIterador arestasIncidentes(Vertice v);
	/*___________________________________________________________________________________________*/
	/**
	 * Verifica se os v�rtices v e w s�o adjacentes.
	 * @param v - V�rtice que ser� usado para a verifica��o.
	 * @param w - V�rtice que ser� usado para a verifica��o.
	 * @return true - Caso sejam adjacentes, false - Caso n�o sejam adjacentes.
	 */
	public boolean adjacentes(Vertice v, Vertice w);
	/*___________________________________________________________________________________________*/
	/**
	 * Insere e retorna uma aresta entre os v�rtices v e w, armazenando o objeto o.
	 * @param v - V�rtice que ir� ser adjacente ao novo v�rtice.
	 * @param w - V�rtice que ir� ser adjacente ao novo v�rtice.
	 * @param o - Objeto a ser inserido no novo v�rtice.
	 * @return verticeInserido - V�rtice criado entre os v�rtices v e w.
	 */
	public Vertice inserir(Vertice v, Vertice w, Object o);
	/*___________________________________________________________________________________________*/
	/**
	 * Insere um v�rtice em G.
	 * @param w - V�rtice que ser� adjacente ao que ser� criado.
	 * @param o - Objeto a ser inserido no grafo.
	 * @return v - V�rtice criado.
	 */
	public Vertice inserir(Vertice w, Object o);
	/*___________________________________________________________________________________________*/
}
