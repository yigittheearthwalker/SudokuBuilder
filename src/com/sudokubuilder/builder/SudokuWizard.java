package com.sudokubuilder.builder;

import java.util.Random;

import com.sudokubuilder.sudoku.Sudoku;
/*
 * 				
 *				  ROW
 * 		------------------------->	
 * 		|		|       |		|
 * 	   C|  BOX  | 		|		|
 * 	   O|		|		|		|
 * 	   L|------------------------
 * 	   U|		|		|		|
 * 	   M|		|		|		|	
 * 	   N|		|		|		|
 * 	    |------------------------
 * 		|		|		|		|
 * 		|		|		|		|		
 * 		|		|		|		|
 * 		|------------------------
 * 		v
 * 
 * 
 * 
 */

public class SudokuWizard {

	static Random random = new Random();

	public static void build(Sudoku sudoku) {

		loop1: for (int i = 0; i < sudoku.getSudoku().length;) {
			loop2: for (int j = 0; j < sudoku.getSudoku()[i].length; j++) {

				int randomDigit = random.nextInt(9) + 1;
				int counter = 0;

				while (isRowContains(randomDigit, sudoku, i) || isColumnContains(randomDigit, sudoku, j)
						|| isBoxContains(sudoku, randomDigit, i, j)) {

					randomDigit = random.nextInt(9) + 1;

					counter++;

					if (counter == 100) {
						rowCleaner(sudoku, i);
						i = (i - (i % 3)) - 1;
						break loop2;
					}
				}

				sudoku.getSudoku()[i][j] = randomDigit;

			}
			i++;
		}
	}

	static boolean isRowContains(int randomDigit, Sudoku sudoku, int x) {

		boolean contains = false;

		for (int i = 0; i < sudoku.getSudoku()[x].length; i++) {
			if (sudoku.getSudoku()[x][i] == randomDigit) {
				contains = true;
			}
		}
		return contains;
	}

	static boolean isColumnContains(int randomDigit, Sudoku sudoku, int y) {
		boolean contains = false;

		for (int i = 0; i < sudoku.getSudoku().length; i++) {
			if (sudoku.getSudoku()[i][y] == randomDigit) {
				contains = true;
			}
		}

		return contains;
	}

	static boolean isBoxContains(Sudoku sudoku, int randomDigit, int x, int y) {
		boolean contains = false;
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				if (sudoku.getSudoku()[(x - (x % 3)) + i][(y - (y % 3)) + j] == randomDigit) {

					contains = true;
				}

			}

		}
		return contains;
	}

	static void rowCleaner(Sudoku sudoku, int index) {

		for (int i = 0; i < (index % 3) + 1; i++) {

			for (int j = 0; j < sudoku.getSudoku()[index].length; j++) {
				sudoku.getSudoku()[(index - (index % 3)) + i][j] = 0;
			}
		}

	}

	public static void print(Sudoku sudoku) {
		for (int i = 0; i < sudoku.getSudoku().length; i++) {

			System.out.println("\n-----------------------------------------");
			if (i % 3 == 0) {
				System.out.println("-----------------------------------------");

			}
			System.out.print("||");
			for (int j = 0; j < sudoku.getSudoku()[i].length; j++) {
				System.out.print(" " + sudoku.getSudoku()[i][j] + " |");
				if (j % 3 == 2) {
					System.out.print("|");
				}
			}

			if (i == sudoku.getSudoku().length - 1) {
				System.out.println("\n-----------------------------------------");
			}

		}

	}

}
