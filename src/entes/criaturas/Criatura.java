package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

public class Criatura extends Ente {
	protected Sprite sprite;
	
	protected char direccion = 'n';//n, w, e, s
	
	protected boolean enMovimiento = false;
	
	public void actualizar(){
		
	}
	
	public void mostrar(){
		
	}
	
	public void mover(int desplazamientoX, int desplazamientoY){
		if(desplazamientoX > 0){
			direccion = 'e';
		}
		if(desplazamientoX < 0){
			direccion = 'w';
		}
		if(desplazamientoY > 0){
			direccion = 's';
		}
		if(desplazamientoY < 0){
			direccion = 'n';
		}
		
		if(!getEliminado()){
			if(!enColision(desplazamientoX, 0)){
				modificarPosicionX(desplazamientoX);
			}
			if(!enColision(0, desplazamientoY)){
				modificarPosicionY(desplazamientoY);
			}
			
			
			
			
		}
	}
	
	private boolean enColision(int desplazamientoX, int desplazamientoY){
		boolean colision = false;
		
		int posicionX = x + desplazamientoX;
		int posicionY = y + desplazamientoY;
		
		//Recortar el sprite en caso de no ocupar todo el cuadro 32x32, para que la colision sea mas real
		int margenIzquierdo = -30;
		int margenDerecho = 30;
		int margenSuperior = -28;
		int margenInferior = 30;
		
		int bordeIzquierdo = (posicionX + margenDerecho) / sprite.getLado();
		int bordeDerecho = (posicionX + margenIzquierdo + margenDerecho) / sprite.getLado();
		int bordeSuperior = (posicionY + margenInferior) / sprite.getLado();
		int bordeInferior = (posicionY + margenSuperior + margenInferior) / sprite.getLado();
		
		if(mapa.obtenerCuadroCatalogo(bordeIzquierdo + bordeSuperior * mapa.obtenerAncho()).getSolido()){
			colision = true;
		}
		if(mapa.obtenerCuadroCatalogo(bordeIzquierdo + bordeInferior * mapa.obtenerAncho()).getSolido()){
			colision = true;
		}
		if(mapa.obtenerCuadroCatalogo(bordeDerecho + bordeSuperior * mapa.obtenerAncho()).getSolido()){
			colision = true;
		}
		if(mapa.obtenerCuadroCatalogo(bordeDerecho + bordeInferior * mapa.obtenerAncho()).getSolido()){
			colision = true;
		}
		
		
		
		return colision;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
}
