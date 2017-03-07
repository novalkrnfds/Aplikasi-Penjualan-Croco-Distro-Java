/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package custom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author novalkrnfds
 */
public class background extends JDesktopPane{
    Image gam;
    public background(){
        setOpaque(false);
        gam=new ImageIcon(getClass().getResource("bg.png")).getImage();
        repaint();
    }

    public void setGambar(String temp){
        setOpaque(false);
        gam=new ImageIcon(getClass().getResource(temp)).getImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg=(Graphics2D)g.create();
        gg.drawImage(gam, 0,0,getWidth(),getHeight(), null);
        gg.dispose();
    }


}
