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
        for (int i = 0; i < tiles.length; i++) {
            g.drawImage(tiles[i].sprite, i * 60, 0, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
    }
}
