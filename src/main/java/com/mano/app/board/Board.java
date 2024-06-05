package com.mano.app.board;

import java.util.Random;

import com.mano.app.utils.Array;

/**
 * Board
 */

public class Board {
    public Integer[][] board;
    private Integer nRows = 9;
    private Integer nCols = 9;
    private Array arrayUtil = new Array();
    Integer[] possibleMoves = arrayUtil.restart();

    public Board() {
        System.out.println("Board");
        board = new Integer[9][9];
        cleanBoard();
        // generateBoard();
        solve(0, 0);
        printBoard();
    }

    private void cleanBoard() {
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                board[row][col] = 0;
            }
        }
    }

    public void printBoard() {
        System.out.println("#############");
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                System.out.print(board[row][col]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("#############");
    }

    private boolean solve(int roW, int coL) {

        if (roW == nRows) {
            return true;
        }
        if (coL == nCols) {
            return solve(roW + 1, 0);
        }

        arrayUtil.shuffle(possibleMoves);
        for (Integer move : possibleMoves) {
            board[roW][coL] = move;
            if (checkMove(roW, coL) == 0) {
                if (solve(roW, coL + 1)) {
                    return true;
                }
            }
            board[roW][coL] = 0;
        }
        return false;
    }

    private int checkMove(Integer roW, Integer coL) {
        int res = 0;
        res += checkRow(roW, coL);
        res += checkCol(roW, coL);
        return res;
    }

    private int checkRow(Integer roW, Integer coL) {
        int res = 0;
        int col = 0;
        Integer value = board[roW][coL];
        while (col < nRows) {
            if (col != coL && board[roW][col] == value) {
                res = 1;
                break;
            }
            col++;
        }
        return res;
    }

    private int checkCol(Integer roW, Integer coL) {
        int res = 0;
        int row = 0;
        Integer value = board[roW][coL];
        while (row < nRows) {
            if (row != roW && board[row][coL] == value) {
                res = 1;
                break;
            }
            row++;
        }
        return res;
    }

    private int checkMat(Integer roW, Integer coL) {
        return 0;
    }

    private int checkDiagonal(Integer roW, Integer coL) {
        // NOTE: I dont think i need to check the two diagonals check later
        return 0;
    }
}
