package Util;


	import java.util.*;
	import java.io.*;


	public class compare {
	    	//Clone the pre state of board 
	      public static char[][] clone(char[][] board) {
	        char[][] child = new char[board.length][];
	        for (int i = 0; i < board.length; i++) {
	            child[i] = board[i].clone();
	        }
	        return child;
	    }
	    public static List<char[][]> getNeighbours(char[][] board, boolean max) {
	        List<char[][]> neighbours = new ArrayList<>();
	        for (int col = 0; col < board[0].length; col++) {
	            for (int row = board.length - 1; row >= 0; row--) {
	                if (board[row][col] == '_') {
	                    char[][] child = clone(board);
	                    
	                    child[row][col] = max ? 'a' : 'p';
	                    neighbours.add(child);
	                    break; }
	            } }
	        return neighbours;
	    }
	    // check if this board is full board or not 
	    public static boolean isFull(char[][] board) {
	        for (int i = 0; i < board.length; i++)
	            for (int j = 0; j < board[0].length; j++)
	               // board is not full 
	                if (board[i][j] == '_') 
	                    return false;
	        // board is full
	        return true;
	    }

	    public static void print(char[][] board, int curDepth, int maxDepth, int evalution) {
	        String tree = "";
	        for (int i = 0; i < board.length; i++) {
	            // 
	            for (int t = 1; t < curDepth ; t++)
	                tree += "\t";
	            for (int j = 0; j < board[0].length; j++) {
	                tree += board[i][j] + " ";
	            }
	            tree += "\n";
	        }
	        if (curDepth == maxDepth || compare.isFull(board)) {
	            for (int t = 1; t < curDepth ; t++)
	                tree += "\t";
	            tree += evalution;
	        }
	        tree += "\n";
	        FileWriter output;
	        try {
	            output = new FileWriter("C:\\Users\\LENOVO\\OneDrive\\Documents\\tree.txt", true);
	            output.write(tree);
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	            System.out.println("Failed to save the tree file.\n");
	        }
	    }
	}



