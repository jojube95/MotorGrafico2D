package graficos;

import entes.criaturas.Jugador;
import entes.criaturas.NPC;
import mapa.cuadro.Cuadro;


public final class Pantalla {
    private final int ancho;
    private final int alto;
    
    private int diferenciaX;
    private int diferenciaY;
    
    public final int[] pixeles;
    
        
    public Pantalla(final int ancho,final int alto){
        this.alto = alto;
        this.ancho = ancho;
        
        pixeles = new int[ancho * alto];
        
    }
    
    public void limpiar(){
        for(int i =0; i < pixeles.length; i++){
            pixeles[i] = 0;
        }
    }
    
    
    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro){
    	compensacionX-=diferenciaX;
    	compensacionY-=diferenciaY;
    	
    	for(int y = 0; y < cuadro.sprite.getLado(); y++){
    		int posicionY = y + compensacionY;
    		
    		for(int x = 0; x < cuadro.sprite.getLado(); x++){
    			int posicionX = x + compensacionX;
    			
    			if(posicionX < -cuadro.sprite.getLado() || posicionX >= getAncho() || posicionY < 0 || posicionY >= getAlto()){
    				break;
    			}
    			if(posicionX < 0){
    				posicionX = 0;
    			}
    			pixeles[posicionX + posicionY * getAncho()] = cuadro.sprite.pixeles[x + y * cuadro.sprite.getLado()];

    		}
    	}
    }
    
    public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador){
    	compensacionX-=diferenciaX;
    	compensacionY-=diferenciaY;
    	
    	for(int y = 0; y < jugador.getSprite().getLado(); y++){
    		int posicionY = y + compensacionY;
    		
    		for(int x = 0; x < jugador.getSprite().getLado(); x++){
    			int posicionX = x + compensacionX;
    			
    			if(posicionX < -jugador.getSprite().getLado() || posicionX >= getAncho() || posicionY < 0 || posicionY >= getAlto()){
    				break;
    			}
    			if(posicionX < 0){
    				posicionX = 0;
    			}
    			//pixeles[posicionX + posicionY * getAncho()] = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];
    			int colorPixelJugador = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];
    			if(colorPixelJugador != 0xffff00ff){
    				pixeles[posicionX + posicionY * getAncho()] = colorPixelJugador;
    			}
    		}
    	}
    }
    
    public void mostrarNPC(int compensacionX, int compensacionY, NPC npc){
    	compensacionX-=diferenciaX;
    	compensacionY-=diferenciaY;
    	
    	for(int y = 0; y < npc.getSprite().getLado(); y++){
    		int posicionY = y + compensacionY;
    		
    		for(int x = 0; x < npc.getSprite().getLado(); x++){
    			int posicionX = x + compensacionX;
    			
    			if(posicionX < -npc.getSprite().getLado() || posicionX >= getAncho() || posicionY < 0 || posicionY >= getAlto()){
    				break;
    			}
    			if(posicionX < 0){
    				posicionX = 0;
    			}
    			//pixeles[posicionX + posicionY * getAncho()] = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];
    			int colorPixelJugador = npc.getSprite().pixeles[x + y * npc.getSprite().getLado()];
    			if(colorPixelJugador != 0xffff00ff){
    				pixeles[posicionX + posicionY * getAncho()] = colorPixelJugador;
    			}
    		}
    	}
    }
    
    public void mostrarDialogo(Dialogo dialogo){
    	for(int y = 0; y < dialogo.getAncho(); y++){
    		
    		for(int x = 0; x < dialogo.getAlto(); x++){
    			pixeles[x + y * getAncho()] = 0;
    			pixeles[x + y * getAncho()] = dialogo.pixeles[x + y * dialogo.getAncho()];

    		}
    	}
    }
    
    public void estableceDiferencia(final int diferenciaX, final int diferenciaY){
    	this.diferenciaX = diferenciaX;
    	this.diferenciaY = diferenciaY;
    }

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
            
}
