package model;

public class Linha {

	private Ponto ponto1 = null;
	private Ponto ponto2 = null;
	private int custo = 0;

	public Linha(){
	}

	/**
	 * Retorna o conte�do de ponto1.
	 * @return ponto1 - Conte�do de ponto1.
	 */
	public Ponto getPonto1() {
		return ponto1;
	}

	/**
	 * Altera o conte�do de ponto1.
	 * @param ponto1 - Novo conte�do de ponto1.
	 */
	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	/**
	 * Retorna o conte�do de ponto2.
	 * @return ponto2 - Conte�do de ponto2.
	 */
	public Ponto getPonto2() {
		return ponto2;
	}

	/**
	 * Altera o conte�do de ponto2.
	 * @param ponto2 - Novo conte�do de ponto2.
	 */
	public void setPonto2(Ponto ponto2) {
		this.ponto2 = ponto2;
	}

	/**
	 * Retorna o conte�do de custo.
	 * @return custo - Conte�do de custo.
	 */
	public int getCusto() {
		return custo;
	}

	/**
	 * Altera o conte�do de custo.
	 * @param custo - Novo conte�do de custo.
	 */
	public void setCusto(int custo) {
		this.custo = custo;
	}

}
