package entities;

import java.awt.image.BufferedImage;

/**
 * It is a good practice to have an Entity class that will be the superclass of all entities in the game.
 */
public class Entity {
    /**
     * <p>Position of the entity on the screen.</p>
     */
    public int worldX, worldY;
    /**
     * <p>Speed of the entity.</p>
     */
    public int speed;

    /**
     * <p>Images for the entity.</p>
     */
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;// It describes an image with an accessible buffer of image data.
    /**
     * <p>Direction of the entity.</p>
     */
    public String direction;

    /**
     * A variável animationDelay é usada para controlar a animação. Ela é incrementada a cada atualização (update) e, quando atinge um determinado valor, é redefinida para 0. Isso alterna o valor de spriteVersion entre 1 e 2, o que, por sua vez, alterna a imagem do sprite do jogador entre duas imagens diferentes (up1 e up2, down1 e down2, etc.), criando um efeito de animação.
     */
    public int animationDelay = 0;
    /**
     * É a versão atual do sprite da entidade. Sempre que a animação é atualizada, spriteVersion é alternado.
     */
    public int spriteVersion = 1;
    /**
     * Boolean com o objetivo de verificar se a entidade está em movimento.
     */
    public boolean isMoving;
}
