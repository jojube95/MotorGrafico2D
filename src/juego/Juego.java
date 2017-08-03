
package juego;

import entes.criaturas.Jugador;
import entes.criaturas.NPC;
import graficos.Dialogo;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import mapa.Mapa;
import mapa.MapaCargado;
import control.Teclado;

/**
 *
 * @author Joan
 */
public class Juego extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;
    
    private static JFrame ventana;
    
    private static Thread thread;
    private static final int ANCHO = 800;
            
    private static final int ALTO = 600; 
    
    private static volatile boolean enFuncionamiento = false;
    
    private static final String NOMBRE = "Juego";
    
    private static int aps = 0;
    
    private static int fps = 0;
    
    private static String CONTADOR_APS = "";
    private static String CONTADOR_FPS = "";
    
    private static Teclado teclado;
    
    private static Pantalla pantalla;
    
    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    
    private static Mapa mapa;
    
    private static Jugador jugador;
    
    private static NPC oak;
    
    public static Dialogo dialogo;
    
    private Juego(){
    	sonarMusica();
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        pantalla = new Pantalla(ANCHO, ALTO);
        
        //mapa = new MapaGenerado(128, 128);
        
        mapa = new MapaCargado("/mapas/Nivel1.png");
        
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        jugador = new Jugador(mapa, teclado, 225, 225,Sprite.ABAJO0);
        oak = new NPC(mapa, 200, 200, Sprite.OAKABAJO0);
        dialogo = new Dialogo("Eres chico o chica?");
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
        
    }
    
    public static void main(String[] args){
    	
        Juego juego = new Juego();
        
        juego.iniciar();
    }
    
    public void sonarMusica(){
    	try{
    		AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(this.getClass().getResource("/audio/masia.mp3"));
    		Clip clip = AudioSystem.getClip();
    		clip.open(audioInputStream);
    		clip.start( );
	    }
	   catch(Exception ex)
	   {  }
    }

    private synchronized void iniciar(){
       enFuncionamiento = true;
       thread = new Thread(this, "Graficos");
       thread.start();
    }
    
    private void actualizar(){
        teclado.actualizar();
        
        jugador.actualizar();
        oak.actualizar();
        
        
        if(teclado.salir){
        	System.exit(0);
        }
        aps++;
    }
    
    private void mostrar(){
    	BufferStrategy estrategia = getBufferStrategy();
    	
    	if(estrategia == null){
    		createBufferStrategy(3);
    		return;
    	}
    	
    	pantalla.limpiar();
    	mapa.mostrar(jugador.getX() - pantalla.getAncho()/2 + jugador.getSprite().getLado() / 2, jugador.getY() -pantalla.getAlto()/2 +
    			 jugador.getSprite().getLado() / 2, pantalla);
    	jugador.mostrar(pantalla);
    	oak.mostrar(pantalla);
    	
    	System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
    	/*
    	for(int i = 0; i < pixeles.length; i++){
    		pixeles[i] = pantalla.pixeles[i];
    	}*/
    	
    	Graphics g = estrategia.getDrawGraphics();
    	
    	g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
    	
    	g.setColor(Color.RED);
    	
    	
    	g.drawString(CONTADOR_APS, 10, 20);
    	g.drawString(CONTADOR_FPS, 10, 35);
    	g.drawString("pos X: "+Integer.toString(jugador.getX()), 10, 50);
    	g.drawString("pos Y: "+Integer.toString(jugador.getY()), 10, 65);
    	
    	g.dispose();

    	estrategia.show();
        fps++;
    }
    /*private synchronized void detener(){
        enFuncionamiento = false;
        
        try {
            thread.join();
        } catch (InterruptedException ex) {
            
        }
        
    }*/
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        
        long referenciaActualizacion = System.nanoTime();
        
        long referenciaContador = System.nanoTime();
        
        double tiempoTranscurrido;
        double delta = 0;
        
        requestFocus();
        while(enFuncionamiento){
            final long inicioBucle = System.nanoTime();
            
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
                     
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            
            while(delta >= 1){
                actualizar();
                delta--;
            }
            
            
            mostrar();
            
            if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                //ventana.setTitle(NOMBRE+ " || APS: "+aps+" || FPS: "+fps);
            	CONTADOR_APS = "APS: "+aps;
            	CONTADOR_FPS = "FPS: "+fps;
                aps = 0;
                fps = 0;
                
                referenciaContador = System.nanoTime();
            }
        }
       
    }
    
    
}
