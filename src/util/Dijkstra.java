package util;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* Todo o código está muito bem entendível e não necessita de grandes comentários,
 * mas por ser o algoritmo de resolução do problema, este necessita de alguns comentários
 * */
public class Dijkstra {

	private final List<Aresta> arestas;
	private List<List<Vertice>> listaResultados;
	private Set<Vertice> nosVisitados;
	private Set<Vertice> nosNaoVisitados;
	private Map<Vertice, ArrayList<Vertice>> antecessores;
	private Map<Vertice, Integer> peso;

	public Dijkstra(Grafo grafo) {
		this.arestas = new ArrayList<Aresta>(grafo.getArestas());
	}
	
	/**
	 * Gera as menores distâncias da raiz para cada outro vértice conexo do grafo 
	 * @param Vertice - Vértice de origem
	 */
	public void executar(Vertice raiz) {
		/* Este método chama o cálculo do algoritmo a partir do nó "raiz"
		 * */
		listaResultados = new ArrayList<List<Vertice>>(); // armazena todos os caminhos mínimos
		nosVisitados = new HashSet<Vertice>(); // lista todos os nós visitados
		nosNaoVisitados = new HashSet<Vertice>();  // lista todos os nós não visitados
		peso = new HashMap<Vertice, Integer>(); //hashmap que relaciona os vértices com o peso do caminho até chegar nele
		antecessores = new HashMap<Vertice, ArrayList<Vertice>>(); // armazena os antecessores dos vértices no caminho mais curto
		
		peso.put(raiz, 0); //o peso da raiz para a raiz sempre é 0
		nosNaoVisitados.add(raiz);
		while (nosNaoVisitados.size() > 0) {
			Vertice no = getVertMenorDistancia(nosNaoVisitados);
			nosVisitados.add(no);
			nosNaoVisitados.remove(no);
			acharDistanciaMinima(no);
		}
	}

	/**
	 * Acha a distância mínima até o nó
	 * @param Vertice - Vertice
	 */
	private void acharDistanciaMinima(Vertice no) {
		List<Vertice> nosAdjacentes = getVizinhos(no);//pega todos os vizinhos de no
		ArrayList<Vertice> listaAuxiliar;
		for (Vertice target : nosAdjacentes) {
			if (getMenorDistancia(target) > getMenorDistancia(no) + getDistancia(no, target)) {//condição para substituir o peso atual do caminho para um menor peso
				peso.put(target, getMenorDistancia(no) + getDistancia(no, target));
				listaAuxiliar = new ArrayList<Vertice>();
				listaAuxiliar.add(no);
				antecessores.put(target, listaAuxiliar);
				nosNaoVisitados.add(target);
			}else if(getMenorDistancia(target) == getMenorDistancia(no) + getDistancia(no, target)){// Aqui se encontra a comparação para caminhos mínimos múltiplos
				antecessores.get(target).add(no);
	      }
		}

	}

	/**
	 * Método para retorno do peso da aresta entre nós adjacentes
	 * @param Vertice - Nó do grafo
	 * @param Vertice - Nó do grafo
	 * @return int - Peso da aresta.
	 */
	private int getDistancia(Vertice no, Vertice no2) {
		//procura em todas as arestas, se existe uma aresta que liga os dois vértices
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& aresta.getVertice2().equals(no2)) {
				return aresta.getPeso();
			}
		}
		throw new RuntimeException("Não deveria acontecer!");
	}

	/**
	 * Método que descobre todos os vértices adjacentes a certo vértice
	 * @param Vertice - Vértice do grafo
	 * @return List<Vertice> - Lista de vértices
	 */
	private List<Vertice> getVizinhos(Vertice no) {
		List<Vertice> adjacentes = new ArrayList<Vertice>();
		//procura em todas as arestas, os vértices que tem adjacência com no
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& !isVisitado(aresta.getVertice2())) {
				adjacentes.add(aresta.getVertice2());
			}
		}
		return adjacentes;
	}

	/**
	 * Método para cálculo do vértice com a menor distância
	 * @param Set<Vertice> - Lista de Vértices
	 * @return Vertice - Peso da aresta.
	 */
	private Vertice getVertMenorDistancia(Set<Vertice> vertices) {
		Vertice minimo = null;
		for (Vertice vertice : vertices) {
			if (minimo == null) {
				minimo = vertice;
			} else {
				if (getMenorDistancia(vertice) < getMenorDistancia(minimo)) {
					minimo = vertice;
				}
			}
		}
		return minimo;
	}
	
	/**
	 * Verifica se o nó já foi visitado
	 * @return Boolean - Se já foi visitado
	 */
	private boolean isVisitado(Vertice vertice) {
		return nosVisitados.contains(vertice);
	}

	/**
	 * Retorna o valor da menor distância já calculada
	 * @param Vertice - Vértice do grafo
	 * @return int - Peso da aresta.
	 */
	private int getMenorDistancia(Vertice vertice) {
		Integer d = peso.get(vertice);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}


	/**
	 * Método que retorna todos os caminhos mínimos 
	 * @param Vertice - Vértice origem
	 * @param ArrayList<Vertice> - Caminho mínimo até o vértice origem
	 * @return List<List<Vertice>> - Lista de caminhos mínimos
	 */
	public List<List<Vertice>> getCaminho(ArrayList<Vertice> aux, Vertice vertice) {
		//aux serve para auxiliar com a recursão. Representa o caminho mínimo da raiz até o último vértice da lista
		if(aux == null){
			aux = new ArrayList<Vertice>();
		}
		ArrayList<Vertice> caminho = new ArrayList<Vertice>(aux);
		Vertice vertAux = vertice;
		ArrayList<Vertice> vertAuxList;

		if (antecessores.get(vertAux) == null) {
			return null;
		}
		caminho.add(vertAux);
		while (antecessores.get(vertAux) != null) {
			vertAuxList = antecessores.get(vertAux);
			if(vertAuxList.size() > 1){//condição para a recursão. Se tiver mais de 1 antecessor, ele cria novo caminho e segue independentemente do outro
				for(int i = 1; i < vertAuxList.size(); i++){
					vertAux = vertAuxList.get(i);
					getCaminho(caminho, vertAux);
				}
			}
			vertAux = vertAuxList.get(0);
			caminho.add(vertAux);
		}

		Collections.reverse(caminho);//os caminhos começam pelo fim, então é necessário reverter o caminho para estar na ordem certa
		listaResultados.add(caminho);
		return listaResultados;
	}

} 
