package com.mano.app;

import com.mano.app.board.Board;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Board board = new Board();
        board.printBoard();
    }
}
