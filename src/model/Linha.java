package model;

public class Linha {

	private Ponto ponto1 = null;
	private Ponto ponto2 = null;
	private int custo = 0;

	public Linha(){
	}

	/**
	 * Retorna o conte�do do ponto 1.
	 * @return Ponto - Conte�do do ponto 1.
	 */
	public Ponto getPonto1() {
		return ponto1;
	}

	/**
	 * Altera o conte�do do ponto1.
	 * @param Ponto - Novo conte�do do ponto 1.
	 */
	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	/**
	 * Retorna o conte�do do ponto 2.
	 * @return Ponto - Conte�do do ponto 2.
	 */
	public Ponto getPonto2() {
		return ponto2;
	}

	/**
	 * Altera o conte�do do ponto 2.
	 * @param Ponto - Novo conte�do do ponto 2.
	 */
	public void setPonto2(Ponto ponto2) {
		this.ponto2 = ponto2;
	}

	/**
	 * Retorna o Peso da linha
	 * @return int - Peso da linha
	 */
	public int getCusto() {
		return custo;
	}

	/**
	 * Altera o peso da linha
	 * @param int - Novo peso.
	 */
	public void setCusto(int custo) {
		this.custo = custo;
	}

}
