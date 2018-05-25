import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
    private Random random = new Random();
    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velo_X;
    public int velo_Y;

    public Player(BufferedImage image, int x, int y, int width, int height, int velo_X, int velo_Y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velo_X = velo_X;
        this.velo_Y = velo_Y;
    }

    public void run() {
        if (this.x > 1024) {
            this.x = 0;
            this.y = random.nextInt(600);
        }

        if (this.x < -1) {
            this.x = 1024;
            this.y = random.nextInt(600);

        }

        if (this.y >= 600) {
            this.y = 0;
            this.x = random.nextInt(1024);

        }

        if (this.y <= 0) {
            this.y = 600;
            this.x = random.nextInt(1024);


        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}