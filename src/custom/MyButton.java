/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package custom;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ahza
 */
public class MyButton extends JButton {

    public void setActionListener(ActionListener actionListener) {
        ActionListener[] al = getActionListeners();
        for(int i=0;i<al.length;i++){
            removeActionListener(al[i]);
        }
        this.addActionListener(actionListener);
    }
    

}
