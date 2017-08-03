package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa{
	
	private int[] pixeles;
	
	public MapaCargado(String ruta) {
		super(ruta);
	}
	
	protected void cargarMapa(String ruta){
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
			ancho = imagen.getWidth();
			alto = imagen.getHeight();
			
			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];
			
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void generarMapa(){
		for(int i = 0; i < pixeles.length; i++){
			switch(pixeles[i]){
			case 0xff70c0a0:
				cuadrosCatalogo[i] = Cuadro.SUELO;
				continue;
			
			case 0xff808088:
				cuadrosCatalogo[i] = Cuadro.VALLA_HORIZONTAL;
				continue;
			
			case 0xff18a068:
				cuadrosCatalogo[i] = Cuadro.HIERBA;
				continue;
			
			case 0xff404868:
				cuadrosCatalogo[i] = Cuadro.VALLA_ESQUINASI;
				continue;
			
			case 0xffa0d0c0:
				cuadrosCatalogo[i] = Cuadro.VALLA_VERTICALI;
				continue;
			
			case 0xffe4ed5a:
				cuadrosCatalogo[i] = Cuadro.VALLA_ESQUINAII;
				continue;
			
			case 0xff4141d0:
				cuadrosCatalogo[i] = Cuadro.VALLA_VERTICALD;
				continue;
			
			case 0xff59d041:
				cuadrosCatalogo[i] = Cuadro.VALLA_ESQUINAID;
				continue;
			
			case 0xffad41d0:
				cuadrosCatalogo[i] = Cuadro.VALLA_ESQUINASD;
				continue;
			
			case 0xffb1650a:
				cuadrosCatalogo[i] = Cuadro.PIEDRA;
				continue;
			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}

}
