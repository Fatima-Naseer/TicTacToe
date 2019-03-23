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
public class TicTacToe {
    public static void main(String[] args) {                                  
        controller c = new controller();  
    	view v = new view();   
        model m = new model();    
        m.View(v);
        c.Model(m);
        v.setListener(c);
    }                                                                            
}
