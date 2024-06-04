package com.mano.app.board;

import java.util.Random;

/**
 * Board
 */
public class Board {
    public Integer[][] board;
    private Integer nRows = 9;
    private Integer nCols = 9;

    public Board() {
        System.out.println("Board");
        board = new Integer[9][9];
        cleanBoard();
        generateBoard();
    }

    private void cleanBoard() {
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                board[row][col] = 0;
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                System.out.print(board[row][col]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    private int generateBoard() {
        Random rand = new Random();
        Integer[] possibleMoves = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int res = 0;

        for (int col = 0; col < nCols; col++) {
            for (int row = 0; row < nRows; row++) {
                int numberIndex = rand.nextInt(possibleMoves.length);
                board[col][row] = possibleMoves[numberIndex];
            }
        }
        return res;
    }

    private int checkMove(Integer roW, Integer coL) {
        return 0;
    }

    private int checkDiagonal(Integer roW, Integer coL) {
        return 0;
    }

    private int checkRow(Integer roW, Integer coL) {
        return 0;
    }

    private int checkMat(Integer roW, Integer coL) {
        return 0;
    }
}
