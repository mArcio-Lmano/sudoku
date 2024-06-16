package com.mano.app.board;

import java.util.Random;

import com.mano.app.utils.Array;

/**
 * Board
 */

public class Board {
    public Integer[][] board;
    Integer[] possibleMoves;
    private Integer nRows = 9;
    private Integer nCols = 9;
    int lengthMat = (int) Math.sqrt(nRows);
    int numbOfNumbers = nRows * nCols;

    private Array arrayUtil = new Array();

    public Board() {
        System.out.println("Board");
        board = new Integer[9][9];
        possibleMoves = arrayUtil.restart(nRows);
        cleanBoard();
        solve(0, 0);
        removeElements(0.70);
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
        for (int row = 0; row < nRows; row++) {
            if (row % lengthMat == 0) {
                for (int i = 0; i < nRows + lengthMat + 1; i++) {
                    System.out.print("-");
                    System.out.print(" ");
                }
                System.out.println("");
            }
            for (int col = 0; col < nCols; col++) {
                if (col % lengthMat == 0) {
                    System.out.print("|");
                    System.out.print(" ");
                }
                if (board[row][col] == 0) {
                    System.out.print("□");
                } else {
                    System.out.print(board[row][col]);
                }
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print(" ");
            System.out.println("");
        }
        for (int i = 0; i < nRows + lengthMat + 1; i++) {
            System.out.print("-");
            System.out.print(" ");
        }
        System.out.println("");
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
        res += checkMat(roW, coL);
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
        // NOTE: Find to what matrix the point belongs.
        int res = 0;
        int deltaBoundRow = roW / lengthMat, deltaBoundCol = coL / lengthMat;
        int minBoundRow = lengthMat * deltaBoundRow, maxBoundRow = lengthMat * deltaBoundRow + lengthMat;
        int minBoundCol = lengthMat * deltaBoundCol, maxBoundCol = lengthMat * deltaBoundCol + lengthMat;

        for (int row = minBoundRow; row < maxBoundRow; row++) {
            for (int col = minBoundCol; col < maxBoundCol; col++) {
                if (board[roW][coL] == board[row][col] && (row != roW && col != coL)) {
                    res = 1;
                }
            }
        }
        return res;
    }

    private void removeElements(double percentageToRemove) {
        Integer[] boardSize = arrayUtil.createIndexArray(nRows * nCols); // NOTE: THIS WILL BRING A BUG THX TO THE 81
        int NumberOfElementsToRemove = (int) (boardSize.length * percentageToRemove);
        while (boardSize.length > (nRows * nCols) - NumberOfElementsToRemove) {
            int indexToRemove = getRandomIndex(boardSize.length);
            int indexRow = boardSize[indexToRemove] / nRows;
            int indexCol = boardSize[indexToRemove] % nCols;
            board[indexRow][indexCol] = 0;
            boardSize = arrayUtil.remove(boardSize, indexToRemove);
        }
    }

    private int getRandomIndex(int boardSize) {
        Random rand = new Random();
        int index = rand.nextInt(boardSize);
        return index;
    }

    private int checkDiagonal(Integer roW, Integer coL) {
        // NOTE: I dont think i need to check the two diagonals check later
        return 0;
    }
}
