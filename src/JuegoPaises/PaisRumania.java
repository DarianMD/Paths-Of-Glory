package JuegoPaises;

public class PaisRumania extends Pais implements Tipo {

	public PaisRumania(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setDañoAtaque(0.2);
		this.setVida(500);
		this.setTipo(2);
	}
}
