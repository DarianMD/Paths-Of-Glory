package JuegoPaises;

public class PaisEspania extends Pais implements Tipo {

	public PaisEspania(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}
	

	@Override
	public void aplicarStatsPais() {
		this.setDañoAtaque(0.6);
		this.setVida(250);
<<<<<<< HEAD
		
=======
		this.setTipo(1);
>>>>>>> origin/main
	}
}
