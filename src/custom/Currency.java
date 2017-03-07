/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom;

import java.text.NumberFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author novalkrnfds
 */
public class Currency extends DefaultTableCellRenderer{
    public Currency(){
        super();
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
    
    public void setValue(Object value){
        if((value != null) && (value instanceof Number)){
            Number numberValue = (Number) value;
            NumberFormat nf = NumberFormat.getNumberInstance();
            value = nf.format(numberValue.doubleValue());
        }
        super.setValue(value);
    }
}
