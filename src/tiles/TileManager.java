package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    /**
     * The types of frames that can be used. The size of the array is 10, but it can be increased as needed.
     */
    Tile[] tiles;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tiles = new Tile[6];
        mapTileNum = new int[gamePanel.maxWorldRows][gamePanel.maxWorldCols];
        getTileImage();
        loadMap("/maps/world01.txt");
    }

    public void loadMap(String filePath){
        try {
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col;
            int row = 0;

            while (row < gamePanel.maxWorldRows){
                String line = bufferedReader.readLine();
                String[] tokens = line.split(" ");

                col = 0;
                for (String token : tokens) {
                    mapTileNum[row][col] = Integer.parseInt(token);
                    col++;
                }
                row++;
            }
        }catch (Exception e){

        }
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

        // Fill the screen with tile 0(grass)
        while (col < gamePanel.MAX_SCREEN_COLS && row < gamePanel.MAX_SCREEN_ROWS){
            g.drawImage(tiles[mapTileNum[row][col]].sprite, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            col++;

            if (x >= gamePanel.SCREEN_WIDTH){
                x = 0;
                y += gamePanel.TILE_SIZE;
                row++;
                col = 0;
            }
        }
    }
}
