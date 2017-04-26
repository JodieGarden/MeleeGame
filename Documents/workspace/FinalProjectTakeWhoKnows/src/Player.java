import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Creature {
	
	private Animation animationStand, animationLeft, animationRight;
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		
		animationStand = new Animation(100, Assets.player_stand);
		animationLeft = new Animation(100, Assets.player_left);
		animationRight = new Animation(100, Assets.player_right);
	}

	@Override
	public void tick() {
		animationStand.tick();
		animationLeft.tick();
		animationRight.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
		yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height , null);
		
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animationRight.getCurrentFrame();
			
		}else if(xMove > 0){
			return animationLeft.getCurrentFrame();
		}else if(yMove < 0){
			return animationStand.getCurrentFrame();
		}else
			return animationStand.getCurrentFrame();
	}

}
