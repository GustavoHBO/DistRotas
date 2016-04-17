package util;

public class Grafo implements IGrafo{

	private Vertice inicio;
	private int numVertices;
	private int numArestas;
	private Lista listaVertices;
	private Lista listaArestas;
	
	/**
	 * Construtor, inicializa os atributos da classe.
	 */
	public Grafo(){
		inicio = null;
		numVertices = 0;
		numArestas = 0;
		listaVertices = new Lista();
		listaArestas = new Lista();
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
	public IIterador iteradorVertices() {
		return listaVertices.iterador();
	}

	@Override
	public IIterador iteradorArestas() {
		return listaArestas.iterador();
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
	public IIterador verticesAdjacentes(Vertice v) {
		Lista listaArestaAdjacentes = new Lista();
		IIterador itArestas = v.getListaArestas().iterador();
		Aresta aresta;
		while(itArestas.temProximo()){
			aresta = (Aresta)itArestas.obterProximo();
			if(aresta.getVertice1() == v ){//Caso exista um loop entrará aqui.
				listaArestaAdjacentes.inserirInicio(aresta.getVertice2());
			}
			else if(aresta.getVertice2() == v){
				listaArestaAdjacentes.inserirInicio(aresta.getVertice1());
			}
		}
		return listaArestaAdjacentes.iterador();
	}

	@Override
	public IIterador arestasIncidentes(Vertice v) {
		return v.getListaArestas().iterador();
	}

	@Override
	public boolean adjacentes(Vertice v, Vertice w) {
		IIterador itArestas = v.getListaArestas().iterador();
		Aresta aresta = null;
		while(itArestas.temProximo()){
			aresta = (Aresta)itArestas.obterProximo();
			if(aresta.getVertice1() == w || aresta.getVertice2() == w){
				return true;
			}
		}
		return false;
	}

	@Override
	public Vertice inserir(Vertice v, Vertice w, Object o) {
		
		if(v == null || w == null || o == null){
			return null;
		}
		Vertice novo = new Vertice(o);
		Aresta aresta1 = new Aresta(v, novo);
		novo.getListaArestas().inserirInicio(aresta1);
		v.setGrau(v.getGrau() + 1);
		v.getListaArestas().inserirInicio(aresta1);
		Aresta aresta2 = new Aresta(novo, w);
		w.getListaArestas().inserirInicio(aresta2);
		w.setGrau(w.getGrau() + 1);
		novo.setGrau(2);
		novo.getListaArestas().inserirInicio(aresta2);
		
		listaVertices.inserirInicio(novo);
		listaArestas.inserirInicio(aresta1);
		listaArestas.inserirInicio(aresta2);
		
		numArestas += 2;
		numVertices++;
		return novo;
	}

	@Override
	public Vertice inserir(Vertice w, Object o) {
		if(w == null || o == null){
			return null;
		}
		Vertice novo = new Vertice(o);
		Aresta aresta = new Aresta(w, novo);
		novo.getListaArestas().inserirInicio(aresta);
		w.getListaArestas().inserirInicio(aresta);
		w.setGrau(w.getGrau() + 1);
		novo.setGrau(1);
		
		listaVertices.inserirInicio(novo);
		listaArestas.inserirInicio(aresta);
		
		numArestas++;
		numVertices++;
		
		return novo;
	}

}
