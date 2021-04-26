package Paises;

public class PaisNoruega extends Pais implements Tipo {

	protected PaisNoruega(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setVida(250);
		this.setDa�oAtaque(0.7);
		this.setTipo(3);
	}
}
