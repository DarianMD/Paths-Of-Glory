package JuegoPaises;

public class PaisPortugal extends Pais implements Tipo {

	public PaisPortugal(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setDa?oAtaque(0.5);
		this.setVida((int)(Math.random()*200)+50);
		this.setDa?oAtaque(Math.random()+0.1);
		this.setTipo("Portugal");
	}
}
