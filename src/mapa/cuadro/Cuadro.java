package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {
	public int x;
	public int y;
	
	public static final int lado = 32;
	public Sprite sprite;
	private boolean solido;
	
	//Coleccion de cuadros
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO, true);
	public static final Cuadro SUELO = new Cuadro(Sprite.SUELO);
	public static final Cuadro HIERBA = new Cuadro(Sprite.HIERBA);
	public static final Cuadro SETO = new Cuadro(Sprite.SETO, true);
	public static final Cuadro PIEDRA = new Cuadro(Sprite.PIEDRA, true);
	public static final Cuadro FLOR = new Cuadro(Sprite.FLOR);
	public static final Cuadro VALLA_VERTICALD = new Cuadro(Sprite.VALLA_VERTICALD, true);
	public static final Cuadro VALLA_VERTICALI = new Cuadro(Sprite.VALLA_VERTICALI, true);
	public static final Cuadro VALLA_HORIZONTAL = new Cuadro(Sprite.VALLA_HORIZONTAL, true);
	public static final Cuadro VALLA_ESQUINASI = new Cuadro(Sprite.VALLA_ESQUINASI, true);
	public static final Cuadro VALLA_ESQUINASD = new Cuadro(Sprite.VALLA_ESQUINASD, true);
	public static final Cuadro VALLA_ESQUINAII = new Cuadro(Sprite.VALLA_ESQUINAII, true);
	public static final Cuadro VALLA_ESQUINAID = new Cuadro(Sprite.VALLA_ESQUINAID, true);
	public static final Cuadro VALLA_PUERTAI = new Cuadro(Sprite.VALLA_PUERTAI, true);
	public static final Cuadro VALLA_PUERTAD = new Cuadro(Sprite.VALLA_PUERTAD, true);
	//fin coleccion cuadros
	public Cuadro(Sprite sprite){
		this.sprite = sprite;
		solido = false;
	}
	
	public Cuadro(Sprite sprite, boolean solido){
		this.sprite = sprite;
		this.solido = solido;
	}
	
	public void mostrar(int x, int y, Pantalla pantalla){
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}
	
	public boolean getSolido(){
		return solido;
	}
}
