package grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Ponto;
import util.Grafo;
import util.Vertice;

public class GrafoTest {

	Grafo grafo;
	@Before
	public void setUp() throws Exception {
		grafo = new Grafo();
	}

	@Test
	public void inserirTest() {

		Ponto ponto = new Ponto("Banco 1");
		
		Vertice inicio = grafo.inserir(ponto);
		assertEquals(grafo.grauVertice(inicio), 0);
		assertEquals(grafo.numVertices(), 1);
		
		Ponto ponto2 = new Ponto("Banco 2");
		Vertice vertice = grafo.inserir(inicio, ponto2);
		assertEquals(grafo.numVertices(), 2);
		assertEquals(grafo.numArestas(), 1);
		assertEquals(grafo.grauVertice(inicio), 1);
		assertEquals(grafo.grauVertice(vertice), 1);
		assertTrue(grafo.adjacentes(inicio, vertice));
		
		Ponto ponto3 = new Ponto("Caixa Rápido 1");
		Vertice vertice2 = grafo.inserir(inicio, vertice, ponto3);
		assertEquals(grafo.grauVertice(inicio), 2);
		assertEquals(grafo.grauVertice(vertice), 2);
		assertEquals(grafo.numVertices(), 3);
		assertEquals(grafo.numArestas(), 3);
		assertTrue(grafo.adjacentes(inicio, vertice));
		assertTrue(grafo.adjacentes(vertice, vertice2));
		assertTrue(grafo.adjacentes(inicio, vertice2));
		
		Ponto ponto4 = new Ponto("Shopping");
		Vertice vertice3 = grafo.inserir(inicio, vertice2, ponto4);
		assertEquals(grafo.grauVertice(inicio), 3);
		assertEquals(grafo.numVertices(), 4);
		assertEquals(grafo.numArestas(), 5);
		assertTrue(grafo.adjacentes(inicio, vertice3));
		assertTrue(grafo.adjacentes(vertice3, vertice2));
		assertFalse(grafo.adjacentes(vertice3, vertice));
		
		Ponto ponto5 = new Ponto("Banco 3");
		Vertice vertice4 = grafo.inserir(vertice3, ponto5);
		assertEquals(grafo.numVertices(), 5);
		assertEquals(grafo.numArestas(), 6);
		assertTrue(grafo.adjacentes(vertice3, vertice4));
		assertFalse(grafo.adjacentes(vertice4, inicio));
		assertFalse(grafo.adjacentes(vertice4, vertice2));
		assertFalse(grafo.adjacentes(vertice4, vertice));
	}
	
	@Test
	public void removerTest(){
		
		Ponto ponto = new Ponto("Caixa");
		grafo.inserir(ponto);
		assertEquals(grafo.numArestas(), 0);
		assertEquals(grafo.numVertices(), 1);
		
		Ponto ponto2 = new Ponto("Caixa 2");
		grafo.inserir(ponto2);
		assertEquals(grafo.numArestas(), 0);
		assertEquals(grafo.numVertices(), 2);
		
		Ponto ponto3 = new Ponto("Caixa 3");
		grafo.inserir(ponto3);
		assertEquals(grafo.numArestas(), 0);
		assertEquals(grafo.numVertices(), 3);
		
		grafo.removerVertice(ponto);
		assertEquals(grafo.numArestas(), 0);
		assertEquals(grafo.numVertices(), 2);
		
		
	}

}
