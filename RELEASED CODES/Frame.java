/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvfire;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Huy Tran
 */
public class Frame extends JFrame {

    public static void main(String[] args) {
        new Frame();
    }

    public Frame() {
        new Screen(this);
        this.setTitle("Firework");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setVisible(true);
        
        
    }
}
