package util;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public void executar(Vertice raiz) {
		listaResultados = new ArrayList<List<Vertice>>();
		nosVisitados = new HashSet<Vertice>();
		nosNaoVisitados = new HashSet<Vertice>();
		peso = new HashMap<Vertice, Integer>();
		antecessores = new HashMap<Vertice, ArrayList<Vertice>>();
		peso.put(raiz, 0);
		nosNaoVisitados.add(raiz);
		while (nosNaoVisitados.size() > 0) {
			Vertice no = getVertMenorDistancia(nosNaoVisitados);
			nosVisitados.add(no);
			nosNaoVisitados.remove(no);
			acharDistanciaMinima(no);
		}
	}

	private void acharDistanciaMinima(Vertice no) {
		List<Vertice> nosAdjacentes = getVizinhos(no);
		ArrayList<Vertice> listaAuxiliar;
		for (Vertice target : nosAdjacentes) {
			if (getMenorDistancia(target) > getMenorDistancia(no) + getDistancia(no, target)) {
				peso.put(target, getMenorDistancia(no) + getDistancia(no, target));
				listaAuxiliar = new ArrayList<Vertice>();
				listaAuxiliar.add(no);
				antecessores.put(target, listaAuxiliar);
				nosNaoVisitados.add(target);
			}else if(getMenorDistancia(target) == getMenorDistancia(no) + getDistancia(no, target)){
				antecessores.get(target).add(no);
	      }
		}

	}

	private int getDistancia(Vertice no, Vertice target) {
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& aresta.getVertice2().equals(target)) {
				return aresta.getPeso();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Vertice> getVizinhos(Vertice no) {
		List<Vertice> adjacentes = new ArrayList<Vertice>();
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& !isVisitado(aresta.getVertice2())) {
				adjacentes.add(aresta.getVertice2());
			}
		}
		return adjacentes;
	}

	private Vertice getVertMenorDistancia(Set<Vertice> vertices) {
		Vertice minimum = null;
		for (Vertice vertice : vertices) {
			if (minimum == null) {
				minimum = vertice;
			} else {
				if (getMenorDistancia(vertice) < getMenorDistancia(minimum)) {
					minimum = vertice;
				}
			}
		}
		return minimum;
	}

	private boolean isVisitado(Vertice vertice) {
		return nosVisitados.contains(vertice);
	}

	private int getMenorDistancia(Vertice destination) {
		Integer d = peso.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}


	public List<List<Vertice>> getCaminho(ArrayList<Vertice> aux, Vertice target) {
		if(aux == null){
			aux = new ArrayList<Vertice>();
		}
		ArrayList<Vertice> caminho = new ArrayList<Vertice>(aux);
		Vertice step = target;
		ArrayList<Vertice> stepList;

		if (antecessores.get(step) == null) {
			return null;
		}
		caminho.add(step);
		while (antecessores.get(step) != null) {
			stepList = antecessores.get(step);
			if(stepList.size() > 1){
				for(int i = 1; i < stepList.size(); i++){
					step = stepList.get(i);
					getCaminho(caminho, step);
				}
			}
			step = stepList.get(0);
			caminho.add(step);
		}

		Collections.reverse(caminho);
		listaResultados.add(caminho);
		return listaResultados;
	}

} 
