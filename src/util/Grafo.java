package util;

import java.util.ArrayList;
import java.util.Iterator;

public class Grafo{

	private int numVertices;
	private int numArestas;
	private ArrayList<Vertice> listaVertices;
	private ArrayList<Aresta> listaArestas;

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

	public ArrayList<Vertice> getVertices(){
		return listaVertices;
	}
	public ArrayList<Aresta> getArestas(){
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

	/*public void removerVertice(Object o) {
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
	}*/
}
