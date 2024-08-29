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
        mapTileNum = new int[gamePanel.maxWorldCols][gamePanel.maxWorldRows];
        getTileImage();
        loadMap("/maps/world01.txt");
    }

    public void loadMap(String filePath){
        try {
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row;

            while (col < gamePanel.maxWorldCols){
                String line = bufferedReader.readLine();
                String[] tokens = line.split(" ");

                row = 0;
                for (String token : tokens) {
                    mapTileNum[col][row] = Integer.parseInt(token);
                    row++;
                }
                col++;
            }
        }catch (Exception e){
        	e.printStackTrace();
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
    	int worldCol = 0;
		int worldRow = 0;

        // Fill the screen with tile 0(grass)
		while(worldCol < gamePanel.maxWorldCols && worldRow < gamePanel.maxWorldRows) {
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gamePanel.TILE_SIZE;
			int worldY = worldRow * gamePanel.TILE_SIZE;
			int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
			int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
			
			g.drawImage(tiles[tileNum].sprite, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
			worldCol++;

			if(worldCol == gamePanel.maxWorldCols) {
				worldCol = 0;
				worldRow++;
			}
		}
    }
}
