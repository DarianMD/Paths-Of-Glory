package JuegoPaises;

public class PaisNoruega extends Pais implements Tipo {

	public PaisNoruega(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setVida(250);
		this.setDañoAtaque(0.7);
		
	}
}
