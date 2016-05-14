package model;

public class Ponto {
	
	private String nome = "Ponto";// Nome padrão do ponto.
	private int x = 0;
	private int y = 0;
	
	public Ponto(){
	}

	/**
	 * Retorna o nome do ponto.
	 * @return String - Nome do ponto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do ponto.
	 * @param String - Novo nome do ponto.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor de x.
	 * @return int - Valor do x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Altera o valor de x.
	 * @param int - Novo valor de x.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Retorna o valor de y.
	 * @return int - Valor de y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Altera o valor de y.
	 * @param int - Novo valor de y.
	 */
	public void setY(int y) {
		this.y = y;
	}
}
