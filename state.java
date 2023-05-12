package Util;

import java.util.Arrays;

public class state {
	/*char[][]board;
	public int util;// 
		final int length =6;
		final int width = 7;
		// constructor
		state(){
			board = new char[length][width];// intiallize board
			for(int i =0 ; i<length ; i++)
				Arrays.fill(board[i], '_');// fill every coloum by space at start of game
		}
		//constructor
		public state(char[][]board , int util) {
			this.board=board;
			this.util=util;
		}
		
		public char[][]getBoard(){
			return board;
		}
}*/
	     char[][] board;
	    public int UtilValues;
	    final int length=6;
	    final int width=7;
	    state(){ //constructor
	       // intiallize board 
	        board=new char[length][width];
	        for(int i=0;i<length;i++)
	          // fill every coloum by space at start of game
	            Arrays.fill(board[i], '_');
	    }
	    
	    //constructor 

	    public state(char[][] board,int Utilvalues){
	        
	        this.board=board;
	   
	        this.UtilValues=Utilvalues;
	    }
//	    method to get board 
	    public char[][] getBoard(){
	        return board;
	    }
	   
	}


