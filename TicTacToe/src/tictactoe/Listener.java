/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author Fatima
 */
public class Listener implements ActionListener {
	private controller c;
	private view v;
	
    public Listener(controller c, view v) {
        this.c = c;
        this.v = v;
    }

    public void actionPerformed(ActionEvent e) {
    		if(v.check(e))
    			c.setRequest();
    		else {
    			ArrayList<Integer> m = v.getLoc(e);
    			c.set(m);
    		}
    }

}

