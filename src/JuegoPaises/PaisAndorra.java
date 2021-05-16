package JuegoPaises;

public class PaisAndorra extends Pais implements Tipo {

	public PaisAndorra(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setDa�oAtaque(1.15);
		this.setVida(200);
		this.setTipo("Andorra");
	}
}
