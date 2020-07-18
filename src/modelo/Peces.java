package modelo;

public class Peces {
 
	private int x;
	private int y;
	private int w;
	private int h;
	private String nombre;
	
	public Peces(int x, int y, int w, int h, String nombre) {
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.nombre = nombre;
		
		
	}
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}
	
	public void mover(int distancia) {
	
		this.x += distancia;
	}
	
	public void seguir() {
		
		this.x = 0;
		mover(30);
	}

	

}
