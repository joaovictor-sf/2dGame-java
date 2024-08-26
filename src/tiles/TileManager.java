package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gamePanel;
    /**
     * The types of frames that can be used. The size of the array is 10, but it can be increased as needed.
     */
    Tile[] tiles;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tiles = new Tile[3];
        getTileImage();
    }

    public void getTileImage(){
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile();
            try {
                tiles[i].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_" + i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        // Fill the screen with tile 0(grass)
        while (col < gamePanel.MAX_SCREEN_COLS && row < gamePanel.MAX_SCREEN_ROWS){
            g.drawImage(tiles[0].sprite, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            col++;
            x += gamePanel.TILE_SIZE;

            if (col == gamePanel.MAX_SCREEN_COLS){
                col = 0;
                row++;
                x = 0;
                y += gamePanel.TILE_SIZE;
            }
        }
    }
}
