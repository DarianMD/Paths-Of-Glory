package Paises;

public class Pais {
	
	private int score;
	private int vida;
	private double danyoAtaque;
	private String nombre;
	private int tipo;
	private String personaje;
	
	protected Pais(String nombre) {
	  this.nombre = nombre;
	  this.danyoAtaque = 1;
	  this.score = 0;
	  this.vida = 200;
    }
	
    //Setters
	public void setDañoAtaque(double danyoAtaque) {
		this.danyoAtaque = danyoAtaque;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	//Getters
	public double getDañoAtaque() {
		return this.danyoAtaque;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getTip() {
		return this.tipo;
	}
}
