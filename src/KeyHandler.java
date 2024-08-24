import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();// Returns the integer keyCode associated with the key in this event.

        if (code == KeyEvent.VK_W) {
            System.out.println("W key pressed");
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            System.out.println("A key pressed");
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            System.out.println("S key pressed");
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            System.out.println("D key pressed");
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            System.out.println("W key released");
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            System.out.println("A key released");
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            System.out.println("S key released");
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            System.out.println("D key released");
            rightPressed = false;
        }
    }
}
