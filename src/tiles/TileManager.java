package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The TileManager class is responsible for loading the tile images and drawing them on the screen.
 * It also loads the map from a text file and stores the tile numbers in a 2D array.
 */
public class TileManager {
    /**
     * The GamePanel object.
     */
    GamePanel gamePanel;
    /**
     * The types of frames that can be used. The size of the array is 10, but it can be increased as needed.
     */
    public Tile[] tiles;
    /**
     * A 2D array that stores the tile numbers of the map.
     */
    public int mapTileNum[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tiles = new Tile[6];
        mapTileNum = new int[gamePanel.maxWorldCols][gamePanel.maxWorldRows];
        getTileImage();
        loadMap("/maps/world01.txt");
    }

    /**
     * Loads the map from a text file and stores the tile numbers in a 2D array.
     * @param filePath The path of the text file.
     */
    public void loadMap(String filePath){
        try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while(col < gamePanel.maxWorldCols && row < gamePanel.maxWorldRows) {
				String line = br.readLine();

				String numbers[] = line.split(" ");

				while(col < gamePanel.maxWorldCols) {
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}

				if(col == gamePanel.maxWorldCols) {
					col = 0;
					row++;
				}
			}

			br.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
        /*try {
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
        }*/
    }

    /**
     * Loads the tile images from the resources folder.
     */
    public void getTileImage(){
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile();
            try {
                tiles[i].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_" + i + ".png"));
                if(i == 1 || i == 2 || i == 4){
                    tiles[i].collision = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Draws the tiles on the screen.
     * @param g The Graphics2D object.
     */
    public void draw(Graphics2D g){
    	int worldCol = 0;
		int worldRow = 0;
        int tileNum;
        int worldX;
        int worldY;
        int screenX;
        int screenY;

        // Fill the screen with tile 0(grass)
		while(worldCol < gamePanel.maxWorldCols && worldRow < gamePanel.maxWorldRows) {
			tileNum = mapTileNum[worldCol][worldRow];
			
			worldX = worldCol * gamePanel.TILE_SIZE;
			worldY = worldRow * gamePanel.TILE_SIZE;
			screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
			screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
			
			g.drawImage(tiles[tileNum].sprite, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
			worldCol++;

			if(worldCol == gamePanel.maxWorldCols) {
				worldCol = 0;
				worldRow++;
			}
		}
    }
}
