package main;

import objetos.Obj_Key;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject(){
        gamePanel.objs[0] = new Obj_Key();
        gamePanel.objs[0].worldX = 23 * gamePanel.TILE_SIZE;
        gamePanel.objs[0].worldY = 7 * gamePanel.TILE_SIZE;

        gamePanel.objs[1] = new Obj_Key();
        gamePanel.objs[1].worldX = 23 * gamePanel.TILE_SIZE;
        gamePanel.objs[1].worldY = 40 * gamePanel.TILE_SIZE;
    }
}
