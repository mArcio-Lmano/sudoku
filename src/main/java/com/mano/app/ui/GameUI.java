package com.mano.app.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import com.mano.app.board.Board;

/**
 * GameUI
 */
public class GameUI {
    public JFrame mainFrame;
    private int gridDim = 9; // NOTE: Change in the future
    private Integer[][] board;

    public GameUI() {

        Board gameBoard = new Board();
        board = gameBoard.board;

        // System.out.println(board);
        mainFrame = new JFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();

        JLabel title = new JLabel("Sudoku");
        title.setFont(new Font("JetBrainsMono NF", Font.BOLD, 20));
        JPanel gamePanel = createGamePanel();

        titlePanel.add(title);
        mainFrame.add(titlePanel, BorderLayout.NORTH);
        mainFrame.add(gamePanel, BorderLayout.CENTER);
    }

    private JPanel createGamePanel() {
        JPanel gamePanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        for (int row = 0; row < gridDim; row++) {
            for (int col = 0; col < gridDim; col++) {
                JLabel elem;
                if (board[row][col] == 0) {
                    elem = new JLabel(" ");
                } else {
                    elem = new JLabel(board[row][col].toString());
                }
                gamePanel.add(elem, c);
                c.gridx++;
            }
            c.gridx = 0;
            c.gridy++;
        }
        return gamePanel;
    }
}
