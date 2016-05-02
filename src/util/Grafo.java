package util;

import java.util.ArrayList;
import java.util.Iterator;

public class Grafo implements IGrafo{

	private Vertice inicio;
	private int numVertices;
	private int numArestas;
	private ArrayList<Vertice> listaVertices;
	private ArrayList<Aresta> listaArestas;

	/**
	 * Construtor, inicializa os atributos da classe.
	 */
	public Grafo(){
		inicio = null;
		numVertices = 0;
		numArestas = 0;
		listaVertices = new ArrayList<Vertice>();
		listaArestas = new ArrayList<Aresta>();
	}
	@Override
	public int numVertices() {
		return numVertices;
	}

	@Override
	public int numArestas() {
		return numArestas;
	}

	@Override
	public Iterator<Vertice> iteradorVertices() {
		return listaVertices.iterator();
	}

	@Override
	public Iterator<Aresta> iteradorArestas() {
		return listaArestas.iterator();
	}

	@Override
	public Vertice verticeInicio() {
		return inicio;
	}

	@Override
	public void alteraInicio(Vertice inicio){
		this.inicio = inicio;
	}

	@Override
	public int grauVertice(Vertice vet) {
		return vet.getGrau();
	}

	@Override
	public Iterator<Vertice> verticesAdjacentes(Vertice v) {
		ArrayList<Vertice> listaVerticesAdjacentes = new ArrayList<Vertice>();// Lista de vertices que são adjacentes a v.
		Iterator<Aresta> itArestas = arestasIncidentes(v);// Iterador de arestas incidente em v;
		Aresta aresta;
		while(itArestas.hasNext()){
			aresta = (Aresta)itArestas.next();
			if(aresta.getVertice1() == v ){//Caso exista um loop(no caso de existir uma aresta que saia de v e acabe em v) entrará aqui.
				listaVerticesAdjacentes.add(aresta.getVertice2());
			}
			else if(aresta.getVertice2() == v){
				listaVerticesAdjacentes.add(aresta.getVertice1());
			}
		}
		return listaVerticesAdjacentes.iterator();
	}

	@Override
	public Iterator<Aresta> arestasIncidentes(Vertice v) {
		if(v == null){
			return null;
		}
		ArrayList<Aresta> listaArestaIncidente = new ArrayList<Aresta>();

		Iterator<Aresta> it = listaArestas.iterator();
		Aresta aresta = null;
		while(it.hasNext()){
			aresta = it.next();
			if(aresta.getVertice1().equals(v) || aresta.getVertice2().equals(v)){
				listaArestaIncidente.add(aresta);
			}
		}
		return listaArestaIncidente.iterator();
	}

	@Override
	public boolean adjacentes(Vertice v, Vertice w) {
		if(v == null || w == null){// Caso os vértices recebidos sejam nulos.
			return false;
		}

		Iterator<Aresta> itArestas = arestasIncidentes(v);// Iterador de arestas incidentes em v.
		Aresta aresta = null;
		while(itArestas.hasNext()){
			aresta = itArestas.next();
			if(aresta.getVertice1() == w || aresta.getVertice2() == w){// Verifica se a aresta incide em w.
				return true;
			}
		}
		return false;
	}

	@Override
	public Vertice inserir(Vertice v, Vertice w, Object o) {

		if(v == null || w == null || o == null){// Caso os vértices e o objeto recebidos sejam nulos.
			return null;
		}
		Vertice novo = new Vertice(o);
		Aresta aresta1 = new Aresta(v, novo);
		v.setGrau(v.getGrau() + 1);
		Aresta aresta2 = new Aresta(novo, w);
		w.setGrau(w.getGrau() + 1);
		novo.setGrau(2);

		listaVertices.add(novo);
		listaArestas.add(aresta1);
		listaArestas.add(aresta2);

		numArestas += 2;
		numVertices++;
		return novo;
	}

	@Override
	public Vertice inserir(Vertice w, Object o) {
		if(w == null || o == null){// Caso o vértice e o objeto recebidos sejam nulos.
			return null;
		}
		Vertice novo = new Vertice(o);
		Aresta aresta = new Aresta(w, novo);
		w.setGrau(w.getGrau() + 1);
		novo.setGrau(1);

		listaVertices.add(novo);
		listaArestas.add(aresta);

		numArestas++;
		numVertices++;

		return novo;
	}
	@Override
	public Vertice inserir(Object o) {
		if(o == null){// Caso o objeto recebido seja nulo.
			return null;
		}
		Vertice vertice = new Vertice(o);
		listaVertices.add(vertice);
		numVertices++;

		if(inicio == null)
			inicio = vertice;
		return vertice;
	}
	@Override
	public void inserirAresta(Vertice v, Vertice w, int peso) {
		if(v == null || w == null){
			return;
		}
		Aresta aresta = new Aresta(v, w);
		aresta.setPeso(peso);

		v.setGrau(v.getGrau() + 1);
		w.setGrau(w.getGrau() + 1);
		numArestas++;

		listaArestas.add(aresta);

	}
	@Override
	public void removerAresta(Aresta a) {
		Iterator<Aresta> iterador = listaArestas.iterator();
		Aresta aresta;

		while(iterador.hasNext()){// Procura a aresta a ser removida.
			aresta = iterador.next();
			if(aresta.equals(a)){// Caso a aresta exista ela é removida.
				listaArestas.remove(a);
				numArestas--;
			}
		}
	}
	@Override
	public void removerVertice(Object o) {
		Iterator<Vertice> it = listaVertices.iterator();
		Iterator<Aresta> itArestas = listaArestas.iterator();
		Vertice vertice = null, aux = null;
		Aresta aresta = null;

		while(it.hasNext()){
			vertice = it.next();
			if(vertice.getObjeto().equals(o)){
				while(itArestas.hasNext()){
					aresta = itArestas.next();
					if (aresta.getVertice1().equals(vertice)){
						listaArestas.remove(aresta);
						aux = aresta.getVertice2();
						aux.setGrau(aux.getGrau() - 1);

					} else if (aresta.getVertice2().equals(vertice)){
						listaArestas.remove(aresta);
						aux = aresta.getVertice1();
						aux.setGrau(aux.getGrau() - 1);
					}
				}
				listaVertices.remove(vertice);
				numVertices--;
				if(vertice == inicio){
					if(listaVertices.size() >= 1){
						inicio = listaVertices.get(0);
					}else
						inicio = null;
				}
				return;
			}
		}
	}
}
