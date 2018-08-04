package jvfire;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Huy Tran
 */
public class FireworksColors {
    
    private static Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE};
    
    private static Random random = new Random();
    
    public static Color getRandomColor(){
        return colors[random.nextInt(colors.length)];
    }
    
}
