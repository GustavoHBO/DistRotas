package util;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* Todo o c�digo est� muito bem entend�vel e n�o necessita de grandes coment�rios,
 * mas por ser o algoritmo de resolu��o do problema, este necessita de alguns coment�rios
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
	 * Gera as menores dist�ncias da raiz para cada outro v�rtice conexo do grafo 
	 * @param Vertice - V�rtice de origem
	 */
	public void executar(Vertice raiz) {
		/* Este m�todo chama o c�lculo do algoritmo a partir do n� "raiz"
		 * */
		listaResultados = new ArrayList<List<Vertice>>(); // armazena todos os caminhos m�nimos
		nosVisitados = new HashSet<Vertice>(); // lista todos os n�s visitados
		nosNaoVisitados = new HashSet<Vertice>();  // lista todos os n�s n�o visitados
		peso = new HashMap<Vertice, Integer>(); //hashmap que relaciona os v�rtices com o peso do caminho at� chegar nele
		antecessores = new HashMap<Vertice, ArrayList<Vertice>>(); // armazena os antecessores dos v�rtices no caminho mais curto
		
		peso.put(raiz, 0); //o peso da raiz para a raiz sempre � 0
		nosNaoVisitados.add(raiz);
		while (nosNaoVisitados.size() > 0) {
			Vertice no = getVertMenorDistancia(nosNaoVisitados);
			nosVisitados.add(no);
			nosNaoVisitados.remove(no);
			acharDistanciaMinima(no);
		}
	}

	/**
	 * Acha a dist�ncia m�nima at� o n�
	 * @param Vertice - Vertice
	 */
	private void acharDistanciaMinima(Vertice no) {
		List<Vertice> nosAdjacentes = getVizinhos(no);//pega todos os vizinhos de no
		ArrayList<Vertice> listaAuxiliar;
		for (Vertice target : nosAdjacentes) {
			if (getMenorDistancia(target) > getMenorDistancia(no) + getDistancia(no, target)) {//condi��o para substituir o peso atual do caminho para um menor peso
				peso.put(target, getMenorDistancia(no) + getDistancia(no, target));
				listaAuxiliar = new ArrayList<Vertice>();
				listaAuxiliar.add(no);
				antecessores.put(target, listaAuxiliar);
				nosNaoVisitados.add(target);
			}else if(getMenorDistancia(target) == getMenorDistancia(no) + getDistancia(no, target)){// Aqui se encontra a compara��o para caminhos m�nimos m�ltiplos
				antecessores.get(target).add(no);
	      }
		}

	}

	/**
	 * M�todo para retorno do peso da aresta entre n�s adjacentes
	 * @param Vertice - N� do grafo
	 * @param Vertice - N� do grafo
	 * @return int - Peso da aresta.
	 */
	private int getDistancia(Vertice no, Vertice no2) {
		//procura em todas as arestas, se existe uma aresta que liga os dois v�rtices
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& aresta.getVertice2().equals(no2)) {
				return aresta.getPeso();
			}
		}
		throw new RuntimeException("N�o deveria acontecer!");
	}

	/**
	 * M�todo que descobre todos os v�rtices adjacentes a certo v�rtice
	 * @param Vertice - V�rtice do grafo
	 * @return List<Vertice> - Lista de v�rtices
	 */
	private List<Vertice> getVizinhos(Vertice no) {
		List<Vertice> adjacentes = new ArrayList<Vertice>();
		//procura em todas as arestas, os v�rtices que tem adjac�ncia com no
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& !isVisitado(aresta.getVertice2())) {
				adjacentes.add(aresta.getVertice2());
			}
		}
		return adjacentes;
	}

	/**
	 * M�todo para c�lculo do v�rtice com a menor dist�ncia
	 * @param Set<Vertice> - Lista de V�rtices
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
	 * Verifica se o n� j� foi visitado
	 * @return Boolean - Se j� foi visitado
	 */
	private boolean isVisitado(Vertice vertice) {
		return nosVisitados.contains(vertice);
	}

	/**
	 * Retorna o valor da menor dist�ncia j� calculada
	 * @param Vertice - V�rtice do grafo
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
	 * M�todo que retorna todos os caminhos m�nimos 
	 * @param Vertice - V�rtice origem
	 * @param ArrayList<Vertice> - Caminho m�nimo at� o v�rtice origem
	 * @return List<List<Vertice>> - Lista de caminhos m�nimos
	 */
	public List<List<Vertice>> getCaminho(ArrayList<Vertice> aux, Vertice vertice) {
		//aux serve para auxiliar com a recurs�o. Representa o caminho m�nimo da raiz at� o �ltimo v�rtice da lista
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
			if(vertAuxList.size() > 1){//condi��o para a recurs�o. Se tiver mais de 1 antecessor, ele cria novo caminho e segue independentemente do outro
				for(int i = 1; i < vertAuxList.size(); i++){
					vertAux = vertAuxList.get(i);
					getCaminho(caminho, vertAux);
				}
			}
			vertAux = vertAuxList.get(0);
			caminho.add(vertAux);
		}

		Collections.reverse(caminho);//os caminhos come�am pelo fim, ent�o � necess�rio reverter o caminho para estar na ordem certa
		listaResultados.add(caminho);
		return listaResultados;
	}

} 
