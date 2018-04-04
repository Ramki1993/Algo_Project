package com.sudoku;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class Sudoku {

	public static boolean solveForSolution(int i, int j, int[][] cells) {
			if (i == 9) {
			    i = 0;
			    if (++j == 9) 
				return true; 
			}
			if (cells[i][j] != 0)  //skipping all the pre-filled cells.
			    return solveForSolution(i+1,j,cells);
			
			for (int val = 1; val <= 9; ++val) {
			    if (checkLegal(i,j,val,cells)) {  
				cells[i][j] = val;       
				if (solveForSolution(i+1,j,cells))  
				    return true;
			    }
			}
			cells[i][j] = 0; //reset on backtrack.
			return false;
		    }

		public static boolean checkLegal(int i, int j, int val, int[][] cells) {
			for (int k = 0; k < 9; ++k)  //row.
			    if (val == cells[k][j])
				return false;

			for (int k = 0; k < 9; ++k) //column.
			    if (val == cells[i][k])
				return false;

			int boxRowOffset = (i / 3)*3;
			int boxColOffset = (j / 3)*3;
			for (int k = 0; k < 3; ++k) //box.
			    for (int m = 0; m < 3; ++m)
				if (val == cells[boxRowOffset+k][boxColOffset+m])
				    return false;

			return true; // if no violations then return true.
		    }

		public static int[][] initMatrix(String[] inputArray) throws Exception { 
			int[][] problem = new int[9][9]; // default value is zero.
			for (int n = 0; n < inputArray.length; ++n) {
			    int i = Integer.parseInt(inputArray[n].substring(0,1));   
			    int j = Integer.parseInt(inputArray[n].substring(1,2));   
			    int val = Integer.parseInt(inputArray[n].substring(2,3)); 
			    problem[i][j] = val;
			}
			return problem;
		    }

		public static void displayMatrix(int[][] solution) {
			for (int i = 0; i < 9; ++i) {
			    if (i % 3 == 0)
				System.out.println(" -----------------------");
			    for (int j = 0; j < 9; ++j) {
				if (j % 3 == 0) System.out.print("| ");
				System.out.print(solution[i][j] == 0
						 ? " "
						 : Integer.toString(solution[i][j]));
				
				System.out.print(' ');
			    }
			    System.out.println("|");
			}
			System.out.println(" -----------------------");
		    }	
		
		

}
