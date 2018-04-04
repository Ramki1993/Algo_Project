package com.sudoku;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Sudoku s = new Sudoku();
		int[][] matrix = s.initMatrix(args);
		s.displayMatrix(matrix);
		if (s.solveForSolution(0,0,matrix))    // solves for a solution using backtracking.
		   s.displayMatrix(matrix);
		else 
		   System.out.println("THERE IS NO SOULUTION TO THIS INPUT");
	}
	
}
