/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import javax.swing.JOptionPane;
/**
 *
 * @author Fatima
 */
public class model {
	private view v;
	private int playerId;
	private int count;
	private char[][] grid;
        private String message;

	public model() {
            this.count = 9;	
            this.grid = new char[3][3];
            this.playerId = 1;
	}
	
	public void View(view v) {
		this.v = v;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int movesCount) {
		this.count = movesCount;
	}
	//to play a move
	public void Move(int x, int y) {
		String win;
		if(getCount() > 0){
			if(playerId%2 != 0)
                        {
				grid[x][y] = 'X';
                        }
			else 
                        {
				grid[x][y] = 'O';
                        }
			setCount(--count);
                        //check for winner
			if(isWinner(x, y)) {
                                win="     Player "+playerId + " is Winner!\n"+" Press Reset to play agian!";
				v.checkWinner(x, y, grid[x][y]);
                                JOptionPane.showMessageDialog(null, win);
			}
			else if(getCount()==0) {
                                win="GAME OVER! It was a Tie";
				v.checkWinner(x, y, grid[x][y]);
                                JOptionPane.showMessageDialog(null, win);
			}
			else {
				if(playerId%2 != 0) {
					setPlayerId(2);
				}
				else {
					setPlayerId(1);
				}
				v.update(x, y, grid[x][y]);
			}		
                }	
	}
        
        public void ResetModel() {
		count = 9;
		setPlayerId(1);
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid.length;j++) {
				grid[i][j] = '\0';
			}
		}
		v.resetting();	
	}
        //check if any winner exists
	public boolean isWinner(int x, int y) {
		char n;
		if(getPlayerId() %2 !=0)
                {
			n = 'X';
                }
		else
                {
			n = 'O';
                }
                int r = 0, c = 0, a = 0,b = 0; //counts
		for(int i=0; i<grid.length;i++) {
			if(grid[x][i] == n){
				r=r+1;
                        }
			if(grid[i][y] == n){
				c=c+1;
                        }
			if(grid[i][i] == n){
				b=b+1;
                        }
			if(grid[grid.length-1-i][i] == n){
				a=a+1;	
                        }
		}	
		if(c==grid.length || r==grid.length || a == grid.length || b == grid.length)
                {	
                    return true;
                }
		return false;
	}
	
	
}
