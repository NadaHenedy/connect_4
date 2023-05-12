package Algorithm;
import java.io.*;
import Util.*;
public class MinMax implements Algorithm {	

		 int maxDepth;
		    heuristic heuristic; 
		    boolean printTree;
		    int treeSize;
		//constructor
		    public MinMax(int maxDepth) {
		        this.maxDepth = maxDepth;
		        heuristic = new heuristic();
		    }

		    
		 @Override
		    public char[][] Decision(char[][] board, boolean printTree) {
		        this.printTree = printTree;
		        treeSize = 0;
		        // to calculate time
		        long startTime = System.nanoTime();
//		    we get the first board in tree
		        char[][] res = maximize(board, 0).getBoard();
		        long endTime = System.nanoTime();
		        System.out.println(" Nodes Expanded = " + treeSize + " Time taken = " + (endTime - startTime) / 1000000 + " ms");
		        return res;
		    }

		    state maximize(char[][] board, int k) {
		        // increse size of tree
		        treeSize++;
		        // if depth of tree equal max depth or bord is terminal 
		        if (k == maxDepth || compare.isFull(board)) {
		            //get evalution score for board form heuristic class
		            int eval = heuristic.evalution(board);
		            // we check if printTree is true we print tree and get evalution for this boad 
		            if (printTree)
		                compare.print(board, k, maxDepth, eval);
		            return new state(null, eval);
		        }
		        if (printTree)
		           // we print tree and evalution equal -1 because is not terminal board 
		            compare.print(board, k, maxDepth, -1);
		                                     
		        state state = new state(null, Integer.MIN_VALUE);
		        for (char[][] child : compare.getNeighbours(board, true)) {
		            state childState = minimize(child, k + 1);
		            if (childState.UtilValues > state.UtilValues)
		                state = new state(child, childState.UtilValues);
		        }
		        return state;
		    }

		    state minimize(char[][] board, int k) {
		        // increse size of tree
		        treeSize++;
		       // if depth of tree eual max depth or bord is terminal 
		        if (k == maxDepth || compare.isFull(board)) {
		         //get evalution score for board form heuristic clas 
		            int evalution = heuristic.evalution(board);
		            
		            if (printTree)
		                compare.print(board, k, maxDepth, evalution);
		            return new state(null, evalution);
		        }
		        if (printTree)
		            compare.print(board, k, maxDepth, -1);
		        state state = new state(null, Integer.MAX_VALUE);
		        for (char[][] child : compare.getNeighbours(board, false)) {
		            state childState = maximize(child, k + 1);
		            if (childState.UtilValues < state.UtilValues)
		                state = new state(child, childState.UtilValues);
		        }
		        return state;
		    }    
		}


