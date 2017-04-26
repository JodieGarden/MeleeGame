import java.awt.Graphics;

public class GameState extends State {
	
	private Player player;
	private World world;
	private Game game;
	

	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
		
		
	
	}
		
	@Override
	public void tick() {
		world.tick();
		player.tick();

		
	}

	@Override
	public void render(Graphics graphics) {
		world.render(graphics);
		player.render(graphics);
		
		
	}
	
	
}
