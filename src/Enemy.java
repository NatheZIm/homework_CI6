import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;
    public Player player;

    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run(int playerX, int playerY) {
        this.x += this.velocityX;
        this.y += this.velocityY;

        if (this.x >= 1024) {
            this.x = 0;
        }
        else if (this.x <= 0) {
            this.x = 1024;
        }
        if (this.y >= 600){
            this.y = 0;
        }
        else if (this.y <= 0) {
            this.y = 600;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}