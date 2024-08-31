package entities;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The player class.
 */
public class Player extends Entity{
    /**
     * <p>The player class will receive the gamePanel and the keyHandler.</p>
     * <p>With the interaction of the Player, the GamePanel will be smaller and more organized.</p>
     */
    GamePanel gamePanel;
    /**
     * <p>Keys pressed by the player.</p>
     */
    KeyHandler keyHandler;

    /**
     * <p>Player's position in the screen.</p>
     */
    public final int screenX;
    /**
     * <p>Player's position in the screen.</p>
     */
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.SCREEN_WIDTH/2 - (gamePanel.TILE_SIZE/2);
        screenY = gamePanel.SCREEN_HEIGHT/2 - (gamePanel.TILE_SIZE/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = gamePanel.TILE_SIZE - 16;// 48 - 16 = 32
        solidArea.height = gamePanel.TILE_SIZE - 16;
        System.out.println(solidArea.getSize());

        setDefaultValues();
        getPlayerImage();
    }

    /**
     * <p>Set the default values of the player.</p>
     * <p>Default values: x = 100, y = 100, speed = 4.</p>
     */
    public void setDefaultValues(){
        worldX = gamePanel.TILE_SIZE * 21;
        worldY = gamePanel.TILE_SIZE * 23;
        speed = 4;
        direction = "down";
    }

    /**
     * <p>Get the images from the player folder and put them in the variables:</p> <p>up1, up2, down1, down2, left1, left2, right1, right2.</p>
     */
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Update the player's position.</p>
     */
    public void update(){
        // Remember that the origin (0,0) is at the top left corner of the screen

        isMoving = false;

        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            isMoving = true;

            // Player movement
            if (keyHandler.upPressed) {
                direction = "up";
            } else if (keyHandler.downPressed) {
                direction = "down";
            } else if (keyHandler.leftPressed) {
                direction = "left";
            } else if (keyHandler.rightPressed) {
                direction = "right";
            }

            // Collision check
            collision = false;
            gamePanel.collisionChecker.checkTile(this);

            // if collision is false, the player can move
            if (!collision) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            // Player animation
            animationDelay++;
            if (animationDelay == 8) {
                animationDelay = 0;
                spriteVersion = (spriteVersion == 1) ? 2 : 1;
            }
        }
    }

    /**
     * <p>Draw the player on the screen.</p>
     * @param g2 Graphics2D object
     */
    public void draw(Graphics2D g2){
        //g2.setColor(Color.BLACK);
        //g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);// Draw a rectangle.

        BufferedImage image = null;

        switch (direction){
            case "up":
                image = spriteVersion == 1 ? up1 : up2;
                break;
            case "down":
                image = spriteVersion == 1 ? down1 : down2;
                break;
            case "left":
                image = isMoving ? (spriteVersion == 1 ? left1 : left2) : left1;
                break;
            case "right":
                image = isMoving ? (spriteVersion == 1 ? right1 : right2) : right1;
                break;
        }
        g2.drawImage(image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
    }
}
