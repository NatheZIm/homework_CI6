
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long LastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600); //setsize of the window
        this.setupGameCanvas();
        this.event();
        this.setVisible(true); //display
    }


    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                gameCanvas.player.run();
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.x -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.x += 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gameCanvas.player.y -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.player.y += 5;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private void windownEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    private void event() {
        this.keyboardEvent();
        this.windownEvent();
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.LastTime >= 17__000__000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.LastTime = currentTime;
            }
        }
    }
}