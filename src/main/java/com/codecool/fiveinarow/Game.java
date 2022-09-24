package com.codecool.fiveinarow;

import java.util.Arrays;
import java.util.Scanner;

public class Game implements GameInterface {

    private int[][] board;


    public Game(int nRows, int nCols) {
        board = new int[nRows][nCols];
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[] getMove(int player) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello player number " + player + "!!! Please state your next move. ");


        while (true) {
            System.out.println("Please use a combination of letters and numbers e.g. A1, B4." +
                    " Please do not exceed board range." +
                    " Board height is from A to " + getBoardHeight(board) +
                    " and board width is from 1 to " + getBoardWidth(board));

            String coordinates = scanner.nextLine().toUpperCase();

            //checking if format - coordinates length is correct
            if (coordinates.length() == 2) {
                //checking if first part of the selection sequence (row/height)  is correct
                if (coordinates.charAt(0) >= 'A' && coordinates.charAt(0) <= getBoardHeight(board).charAt(0))
                {
                    // translate coordinates entered into array coordinates
                    int row = coordinates.charAt(0) - 'A';
                    int col = coordinates.charAt(1) - '1';

                    //checking if second part of the selection sequence (column/width) is correct
                    if (col < getBoardWidth(board) && col >= 0) {
                        //checking if the selected field is empty
                        if (board[row][col] == 0){
                            return new int[]{row, col};
                        } else {
                            System.out.println("Please choose another field this field has been selected");}
                    } else {
                        System.out.println("Wrong input!");
                    }
                } else {
                    System.out.println("Wrong input!");
                }
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    public int[] getAiMove(int player) {
        return null;
    }

    public void mark(int player, int row, int col) {
    }

    public boolean hasWon(int player, int howMany) {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public void printBoard() {
    }

    public void printResult(int player) {
    }

    public void enableAi(int player) {
    }

    public void play(int howMany) {
    }

    private String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
    }

    private int getBoardWidth(int[][] board){
        return board[0].length;
    }

    private String getBoardHeight(int[][] board){
        return getCharForNumber(board.length );
    }

}