package model;

public class Linha {

	private int x1 = 0;
	private int x2 = 0;
	private int y1 = 0;
	private int y2 = 0;

	public Linha(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * Retorna o conte�do de x1.
	 * @return x1 - Conte�do de x1.
	 */
	public int getX1() {
		return x1;
	}
	/**
	 * Altera o conte�do de x1.
	 * @param x1 - Novo conte�do de x1.
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}
	/**
	 * Retorna o conte�do de x2.
	 * @return x2 - Conte�do de x2.
	 */
	public int getX2() {
		return x2;
	}
	/**
	 * Altera o conte�do de x2.
	 * @param x2 - Novo conte�do de x2.
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}
	/**
	 * Retorna o conte�do de y1.
	 * @return y1 - Conte�do de y1.
	 */
	public int getY1() {
		return y1;
	}
	/**
	 * Altera o conte�do de y1.
	 * @param y1 - Novo conte�do de y1.
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}
	/**
	 * Retorna o conte�do de y2.
	 * @return y2 - Conte�do de y2.
	 */
	public int getY2() {
		return y2;
	}
	/**
	 * Altera o conte�do de y2.
	 * @param y2 - Novo conte�do de y2.
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}

}
