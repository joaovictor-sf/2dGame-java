package entity;

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

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }

    /**
     * <p>Set the default values of the player.</p>
     * <p>Default values: x = 100, y = 100, speed = 4.</p>
     */
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

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

        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            // Player movement
            if (keyHandler.upPressed) {
                y -= speed;
                direction = "up";
            } else if (keyHandler.downPressed) {
                y += speed;
                direction = "down";
            } else if (keyHandler.leftPressed) {
                x -= speed;
                direction = "left";
            } else if (keyHandler.rightPressed) {
                x += speed;
                direction = "right";
            }

            // Player animation
            spriteCount++;
            if (spriteCount == 10) {
                spriteCount = 0;
                spriteNum = (spriteNum == 1) ? 2 : 1;
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
                if (spriteNum == 1){
                    image = up1;
                }
                else{
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                else{
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                else{
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                else{
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
    }
}
