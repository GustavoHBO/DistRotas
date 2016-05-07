package model;

public class Ponto {
	
	private String nome = "Ponto";// Nome padrão do ponto.
	private int x = 0;
	private int y = 0;
	
	public Ponto(){
	}

	/**
	 * Retorna o nome do ponto.
	 * @return nome - Nome do ponto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do ponto.
	 * @param nome - Novo nome do ponto.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor de x.
	 * @return x - Valor do x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Altera o valor de x.
	 * @param x - Novo valor de x.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Retorna o valor de y.
	 * @return y - Valor de y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Altera o valor de y.
	 * @param y - Novo valor de y.
	 */
	public void setY(int y) {
		this.y = y;
	}
}
