
package graficos;

public final class Sprite {
    private final int lado;
    
    private int x;
    private int y;
    
    public int[] pixeles;
    @SuppressWarnings("unused")
	private static HojaSprites hoja;
    
    //coleccion de sprites mapa1
    public static final Sprite VACIO  = new Sprite(32, 0);
    public static final Sprite SUELO = new Sprite(32, 0, 0, HojaSprites.hierba);
    public static final Sprite HIERBA = new Sprite(32, 1, 0, HojaSprites.hierba);
    public static final Sprite SETO = new Sprite(32, 2, 0, HojaSprites.hierba);
    public static final Sprite PIEDRA = new Sprite(32, 3, 0, HojaSprites.hierba);
    public static final Sprite FLOR = new Sprite(32, 4, 0, HojaSprites.hierba);
    public static final Sprite VALLA_VERTICALI = new Sprite(32, 5, 1, HojaSprites.hierba);
    public static final Sprite VALLA_VERTICALD = new Sprite(32, 7, 1, HojaSprites.hierba);
    public static final Sprite VALLA_HORIZONTAL = new Sprite(32, 6, 2, HojaSprites.hierba);
    public static final Sprite VALLA_ESQUINASI = new Sprite(32, 5, 0, HojaSprites.hierba);
    public static final Sprite VALLA_ESQUINASD = new Sprite(32, 7, 0, HojaSprites.hierba);
    public static final Sprite VALLA_ESQUINAII = new Sprite(32, 5, 2, HojaSprites.hierba);
    public static final Sprite VALLA_ESQUINAID = new Sprite(32, 7, 2, HojaSprites.hierba);
    public static final Sprite VALLA_PUERTAI = new Sprite(32, 6, 0, HojaSprites.hierba);
    public static final Sprite VALLA_PUERTAD = new Sprite(32, 6, 1, HojaSprites.hierba);
    //coleccion de sprites personaje
    public static final Sprite ABAJO0 = new Sprite(32, 0, 0, HojaSprites.jugador);
    public static final Sprite ABAJO1 = new Sprite(32, 0, 1, HojaSprites.jugador);
    public static final Sprite ABAJO2 = new Sprite(32, 0, 2, HojaSprites.jugador);
    
    public static final Sprite ARRIBA0 = new Sprite(32, 1, 0, HojaSprites.jugador);
    public static final Sprite ARRIBA1 = new Sprite(32, 1, 1, HojaSprites.jugador);
    public static final Sprite ARRIBA2 = new Sprite(32, 1, 2, HojaSprites.jugador);
    
    public static final Sprite IZQUIERDA0 = new Sprite(32, 2, 0, HojaSprites.jugador);
    public static final Sprite IZQUIERDA1 = new Sprite(32, 2, 1, HojaSprites.jugador);
    public static final Sprite IZQUIERDA2 = new Sprite(32, 2, 2, HojaSprites.jugador);
    
    public static final Sprite DERECHA0 = new Sprite(32, 3, 0, HojaSprites.jugador);
    public static final Sprite DERECHA1 = new Sprite(32, 3, 1, HojaSprites.jugador);
    public static final Sprite DERECHA2 = new Sprite(32, 3, 2, HojaSprites.jugador);
    
    public static final Sprite CORRERABAJO0 = new Sprite(32, 0, 3, HojaSprites.jugador);
    public static final Sprite CORRERABAJO1 = new Sprite(32, 0, 4, HojaSprites.jugador);
    public static final Sprite CORRERABAJO2 = new Sprite(32, 0, 5, HojaSprites.jugador);
    
    public static final Sprite CORRERARRIBA0 = new Sprite(32, 1, 3, HojaSprites.jugador);
    public static final Sprite CORRERARRIBA1 = new Sprite(32, 1, 4, HojaSprites.jugador);
    public static final Sprite CORRERARRIBA2 = new Sprite(32, 1, 5, HojaSprites.jugador);
    
    public static final Sprite CORRERIZQUIERDA0 = new Sprite(32, 2, 3, HojaSprites.jugador);
    public static final Sprite CORRERIZQUIERDA1 = new Sprite(32, 2, 4, HojaSprites.jugador);
    public static final Sprite CORRERIZQUIERDA2 = new Sprite(32, 2, 5, HojaSprites.jugador);
    
    public static final Sprite CORRERDERECHA0 = new Sprite(32, 3, 3, HojaSprites.jugador);
    public static final Sprite CORRERDERECHA1 = new Sprite(32, 3, 4, HojaSprites.jugador);
    public static final Sprite CORRERDERECHA2 = new Sprite(32, 3, 5, HojaSprites.jugador);
    
    
    public static final Sprite OAKABAJO0 = new Sprite(32, 0, 0, HojaSprites.oak);
    public static final Sprite OAKABAJO1 = new Sprite(32, 1, 0, HojaSprites.oak);
    public static final Sprite OAKABAJO2 = new Sprite(32, 2, 0, HojaSprites.oak);
    
    public static final Sprite OAKARRIBA0 = new Sprite(32, 0, 3, HojaSprites.oak);
    public static final Sprite OAKARRIBA1 = new Sprite(32, 1, 3, HojaSprites.oak);
    public static final Sprite OAKARRIBA2 = new Sprite(32, 2, 3, HojaSprites.oak);
    
    public static final Sprite OAKIZQUIERDA0 = new Sprite(32, 0, 2, HojaSprites.oak);
    public static final Sprite OAKIZQUIERDA1 = new Sprite(32, 1, 2, HojaSprites.oak);
    public static final Sprite OAKIZQUIERDA2 = new Sprite(32, 2, 2, HojaSprites.oak);
    
    public static final Sprite OAKDERECHA0 = new Sprite(32, 0, 1, HojaSprites.oak);
    public static final Sprite OAKDERECHA1 = new Sprite(32, 1, 1, HojaSprites.oak);
    public static final Sprite OAKDERECHA2 = new Sprite(32, 2, 1, HojaSprites.oak);
    
    
    //fin de la coleccion
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
        this.lado = lado;
        
        pixeles = new int[lado * lado];
        
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        
        for(int y = 0; y < lado; y++){
            for(int x = 0; x < lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }
    
    public Sprite(final int lado, final int color){
    	this.lado = lado;
    	pixeles = new int[lado * lado];
    	for(int i = 0; i < pixeles.length; i++){
    		pixeles[i] = color;
    	}
    	
    }

	public int getLado() {
		return lado;
	}
}
