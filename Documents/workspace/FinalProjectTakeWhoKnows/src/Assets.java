import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int widthLarge = 400;
	private static final int widthB = 167, heightB = 85;
	private static final int widthSmall = 34, heightSmall = 42;
	
	public static BufferedImage  fireBackground, stoneBackground, otherBackground;
	public static BufferedImage[] player_stand, player_left, player_right;
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Gameboy.png"));
//	playerGoku = sheet.crop(0, 0, widthSmall, heightSmall);
		player_stand = new BufferedImage[8];
		
		player_stand[0] = sheet.crop(0, 0, widthSmall, heightSmall);
		player_stand[1] = sheet.crop(33, 0, widthSmall, heightSmall);
		player_stand[2] = sheet.crop(66, 0, widthSmall, heightSmall);
		player_stand[3] = sheet.crop(99, 0, widthSmall, heightSmall);
		player_stand[4] = sheet.crop(132, 0, widthSmall, heightSmall);
		player_stand[5] = sheet.crop(165, 0, widthSmall, heightSmall);
		player_stand[6] = sheet.crop(198, 0, widthSmall, heightSmall);
		player_stand[7] = sheet.crop(231, 0, widthSmall, heightSmall);
		
		player_left = new BufferedImage[8];
		
		player_left[0] =sheet.crop(0, 87, widthSmall, heightSmall);
		player_left[1] =sheet.crop(33, 87, widthSmall, heightSmall);
		player_left[2] =sheet.crop(66, 87, widthSmall, heightSmall);
		player_left[3] =sheet.crop(99, 87, widthSmall, heightSmall);
		player_left[4] =sheet.crop(132, 87, widthSmall, heightSmall);
		player_left[5] =sheet.crop(165, 87, widthSmall, heightSmall);
		player_left[6] =sheet.crop(198, 87, widthSmall, heightSmall);
		player_left[7] =sheet.crop(231, 87, widthSmall, heightSmall);
		
		player_right = new BufferedImage[1];
		player_right[0] = sheet.crop(0, 87*18, widthSmall, heightSmall);
		
	fireBackground = sheet.crop(widthLarge, 85, widthB, heightB );
	stoneBackground = sheet.crop(401 , 340, 167, 85);
	otherBackground = sheet.crop(501, 440, 267, 185);
	}
}
