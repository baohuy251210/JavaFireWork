package jvfire;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Random;

/**
 *
 * @author Huy Tran
 */
public class Firework {

    public Sparcle[] sparcles;
    public Random random = new Random();
    public Toolkit toolkit = Toolkit.getDefaultToolkit();

    public boolean dead;
    public boolean exploded;

    public int fuse;

    public int x;
    public int y;

    public Firework() {
        this.fuse = random.nextInt(100);

        this.x = random.nextInt(toolkit.getScreenSize().width - 300) + 150;
        this.y = random.nextInt(toolkit.getScreenSize().height - 300) + 150;

        this.sparcles = new Sparcle[100];

       
    }

    public void explode() {
        Color color = FireworksColors.getRandomColor();

        for (int i = 0; i < sparcles.length; i++) {
            sparcles[i] = new Sparcle(x, y);
            this.sparcles[i].color = color;
        }
        this.exploded = true;
    }

    public void update() {
        if (this.exploded) {
            int amountDeads = 0;

            for (int i = 0; i < sparcles.length; i++) {
                if (sparcles[i] != null) {
                    sparcles[i].update();

                    if (this.sparcles[i].dead) {
                        this.sparcles[i] = null;
                    }
                } else {
                    amountDeads++;
                }
            }

            if (amountDeads == this.sparcles.length) {
                this.dead = true;
            }
        }else {
            this.fuse--;
            
            if (this.fuse <= 0){
                explode();
            }
        }
    }
}
