package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class Dialogo {
	private final int ancho = 800;
	private final int alto = 100;
	
	public int pixeles[];
	@SuppressWarnings("unused")
	private String texto;
	
	public Dialogo(String texto){
		this.texto = texto;
		
		pixeles = new int[getAncho()*getAlto()];
        
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(Dialogo.class.getResource("/texturas/dialogo.png"));
            imagen.getRGB(0, 0, getAncho(), getAlto(), pixeles, 0, getAncho());
        } catch (IOException ex) {
            Logger.getLogger(Dialogo.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void mostrar(Pantalla pantalla){
		pantalla.mostrarDialogo(this);
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
}
