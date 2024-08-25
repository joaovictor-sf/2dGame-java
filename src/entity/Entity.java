package entity;

import java.awt.image.BufferedImage;

/**
 * It is a good practice to have an Entity class that will be the superclass of all entities in the game.
 */
public class Entity {
    /**
     * <p>Position of the entity on the screen.</p>
     */
    public int x, y;
    /**
     * <p>Speed of the entity.</p>
     */
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;// It describes an image with an accessible buffer of image data.
    public String direction;

    public int spriteCount = 0;
    public int spriteNum = 1;
}
