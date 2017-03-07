/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package custom;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author novalkrnfds
 */
public class PanelGradient extends javax.swing.JPanel{
    public PanelGradient(){        
        //setBackground(Color.blue);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        GradientPaint redToWhite = new GradientPaint(0,0,new Color(80,175,175), this.getWidth()-(this.getWidth()/6), this.getHeight(), new Color(204,204,255));
        g2.setPaint(redToWhite);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    }    

}
