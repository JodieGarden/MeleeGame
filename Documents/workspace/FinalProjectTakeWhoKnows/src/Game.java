import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {
    
    private static int x = 0;

	private Display display;
    
    public int width;
    public int height;
    public String title;
    
    private boolean running = false;
    
    private Thread thread;
    
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    
    //States
    private State gameState;
    private State menuState;
    
    private KeyManager keyManager;
    
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();

         
    
        
    }
    
    private void init(){
       display = new Display(title, width, height);
       display.getFrame().addKeyListener(keyManager);
       Assets.init();
       gameState = new GameState(this);
       menuState = new MenuState(this);
       State.setState(gameState);
       
       }
    
    private void update(){
    	keyManager.tick();
    	
    	if(State.getState() != null)
    		State.getState().tick();
    	
    }
    
    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy(); 
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        //Clear Screen
        graphics.clearRect(0, 0, width, height);
        //Draw here
        if(State.getState() != null)
    		State.getState().render(graphics);
    	
        
        //End Drawing
        bufferStrategy.show();
        graphics.dispose();
    }
    
    
    
    public void run(){
        
        init();
         
        int framesPerSecond = 60;
        double timePerUpdate = 1000000000/framesPerSecond;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running){
        	now = System.nanoTime();
        	delta += (now - lastTime)/ timePerUpdate;
        	timer += now - lastTime;
        	lastTime = now;
        	
        	if(delta >= 1){
        	
            update();
            render();
            ticks++;
            delta--;
        	}
        	if(timer >= 1000000000){
        		System.out.println("Ticks and Frames: " + ticks);
        		ticks = 0;
        		timer = 0; 
        		
        	}
        }
        
        stop();
        
    }
    
    public KeyManager getKeyManager(){
    	return keyManager;
    }
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
