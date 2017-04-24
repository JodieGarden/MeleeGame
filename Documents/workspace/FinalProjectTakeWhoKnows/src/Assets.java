import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int widthLarge = 513,  heightLarge = 257;
	private static final int widthSmall = 34, heightSmall = 42;
	
	public static BufferedImage sandBackground, fireBackground, stoneBackground;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Gameboy.png"));
	sandBackground = sheet.crop(0, 0, widthSmall, heightSmall);
//	fireBackground = sheet.crop(widthLarge, 0, widthLarge, heightLarge);
//	stoneBackground = sheet.crop(widthLarge*2, heightLarge*2, widthSmall, heightSmall);
	}
}
