package jvfire;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Huy Tran
 */
public class Sparcle {

    float x;
    float y;

    float motionX;
    float motionY;

    float age;
    float maxAge;
    boolean dead;
    float speed;

    float speedFade;
    
    Random random = new Random();
    
    Color color;

    public Sparcle(float x, float y) {
        this.x = x;
        this.y = y;

        this.maxAge = 60F;
        
        this.speedFade = 0.99F;
        
        this.speed = random.nextFloat()*5 +1;

        this.color = FireworksColors.getRandomColor();
        
        this.motionX = (random.nextFloat() - 0.5F) * this.speed;
        this.motionY = (random.nextFloat() - 1F) * this.speed;
    }
    
    public void update(){
        this.x += this.motionX;
        this.y += this.motionY;
        
        this.motionX *= this.speedFade;
        this.motionY *= this.speedFade;
        this.motionY += 0.3F;
        
        this.age++;
        if (this.age >= this.maxAge){
            this.dead = true;
        }
    }
}
