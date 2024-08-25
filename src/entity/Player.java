package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update(){
        // Remember that the origin (0,0) is at the top left corner of the screen

        // Player movement
        if (keyHandler.upPressed) {
            y -= speed;
        }
        if (keyHandler.downPressed) {
            y += speed;
        }
        if (keyHandler.leftPressed) {
            x -= speed;
        }
        if (keyHandler.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);// Draw a rectangle.
    }
}
