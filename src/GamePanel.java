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
    final int ORIGINAL_TILE_SIZE = 16; // 16x16 pixels
    /**
     * <p>Since the resolution of current screens are much higher than the old ones, it is necessary to increase the size of the sprites so that they do not become tiny.</p>
     * <p>This is common in the development of retro 2D games, where sprites are increased to fit the current resolution.</p>
     */
    final int SCALE = 3; // 3x scale

    /**
     * <p>Final size of the sprite.</p>
     * <p>It is the original size of the sprite multiplied by the scale.</p>
     */
    final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 16x16 * 3 = 48x48 pixels
    /**
     * <p>Maximum number of columns that the screen can have.</p>
     * <p>It is the width of the screen divided by the size of the sprite.</p>
     */
    final int MAX_SCREEN_COLS = 16; // 16 columns
    /**
     * <p>Maximum number of rows that the screen can have.</p>
     * <p>It is the height of the screen divided by the size of the sprite.</p>
     */
    final int MAX_SCREEN_ROWS = 12; // 12 rows
    /**
     * <p>Final width of the screen.</p>
     * <p>It is the size of the sprite multiplied by the maximum number of columns that the screen can have.</p>
     * No momento o tamanho da tela é 768x576 pixels. (48x16 * 48x12). Deixando a tela em uma escala de 4x3.
     * <p>In this case, the screen size is 768x576 pixels. (48x16 * 48x12). Leaving the screen in a 4x3 scale.</p>
     */
    final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COLS; // 48 * 16 = 768 pixels
    /**
     * <p>Final width of the screen.</p>
     * <p>It is the size of the sprite multiplied by the maximum number of columns that the screen can have.</p>
     * No momento o tamanho da tela é 768x576 pixels. (48x16 * 48x12). Deixando a tela em uma escala de 4x3.
     * <p>In this case, the screen size is 768x576 pixels. (48x16 * 48x12). Leaving the screen in a 4x3 scale.</p>
     */
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROWS; // 48 * 12 = 576 pixels

    // FPS
    final int FPS = 60;

    /**
     * <p>Thread that will run the game loop.</p>
     */
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    // Player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setDoubleBuffered(true);// If true, all drawing will be done in the offscreen image buffer. The buffer will then be copied to the screen. This can reduce flicker and improve performance.
        setFocusable(true);// With this, the panel will be able to receive the focus
        addKeyListener(keyHandler);
    }

    /**
     * <p>Starts the game loop.</p>
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();// Start the game loop automatically calling the run method
    }

    public void run(){
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        // Remember that the origin (0,0) is at the top left corner of the screen

        // Player movement
        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        }
        if (keyHandler.downPressed) {
            playerY += playerSpeed;
        }
        if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // this is a method from JPanel

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);// Draw a rectangle.
        g2.dispose();// Disposes of this graphics context and releases any system resources that it is using.
    }
}
