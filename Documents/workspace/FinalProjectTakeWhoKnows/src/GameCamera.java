
public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler,float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	
	}
	
	public void checkBlankSpace(){
		if(xOffset <0){
			xOffset = 0;
			}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
				xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
			}
		if(yOffset < 0){
			yOffset = 0;
		} else if( yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getWidth()){
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getWidth();
		}
	}
	
	public void centerOnEntity(Entity entity){
		xOffset = entity.getX() - handler.getWidth()/2 + entity.width/2;
		yOffset = entity.getY() - handler.getHeight()/2 + entity.width/2; 
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
		
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
}

