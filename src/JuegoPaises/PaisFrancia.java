package JuegoPaises;

public class PaisFrancia extends Pais implements Tipo {

	public PaisFrancia(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setDa�oAtaque(0.9);
		this.setVida(220);	
	}
}
