package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class HojaSprites {
    private int ancho;
    private int alto;
    
    public final int[] pixeles;
    
    //Colencion de hojas de sprites
    public static HojaSprites hierba = new HojaSprites("/texturas/SpriteSheet.png", 320, 320);
    public static HojaSprites jugador = new HojaSprites("/texturas/Personaje.png", 320, 320);
    public static HojaSprites oak = new HojaSprites("/texturas/oak.png", 320, 320);
    //fin de la coleccion
    
    public HojaSprites(final String ruta, final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        pixeles = new int[ancho*alto];
        
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            Logger.getLogger(HojaSprites.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    
}
