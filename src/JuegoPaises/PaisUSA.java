package JuegoPaises;

public class PaisUSA extends Pais implements Tipo {

	public PaisUSA(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setDa�oAtaque(1.1);
		this.setVida(250);
		
	}
}
