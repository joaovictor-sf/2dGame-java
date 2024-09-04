package objetos;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Key extends SuperObject{
    public Obj_Key() {
        this.name = "key";
        this.isSolid = false;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("/obj_assets/key.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
