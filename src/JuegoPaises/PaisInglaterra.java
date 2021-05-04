package JuegoPaises;

public class PaisInglaterra extends Pais implements Tipo {

	public PaisInglaterra(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}
	

	@Override
	public void aplicarStatsPais() {
		this.setDañoAtaque(1.5);
		this.setVida(160);
		
	}
}
