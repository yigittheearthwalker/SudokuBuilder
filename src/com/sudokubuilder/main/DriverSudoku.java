package com.sudokubuilder.main;

import com.sudokubuilder.builder.SudokuWizard;
import com.sudokubuilder.sudoku.Sudoku;

public class DriverSudoku {
	public static void main(String[] args) {
		
		Sudoku sudoku = new Sudoku();
		
		SudokuWizard.build(sudoku);
		
		SudokuWizard.print(sudoku);
	}
}
