package mapa;

import mapa.cuadro.Cuadro;
import graficos.Pantalla;

public abstract class Mapa {
	protected int alto;
	protected int ancho;
	
	protected int[] cuadros;
	
	protected Cuadro[] cuadrosCatalogo;
	
	public Mapa(int ancho, int alto){
		this.alto = alto;
		this.ancho = ancho;
		cuadros = new int[ancho * alto];
		generarMapa();
		
	}
	
	public Mapa(String ruta){
		cargarMapa(ruta);
		generarMapa();
	}
	
	protected void generarMapa(){
		
	}
	
	protected void cargarMapa(String ruta){
		
	}
	
	public void actualizar(){
		
	}
	
	public void mostrar(final int compensacionX, final int compensacionY, Pantalla pantalla){
		pantalla.estableceDiferencia(compensacionX, compensacionY);
		int o = compensacionX >> 5;
		int e = (compensacionX + pantalla.getAncho() + Cuadro.lado) >> 5;
		int n = compensacionY >> 5;
		int s = (compensacionY + pantalla.getAlto() + Cuadro.lado) >> 5;
		
		for(int y = n ; y < s; y++){
			for(int x = o; x < e; x++){
				//obtenCuadro(x, y).mostrar(x, y, pantalla);
				if(x < 0 || y < 0 || x>=ancho || y>=alto){//para no salirse del mapa
					Cuadro.VACIO.mostrar(x, y, pantalla);
				}
				else{//si estamos dentro del mapa mostramos el cuadro
					cuadrosCatalogo[x + y *ancho].mostrar(x, y, pantalla);
				}
			}
		}
	}
	
	public Cuadro obtenCuadro(final int x, final int y){
		if( x < 0 || y < 0 || x >= ancho || y >= alto){
			return Cuadro.VACIO;
		}
		switch(cuadros[x + y * ancho]){
		case 0:
			return Cuadro.SUELO;
		case 1:
			return Cuadro.HIERBA;
		case 2:
			return Cuadro.SETO;
		case 3:
			return Cuadro.PIEDRA;
		case 4:
			return Cuadro.FLOR;
		case 5:
			return Cuadro.VALLA_VERTICALI;
		case 6:
			return Cuadro.VALLA_VERTICALD;
		case 7:
			return Cuadro.VALLA_HORIZONTAL;
		case 8:
			return Cuadro.VALLA_ESQUINASI;
		case 9:
			return Cuadro.VALLA_ESQUINASD;
		case 10:
			return Cuadro.VALLA_ESQUINAII;
		case 11:
			return Cuadro.VALLA_ESQUINAID;
		case 12:
			return Cuadro.VALLA_PUERTAI;
		case 13:
			return Cuadro.VALLA_PUERTAD;
						
		default:
			return Cuadro.VACIO;
		}
	}
	
	public Cuadro obtenerCuadroCatalogo(int posicion){
		return cuadrosCatalogo[posicion];
	}
	
	public int obtenerAncho(){
		return ancho;
	}
}
