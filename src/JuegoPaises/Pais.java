package JuegoPaises;

public class Pais {
	
	private int score;
	private int vida;
	private double danyoAtaque;
	private String nombre;
	private String personaje;
	private int escudo;
	private int energia;
	private int puntuacion;
	
	protected Pais(String nombre) {
	  this.nombre = nombre;
	  this.danyoAtaque = 1;
	  this.score = 0;
	  this.vida = 200;
	  this.escudo = 0;
	  this.energia = 50;
	  this.puntuacion = 0;
    }
	
    public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public double getDanyoAtaque() {
		return danyoAtaque;
	}

	public void setDanyoAtaque(double danyoAtaque) {
		this.danyoAtaque = danyoAtaque;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	

	public String getPersonaje() {
		return personaje;
	}


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
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public double getDañoAtaque() {
		return this.danyoAtaque;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
}
