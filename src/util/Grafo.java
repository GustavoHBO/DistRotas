package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grafo{

	private int numVertices;
	private int numArestas;
	private List<Vertice> listaVertices;
	private List<Aresta> listaArestas;

	/**
	 * Construtor, inicializa os atributos da classe.
	 */
	public Grafo(){
		numVertices = 0;
		numArestas = 0;
		listaVertices = new ArrayList<Vertice>();
		listaArestas = new ArrayList<Aresta>();
	}
	public int numVertices() {
		return numVertices;
	}

	public int numArestas() {
		return numArestas;
	}

	public List<Vertice> getVertices(){
		return listaVertices;
	}
	public List<Aresta> getArestas(){
		return listaArestas;
	}

	public int grauVertice(Vertice vet) {
		return vet.getGrau();
	}

	public Vertice inserir(Object o) {
		if(o == null){// Caso o objeto recebido seja nulo.
			return null;
		}
		Vertice vertice = new Vertice(o);
		listaVertices.add(vertice);
		numVertices++;

		return vertice;
	}

	public void inserirAresta(Vertice v, Vertice w, int peso) {
		if(v == null || w == null){
			return;
		}
		Aresta aresta = new Aresta(v, w);
		aresta.setPeso(peso);

		numArestas++;

		listaArestas.add(aresta);

	}
	public void inserirArestaNaoOrientada(Vertice v, Vertice w, int peso) {
		inserirAresta(v , w , peso);
		inserirAresta(w , v , peso);

	}

	public void removerAresta(Aresta a) {
		Aresta aresta = buscarAresta(a.getVertice1(), a.getVertice2());
		if(aresta != null){
			listaArestas.remove(aresta);
		}

	}

	/**
	 * Remove o vértice a partir do objeto do vértice.
	 * @param o - Objeto do vértice a ser removido.
	 * @return vertice - Vértice removido || null - Caso o vértice não seja encontrado.
	 */
	public Vertice removerVertice(Object o){
		Iterator<Aresta> it = listaArestas.iterator();

		Vertice vertice = buscarVertice(o);

		if(vertice == null){
			return null;
		}
		Aresta aresta = null;
		while(it.hasNext()){
			aresta = it.next();
			if(aresta.getVertice1().equals(vertice) || aresta.getVertice2().equals(vertice)){
				listaArestas.remove(aresta);
			}
		}
		listaVertices.remove(vertice);
		return vertice;
	}


	/**
	 * Busca o vértice a partir do objeto armazenado nele.
	 * @param objeto - Objeto do vértice procurado.
	 * @return vertice - Vértice procurado | null - Caso o vértice não seja encontrado.
	 */
	public Vertice buscarVertice(Object objeto){
		Iterator<Vertice> it = listaVertices.iterator();
		Vertice vertice = null;
		while(it.hasNext()){
			vertice = it.next();
			if(vertice.getObjeto().equals(objeto)){
				return vertice;
			}
		}
		return null;
	}

	/**
	 * Busca a aresta a partir dos vértices que determinam o inicio e fim da aresta.
	 * @param vertice1 - Vértice ponto da aresta.
	 * @param vertice2 - Vértice ponto da aresta.
	 * @return aresta - Aresta procurada || null - Caso a aresta não seja encontrada.
	 */
	public Aresta buscarAresta(Vertice vertice1, Vertice vertice2){
		Iterator<Aresta> it = listaArestas.iterator();
		Aresta aresta = null;
		while(it.hasNext()){
			aresta = it.next();
			if(aresta.getVertice1().equals(vertice1) && aresta.getVertice2().equals(vertice2)){
				return aresta;
			}
		}
		return null;
	}

	/**
	 * Retorna uma lista de todas as aresta incidentes no vértice encontrado.
	 * @param nome - Nome do vértice.
	 * @return arestasIncidentes - Todas as arestas incidentes no vértice encontrado.
	 */
	public List<Aresta> arestasIncidentes(String nome){
		List<Aresta> arestasIncidentes = new ArrayList<Aresta>();
		Iterator<Aresta> it = listaArestas.iterator();
		Aresta aresta = null;

		while(it.hasNext()){
			aresta = it.next();
			if(aresta.getVertice1().getObjeto().equals(nome) || aresta.getVertice2().getObjeto().equals(nome)){
				arestasIncidentes.add(aresta);
			}
		}
		if(arestasIncidentes.size() == 0){
			return null;
		}
		return arestasIncidentes;
	}

	/**
	 * Retorna um operador Dijkstra do grafo recebido.
	 * @return dijkstra - Operado dijkstra do grafo.
	 */
	public Dijkstra menorCaminho(){
		return new Dijkstra(this);
	}
}
