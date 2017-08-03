package entes;

import mapa.Mapa;

public abstract class Ente {
	protected int x;
	protected int y;
	
	private boolean eliminado = false;
	
	protected Mapa mapa;
	
	public void actualizar(){
		
	}
	
	public void mostrar(){
		
	}
	
	public void eliminar(){
		eliminado = true;
	}

	public int getX() {
		return x;
	}
	
	public void modificarPosicionX(int desplazamientoX) {
		x+=desplazamientoX;
	}

	public int getY() {
		return y;
	}
	
	public void modificarPosicionY(int desplazamientoY) {
		y+=desplazamientoY;
	}
	
	public boolean getEliminado(){
		return eliminado;
	}
	
	
}
