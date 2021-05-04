package JuegoPaises;

public class PaisAlemania extends Pais implements Tipo {

	public PaisAlemania(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}
	

	@Override
	public void aplicarStatsPais() {
		this.setDañoAtaque(1.2);
		this.setVida(190);
<<<<<<< HEAD
		
=======
		this.setTipo(1);
>>>>>>> origin/main
	}
}
