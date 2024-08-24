import javax.swing.*;
import java.awt.*;

/**
 * It's the games screen, where the game will be displayed.
 */
public class GamePanel extends JPanel implements Runnable{

    // SCREEM SETTINGS
    /**
     * <p>The default size of player caracter, npcs, mobs, etc.</p>
     * <p>16x16 is kind of a standard size for many retro 2D games and many characters and tiles are made to fit this size.</p>
     * <p>Some games use 32x32 or 64x64, but 16x16 is a good start.</p>
     */
    final int originalTileSize = 16; // 16x16 pixels
    /**
     * <p>Since the resolution of current screens are much higher than the old ones, it is necessary to increase the size of the sprites so that they do not become tiny.</p>
     * <p>This is common in the development of retro 2D games, where sprites are increased to fit the current resolution.</p>
     */
    final int scale = 3; // 3x scale

    /**
     * <p>Final size of the sprite.</p>
     * <p>It is the original size of the sprite multiplied by the scale.</p>
     */
    final int tileSize = originalTileSize * scale; // 16x16 * 3 = 48x48 pixels
    /**
     * <p>Maximum number of columns that the screen can have.</p>
     * <p>It is the width of the screen divided by the size of the sprite.</p>
     */
    final int maxScreenCols = 16; // 16 columns
    /**
     * <p>Maximum number of rows that the screen can have.</p>
     * <p>It is the height of the screen divided by the size of the sprite.</p>
     */
    final int maxScreenRows = 12; // 12 rows
    /**
     * <p>Final width of the screen.</p>
     * <p>It is the size of the sprite multiplied by the maximum number of columns that the screen can have.</p>
     * No momento o tamanho da tela é 768x576 pixels. (48x16 * 48x12). Deixando a tela em uma escala de 4x3.
     * <p>In this case, the screen size is 768x576 pixels. (48x16 * 48x12). Leaving the screen in a 4x3 scale.</p>
     */
    final int screenWidth = tileSize * maxScreenCols; // 48 * 16 = 768 pixels
    /**
     * <p>Final width of the screen.</p>
     * <p>It is the size of the sprite multiplied by the maximum number of columns that the screen can have.</p>
     * No momento o tamanho da tela é 768x576 pixels. (48x16 * 48x12). Deixando a tela em uma escala de 4x3.
     * <p>In this case, the screen size is 768x576 pixels. (48x16 * 48x12). Leaving the screen in a 4x3 scale.</p>
     */
    final int screenHeight = tileSize * maxScreenRows; // 48 * 12 = 576 pixels

    /**
     * <p>Thread that will run the game loop.</p>
     */
    Thread gameThread;

    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setDoubleBuffered(true);// If true, all drawing will be done in the offscreen image buffer. The buffer will then be copied to the screen. This can reduce flicker and improve performance.
    }

    /**
     * <p>Starts the game loop.</p>
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();// Start the game loop automatically calling the run method
    }

    @Override
    public void run() {

    }
}
