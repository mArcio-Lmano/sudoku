package com.mano.app.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mano.app.board.Board;

/**
 * GameUI
 */
public class GameUI {
    public JFrame mainFrame;
    private int gridDim = 9; // NOTE: Change in the future
    private Integer[][] board;
    private JTextField[][] textFields;
    final Board gameBoard;

    public GameUI() {

        gameBoard = new Board();
        board = gameBoard.board;
        textFields = new JTextField[gridDim][gridDim];

        mainFrame = new JFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();

        JLabel title = new JLabel("Sudoku");
        title.setFont(new Font("JetBrainsMono NF", Font.BOLD, 70));
        JPanel gamePanel = createGamePanel();

        JButton solveBtn = new JButton("Solve");
        solveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("solve");
                // BUG: NOT WORKING
                // gameBoard.solve(0, 0);

                SolveBoard();
            }

        });

        JButton quitBtn = new JButton("Quit");
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });

        // NOTE: Not Sure of the Layout to go for....
        // JPanel buttonPanel = new JPanel(new BorderLayout());
        // buttonPanel.add(quitBtn, BorderLayout.EAST);
        // buttonPanel.add(solveBtn, BorderLayout.WEST);
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.add(solveBtn);
        buttonPanel.add(quitBtn);

        titlePanel.add(title);
        mainFrame.add(titlePanel, BorderLayout.NORTH);
        mainFrame.add(gamePanel, BorderLayout.CENTER);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createGamePanel() {
        JPanel gamePanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        Dimension fieldSize = new Dimension(50, 50);
        for (int row = 0; row < gridDim; row++) {
            for (int col = 0; col < gridDim; col++) {
                JTextField elem = new JTextField();
                textFields[row][col] = elem;
                if (board[row][col] != null && board[row][col] != 0) {
                    elem.setText(board[row][col].toString());
                    elem.setEditable(false);
                }
                elem.setFont(new Font("JetBrainsMono NF", Font.BOLD, 35));
                elem.setHorizontalAlignment(JTextField.CENTER);
                elem.setPreferredSize(fieldSize);
                gamePanel.add(elem, c);
                c.gridx++;

                int top = (row % 3 == 0) ? 4 : 1;
                int left = (col % 3 == 0) ? 4 : 1;
                int bottom = (row == gridDim - 1) ? 4 : 1;
                int right = (col == gridDim - 1) ? 4 : 1;
                elem.setBorder(BorderFactory.createMatteBorder(
                        top,
                        left,
                        bottom,
                        right,
                        Color.BLACK));
            }
            c.gridx = 0;
            c.gridy++;
        }
        return gamePanel;
    }

    private void SolveBoard() {
        for (int row = 0; row < gridDim; row++) {
            for (int col = 0; col < gridDim; col++) {
                System.out.print(textFields[row][col].getText());
                System.out.print(" ");
            }
            System.out.println("");
        }
        // BUG: This changes the board
        gameBoard.solve(0, 0);
        gameBoard.printBoard();
    }
}
