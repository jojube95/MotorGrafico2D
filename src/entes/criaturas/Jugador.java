package entes.criaturas;

import mapa.Mapa;
import graficos.Pantalla;
import graficos.Sprite;
import control.Teclado;

public class Jugador extends Criatura{
	private Teclado teclado;
	
	private int animacion;
	
	
	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite){
		this.teclado = teclado;
		this.sprite = sprite;
		this.mapa = mapa;
	}
	
	public Jugador(Mapa mapa, Teclado teclado, int posicionX, int posicionY, Sprite sprite){
		this.teclado = teclado;
		this.x = posicionX;
		this.y = posicionY;
		this.sprite = sprite;
		this.mapa = mapa;
	}
	
	public void actualizar(){
		int desplazamientoX = 0;
		int desplazamientoY = 0;
		
		int velocidadMovimiento = 2;
		
		if(animacion < 32767){//para no sobrepasar el rango de int
			animacion++;
		}
		else{
			animacion = 0;
		}
		
		if(teclado.correr){
			velocidadMovimiento = 3;
		}
				
		if(teclado.arriba){
			desplazamientoY-=velocidadMovimiento;
		}
		if(teclado.abajo){
			desplazamientoY+=velocidadMovimiento;
		}
		if(teclado.izquierda){
			desplazamientoX-=velocidadMovimiento;
		}
		if(teclado.derecha){
			desplazamientoX+=velocidadMovimiento;
		}
		
		if(desplazamientoX != 0 || desplazamientoY != 0){
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		}
		else{
			enMovimiento = false;
		}
		
		if(velocidadMovimiento==2){
			//Controlar las direcciones
			if(direccion == 'n'){
				sprite = Sprite.ARRIBA0;
				if(enMovimiento){//Controla las animaciones
					if(animacion % 40 > 10){
						sprite = Sprite.ARRIBA1;
					}
					else{
						sprite = Sprite.ARRIBA2;
					}
				}
			}
							
			if(direccion == 's'){
				sprite = Sprite.ABAJO0;
				if(enMovimiento){
					if(animacion % 20 > 10){
						sprite = Sprite.ABAJO1;
					}
					else{
						sprite = Sprite.ABAJO2;
					}
				}
			}
			if(direccion == 'e'){
				sprite = Sprite.DERECHA0;
				if(enMovimiento){
					if(animacion % 30 > 20){
						sprite = Sprite.DERECHA1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.DERECHA0;
						}
						else{
							sprite = Sprite.DERECHA2;
						}
					}
				}
			}
			if(direccion == 'w'){
				sprite = Sprite.IZQUIERDA0;
				if(enMovimiento){
					if(animacion % 30 > 20){
						sprite = Sprite.IZQUIERDA1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.IZQUIERDA0;
						}
						else{
							sprite = Sprite.IZQUIERDA2;
						}
					}
				}
			}
		}
		else{
			
			if(direccion == 'n'){
				sprite = Sprite.CORRERARRIBA0;
				if(enMovimiento){//Controla las animaciones
					if(animacion % 30 > 20){
						sprite = Sprite.CORRERARRIBA1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.CORRERARRIBA2;
						}
						else{
							sprite = Sprite.CORRERARRIBA0;
						}
					}
				}
			}
							
			if(direccion == 's'){
				sprite = Sprite.CORRERABAJO0;
				if(enMovimiento){//Controla las animaciones
					if(animacion % 30 > 20){
						sprite = Sprite.CORRERABAJO1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.CORRERABAJO2;
						}
						else{
							sprite = Sprite.CORRERABAJO0;
						}
					}
				}
			}
			if(direccion == 'e'){
				sprite = Sprite.CORRERDERECHA0;
				if(enMovimiento){//Controla las animaciones
					if(animacion % 30 > 20){
						sprite = Sprite.CORRERDERECHA1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.CORRERDERECHA2;
						}
						else{
							sprite = Sprite.CORRERDERECHA0;
						}
					}
				}
			}
			if(direccion == 'w'){
				sprite = Sprite.CORRERIZQUIERDA0;
				if(enMovimiento){//Controla las animaciones
					if(animacion % 30 > 20){
						sprite = Sprite.CORRERIZQUIERDA1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.CORRERIZQUIERDA2;
						}
						else{
							sprite = Sprite.CORRERIZQUIERDA0;
						}
					}
				}
			}
			
		}
		
	}
	
	public void mostrar(Pantalla pantalla){
		pantalla.mostrarJugador(x, y, this);
	}
	
}
