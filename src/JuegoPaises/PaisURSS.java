package JuegoPaises;

public class PaisURSS extends Pais implements Tipo {

	public PaisURSS(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}
	

	@Override
	public void aplicarStatsPais() {
		this.setDa�oAtaque(1.4);
		this.setVida(130);
		
	}
}
