package Juego.Paises;

public class PaisItalia extends Pais implements Tipo {

	public PaisItalia(String nombre) {
		super(nombre);
		this.aplicarStatsPais();
	}

	@Override
	public void aplicarStatsPais() {
		this.setVida(200);
		this.setDa�oAtaque(1);
		this.setTipo(3);	
	}
}
