package entes.criaturas;

import java.util.Random;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class NPC extends Criatura{
	private int animacion;
	
	
	public NPC(Mapa mapa, Sprite sprite){
		this.sprite = sprite;
		this.mapa = mapa;
	}
	
	public NPC(Mapa mapa, int posicionX, int posicionY, Sprite sprite){
		
		this.x = posicionX;
		this.y = posicionY;
		this.sprite = sprite;
		this.mapa = mapa;
	}
	
	public void actualizar(){
		int desplazamientoX = 0;
		int desplazamientoY = 0;
				
		if(animacion < 32767){//para no sobrepasar el rango de int
			animacion++;
		}
		else{
			animacion = 0;
		}
		
		Random random = new Random();
		//if(animacion % 10 == 0){
			
			if(random.nextInt(4) == 0){
				desplazamientoY-=8;
			}
			if((random.nextInt(4) == 1)){
				desplazamientoY+=8;
			}
			if((random.nextInt(4) == 2)){
				desplazamientoX-=8;
			}
			if((random.nextInt(4) == 3)){
				desplazamientoX+=8;
			}
		//}
		
		if(desplazamientoX != 0 || desplazamientoY != 0){
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		}
		else{
			enMovimiento = false;
		}
		
		
			//Controlar las direcciones
			if(direccion == 'n'){
				sprite = Sprite.OAKARRIBA0;
				if(enMovimiento){//Controla las animaciones
					if(animacion % 40 > 10){
						sprite = Sprite.OAKARRIBA1;
					}
					else{
						sprite = Sprite.OAKARRIBA2;
					}
				}
			}
							
			if(direccion == 's'){
				sprite = Sprite.OAKABAJO0;
				if(enMovimiento){
					if(animacion % 20 > 10){
						sprite = Sprite.OAKABAJO1;
					}
					else{
						sprite = Sprite.OAKABAJO2;
					}
				}
			}
			if(direccion == 'e'){
				sprite = Sprite.OAKDERECHA0;
				if(enMovimiento){
					if(animacion % 30 > 20){
						sprite = Sprite.OAKDERECHA1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.OAKDERECHA0;
						}
						else{
							sprite = Sprite.OAKDERECHA2;
						}
					}
				}
			}
			if(direccion == 'w'){
				sprite = Sprite.OAKIZQUIERDA0;
				if(enMovimiento){
					if(animacion % 30 > 20){
						sprite = Sprite.OAKIZQUIERDA1;
					}
					else{
						if(animacion % 30 > 10){
							sprite = Sprite.OAKIZQUIERDA0;
						}
						else{
							sprite = Sprite.OAKIZQUIERDA2;
						}
					}
				}
			}
		}
		
			
		
		
	
	
	public void mostrar(Pantalla pantalla){
		pantalla.mostrarNPC(x, y, this);
	}

}
