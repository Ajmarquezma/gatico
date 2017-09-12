/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Board extends JPanel implements ActionListener {

    private final int delay = 40;
    private int x_ref = 10;
    private int x_ref2 = 150;
    private int xGato =0;
    private int numImagen = 0;

    private Timer timer;

    public Board() {
        timer = new Timer(this.delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
        g.setColor(Color.RED);
        int x1[] = {x_ref, x_ref + 10, x_ref + 20, x_ref + 30};
        int y1[] = {420, 410, 410, 420};
        g.drawPolygon(x1, y1, 4);
        g.fillRect(x_ref - 10, 420, 50, 10);
        g.fillOval(x_ref, 430, 10, 10);
        g.fillOval(x_ref + 20, 430, 10, 10);
        g.drawRect(x_ref - 10, 410, 50, 30);

        g.setColor(Color.pink);
        int x2[] = {x_ref2, x_ref2 + 10, x_ref2 + 20, x_ref2 + 30};
        int y2[] = {420, 410, 410, 420};
        g.drawPolygon(x2, y2, 4);
        g.fillRect(x_ref2 - 10, 420, 50, 10);
        g.fillOval(x_ref2, 430, 10, 10);
        g.fillOval(x_ref2 + 20, 430, 10, 10);
        g.drawRect(x_ref2 - 10, 410, 50, 30);

        Rectangle carro1 = new Rectangle(x_ref - 10, 10, 30, 30);
        Rectangle carro2 = new Rectangle(x_ref2 - 33, 10, 30, 30);
        if (carro1.intersects(carro2)) {
            this.timer.stop();
        }
        Image gato= loadImage("cats.gif");
        g.drawImage(gato, this.xGato, 100, (this.xGato+132),(100+80),(this.numImagen*132),0,(this.numImagen*132)+132,80,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x_ref += 1;
        this.x_ref2 -= 1;
        this.xGato ++;
        if(this.numImagen<=5){
            this.numImagen++;            
        }else{
            this.numImagen =0;
        }

        repaint();
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
