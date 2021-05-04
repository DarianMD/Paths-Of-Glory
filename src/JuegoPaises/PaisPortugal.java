package JuegoPaises;

public class PaisPortugal extends Pais implements Tipo {

	public PaisPortugal(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setDañoAtaque(2);
		this.setVida((int)(Math.random()*200)+50);
		this.setDañoAtaque(Math.random()+0.1);
		this.setTipo(3);
	}
}
