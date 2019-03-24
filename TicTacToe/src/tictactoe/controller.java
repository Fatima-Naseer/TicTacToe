/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
/**
 *
 * @author Fatima
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class controller implements ActionListener{
        private controller c;
	private view v;
	private model m;
	
	public void Model(model m) {
		this.m = m;
	}
	
	public void set(ArrayList<Integer> a) {
		m.Move(a.get(0), a.get(1));
	}
	
	public void setRequest() {
		m.ResetModel();
	}
        
    public void actionPerformed(ActionEvent e) {
    		// button press action
    		if(v.check(e))
    			c.setRequest();
    		else {
    			ArrayList<Integer> x = v.getLoc(e);
    			c.set(x);
    		}
    }
	
}
