package com.sudoku;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SudokuSolver s = new SudokuSolver();
		SudokuGenerator sg = new SudokuGenerator();
		int numOfHoles = 65; // Higher the number of holes harder the difficulty max number = 70;
		int[][] matrix =sg.nextBoard(numOfHoles);
		s.displayMatrix(matrix);
		if (s.solveForSolution(0,0,matrix))    // solves for a solution using backtracking.
		   s.displayMatrix(matrix);
		else 
		   System.out.println("THERE IS NO SOULUTION TO THIS INPUT");
	}
	
}
