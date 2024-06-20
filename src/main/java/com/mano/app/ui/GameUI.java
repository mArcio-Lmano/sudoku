package com.mano.app.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

    public GameUI() {

        final Board gameBoard = new Board();
        board = gameBoard.board;

        // System.out.println(board);
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
            }
        });

        titlePanel.add(title);
        mainFrame.add(titlePanel, BorderLayout.NORTH);
        mainFrame.add(gamePanel, BorderLayout.CENTER);
        mainFrame.add(solveBtn, BorderLayout.SOUTH);
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
                if (board[row][col] != 0) {
                    elem.setText(board[row][col].toString());
                    elem.setEditable(false);
                }
                elem.setFont(new Font("JetBrainsMono NF", Font.BOLD, 35));
                elem.setHorizontalAlignment(JTextField.CENTER);
                elem.setPreferredSize(fieldSize);
                gamePanel.add(elem, c);
                c.gridx++;
            }
            c.gridx = 0;
            c.gridy++;
        }
        return gamePanel;
    }

    // private void SolveBoard() {
    //
    //
    // }
}
