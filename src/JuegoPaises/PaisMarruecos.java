package JuegoPaises;

public class PaisMarruecos extends Pais implements Tipo {

	public PaisMarruecos(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setDañoAtaque(1.25);
		this.setVida(230);
		this.setTipo("Marruecos");
	}
}
