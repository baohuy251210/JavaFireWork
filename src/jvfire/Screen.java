package jvfire;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Huy Tran
 */
public class Screen implements Runnable {

    int x;
    Image img;

    private JPanel jpanel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            

            g.drawImage(img, 0, 0, null);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setBackground(Color.BLACK);
            g.clearRect(0, 0, frame.getWidth(), frame.getHeight());

            for (int i = 0; i < fireworks.length; i++) {
                if (fireworks[i] != null) {
                    for (int j = 0; j < fireworks[i].sparcles.length; j++) {
                        if (fireworks[i].sparcles[j] != null) {
                            g.setColor(fireworks[i].sparcles[j].color);
                            g.drawLine((int) fireworks[i].sparcles[j].x, (int) fireworks[i].sparcles[j].y, (int) fireworks[i].sparcles[j].x, (int) fireworks[i].sparcles[j].y);
                            
                        }
                    }
                }
            }
        }
    };

    private TimerTask task = new TimerTask() {
        public void run() {
            if (isRunning) {
                img = Toolkit.getDefaultToolkit().createImage("CityNight.jpg");
                jpanel.repaint();
                update();
            } else {
                System.exit(0);
            }
        }
    };

    Thread thread = new Thread(this);
    Timer timer = new Timer();
    Firework[] fireworks = new Firework[50];
    private int refRate = 30;

    private boolean isRunning;

    private Frame frame;

    public Screen(Frame frame) {
        isRunning = true;

        this.frame = frame;
        frame.add(jpanel);

        thread.start();
    }

    public void update() {
        for (int i = 0; i < fireworks.length; i++) {
            if (fireworks[i] == null) {
                fireworks[i] = new Firework();

            }
            fireworks[i].update();

            if (fireworks[i].dead) {
                fireworks[i] = null;
            }
        }
    }

    public void run() {
        timer.scheduleAtFixedRate(task, 0, 1000 / this.refRate);
    }

}
