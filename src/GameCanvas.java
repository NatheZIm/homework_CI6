
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {


    BufferedImage backBuffered;
    Graphics graphics;
    List<Star> stars;
    List<Enemy> enemies;
    public Player player;
    private Random random = new Random();
    private int starOnscreen = 0;
    private int EnemyOnscreen = 0;


    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupCharacter();
        this.setupBackBuffered();
        this.setVisible(true);
    }


    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }


    private void setupCharacter() {
        this.setupEnemies();
        this.setupPlayer();
        this.setupStar();
    }

    private void setupEnemies() {
        this.enemies = new ArrayList<>();
    }
    private void setupPlayer() {
        createPlayer();
    }
    private void setupStar() {
        this.stars = new ArrayList<>();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.renderBackground();
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
        this.repaint();
    }


    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }


    public void runAll() {
        createStar();
        this.stars.forEach(star -> star.run());
        createEnemies();
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();
    }


    private void createStar() {
        if (this.starOnscreen == 30) {
            Star star = new Star(
                    this.loadImage("resources/images/star.png"),
                    1024,
                    this.random.nextInt(600),
                    5,
                    5,
                    -(this.random.nextInt(3) + 1),
                    0
            );
            this.stars.add(star);
            this.starOnscreen = 0;
        }
        else {
            this.starOnscreen += 1;
        }
    }

    private void createEnemies() {
        if(this.EnemyOnscreen == 100) {
            Enemy enemy = new Enemy(
                    this.loadImage("resources/images/circle.png"),
                    this.random.nextInt(1024),
                    this.random.nextInt(600),
                    20,
                    20,
                    this.random.nextInt(5) - 3,
                    this.random.nextInt(5) - 3
            );
            // random từ âm tới dương

            //int dau = this.random.nextInt(2);
            //if (dau == 0) dau = -1;
            //else dau = 1 ;
            //int velocityX = dau * ( this.random.nextInt(4)+1);

            this.enemies.add(enemy);
            this.EnemyOnscreen = 0;
        }
        else {
            this.EnemyOnscreen += 1;
        }
    }


    public void createPlayer() {
        this.player = new Player(
                this.loadImage("resources/images/player_rocket.png"),
                500,
                200,
                50,
                50,
                10,
                10
        );
    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}