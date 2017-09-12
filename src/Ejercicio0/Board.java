/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Board extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEscenario(g);
    }

    private void dibujarEscenario(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        //the first two parameters are the position (x,y) and after comes the width and the height
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
               
        g2d.fillRect(50, 0, 30, 30); 
        g2d.drawRect(50, 50, 30, 30);
        
        g2d.drawString("Puntaje del Juego", 100, 100);
        
    }
}