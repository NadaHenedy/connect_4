package Algorithm;
import java.io.*;

import Util.*;
public class AlphaBeta implements Algorithm {
	     int maxDepth;
	    heuristic heuristic;
	    boolean printTree;
	    int treeSize;

	    public AlphaBeta(int k) {
	        this.maxDepth = k;
	        heuristic = new heuristic();
	    }

	    @Override
	    public char[][] Decision(char[][] board, boolean printTree) {
	        

	        treeSize = 0;
	        long startTime = System.nanoTime();
	        char[][] res = maximize(board, 0, Integer.MIN_VALUE, Integer.MAX_VALUE).getBoard();
	        long endTime = System.nanoTime();
	        System.out.println("Nodes Expanded = " + treeSize + " Time taken = " + (endTime - startTime) / 1000000 + " ms");
	        return res;
	    }

	    state maximize(char[][] board, int k, int alpha, int beta) {
	        treeSize++;
	        if (k == maxDepth || compare.isFull(board)) {
	            int eval = heuristic.evalution(board);
	            if (printTree)
	                compare.print(board, k, maxDepth, eval);
	            return new state(null, eval);
	        }
	        if (printTree)
	            compare.print(board, k, maxDepth, -1);
	        state state = new state(null, Integer.MIN_VALUE);

	        for (char[][] child : compare.getNeighbours(board, true)) {
	            state childState = minimize(child, k + 1, alpha, beta);
	            if (childState.UtilValues > state.UtilValues)
	                state = new state(child, childState.UtilValues);
	            if (state.UtilValues >= beta)
	                break;
	            if (state.UtilValues > alpha)
	                alpha = state.UtilValues;
	        }
	        return state;
	    }

	    state minimize(char[][] board, int k, int alpha, int beta) {
	        treeSize++;
	        if (k == maxDepth || compare.isFull(board)) {
	            int eval = heuristic.evalution(board);
	            if (printTree)
	                compare.print(board, k, maxDepth, eval);
	            return new state(null, eval);
	        }
	        if (printTree)
	            compare.print(board, k, maxDepth, -1);
	        state state = new state(null, Integer.MAX_VALUE);
	        for (char[][] child : compare.getNeighbours(board, false)) {
	            state childState = maximize(child, k + 1, alpha, beta);
	            if (childState.UtilValues < state.UtilValues)
	                state = new state(child, childState.UtilValues);
	            if (state.UtilValues <= alpha)
	                break;
	            if (state.UtilValues < beta)
	                beta = state.UtilValues;
	        }
	        return state;
	    }
	    
	}


