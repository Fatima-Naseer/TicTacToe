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
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class view {
    private Listener i;
    private JFrame gui;
    private JButton[][] grid;
    private JButton reset;
    private JLabel l1;
    private JTextField a1;
   

    public view() {
    		this.gui = new JFrame("Tic Tac Toe");
    		this.grid = new JButton[3][3];
    		this.reset = new JButton("Press to Reset");
                this.reset.setBackground(Color.lightGray);
                this.l1 = new JLabel("'X' for Player 1 & 'O' for Player 2");
                this.a1= new JTextField("Fatima Naseer here!");
                
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setSize(new Dimension(600, 450));
                gui.setResizable(true);

                JPanel gamePanel = new JPanel(new FlowLayout());
                JPanel game = new JPanel(new GridLayout(3,3));
                gamePanel.add(game, BorderLayout.CENTER);
                JPanel options = new JPanel(new FlowLayout());
                options.add(reset);

                JPanel messages = new JPanel(new FlowLayout());
                l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 0, 0)));
                messages.add(this.l1);
                
                a1.setEditable(false);
                a1.setBackground(Color.lightGray);
                gui.add(this.a1, BorderLayout.EAST);
                gui.add(gamePanel, BorderLayout.NORTH);
                gui.add(options, BorderLayout.CENTER);
                gui.add(messages, BorderLayout.PAGE_END);
                int a=0;
                while(a<3){
                        for(int b = 0; b<3 ; b++) {
                            grid[a][b] = new JButton();
                            grid[a][b].setPreferredSize(new Dimension(100,100));
                            grid[a][b].setBackground(Color.DARK_GRAY);
                            game.add(grid[a][b]);
                        }
                        a++;
                    }
                gui.setVisible(true);
    }
    
    public String getButtonText(int i, int j) {
    		return grid[i][j].getText();
    }
     

    public boolean check(ActionEvent e) {
    		if(e.getSource() == reset)
                {
    			return true;
                }
    		return false;
    }
    
    public ArrayList<Integer> getLoc(ActionEvent e) {
    	ArrayList<Integer> index = new ArrayList<Integer>();
    	for(int x = 0; x<3 ; x++) {
	        for(int y = 0; y<3 ; y++) {
	        		if(e.getSource() == grid[x][y]) {
	        			index.add(x);
	        			index.add(y);
	        		}
	        }
    		}
    		return index;
    }
    
    public void checkWinner(int x, int y, char n) {
		grid[x][y].setText(Character.toString(n));
		grid[x][y].setEnabled(false);
		for(int i = 0; i<3 ; i++) {
	        for(int j = 0; j<3 ; j++) {
	        	grid[i][j].setEnabled(false);
	        }
		}

    }
   
    public void resetting() {
        int a=0;
    	while(a<3){
            for(int b = 0; b<3; b++) {
                grid[a][b].setText("");
                grid[a][b].setEnabled(true);
            }
            a++;
        }
    }
    
    public void update(int x, int y, char symbol) {
    		grid[x][y].setText(Character.toString(symbol));
    		grid[x][y].setEnabled(false); 	
    }
    
     public void setListener(controller c) {
		this.i = new Listener(c,this);
                int a=0;
                while(a<3){
                    for(int b = 0; b<3 ; b++) 
                    {
                        grid[a][b].addActionListener(i);
                    }
                    a++;
		}
	    reset.addActionListener(i);
    }
   
}
