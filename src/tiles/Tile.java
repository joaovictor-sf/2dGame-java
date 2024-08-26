package tiles;

import java.awt.image.BufferedImage;

/**
 * Uma tile é um bloco de um mapa que pode ser colidível ou não.
 * Cada tile possui um sprite que é a imagem que será renderizada na tela.
 */
public class Tile {
    /**
     * Sprite da tile.
     */
    public BufferedImage sprite;
    /**
     * Indica se a tile é colidível ou não.
     */
    public boolean collision;
}
