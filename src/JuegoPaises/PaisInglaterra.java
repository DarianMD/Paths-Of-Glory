package JuegoPaises;

public class PaisInglaterra extends Pais implements Tipo {

	public PaisInglaterra(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}
	

	@Override
	public void aplicarStatsPais() {
		this.setDa�oAtaque(1.5);
		this.setVida(160);
		
	}
}
