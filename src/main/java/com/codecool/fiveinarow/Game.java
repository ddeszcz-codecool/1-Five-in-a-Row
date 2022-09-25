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
            System.out.println("If you want to exit the game please type - quit");

            String coordinates = scanner.nextLine().toUpperCase();

            if (coordinates.equals("QUIT")) {
                System.exit(0);
            }

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
        // this method will not check whether the cell has been already used or whether the selection
        // is out of bound because it has already been done ine getMove() method and that will be the only source of
        // coordinates for this method
        board[row][col]=player;
    }

    public boolean hasWon(int player, int howMany) {
        // consecutive marking in a row analyzed
        for (int[] ints:board){
            int count = 0;
            for (int item : ints){
                if (item == player){
                    count++;
                } else {count = 0;}
                if (count == howMany)
                    return true;
            }
        }

        // consecutive marking in a column analyzed
        for (int i = 0; i < board[0].length; i++) {
            int count = 0;
            for (int[] ints : board) {
                if (ints[i] == player) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == howMany)
                    return true;

            }

        }

        return false;
    }

    public boolean isFull() {
        for(int[] row:board)
            for(int item:row)
                if (item==0)
                    return false;
        return true;
    }

    public void printBoard() {
        //print  width key
        System.out.print("  ");
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();

        //print height key and matrix
        for (int i = 0; i < board.length; i++) {
            //print height key
            System.out.print(getCharForNumber(i + 1) + " ");
            //print matrix
            for (int item:board[i]) {
                if (item == 0)
                    System.out.print(". ");
                else if (item == 1)
                    System.out.print("x ");
                else if (item == 2)
                    System.out.print("o ");
            }
            System.out.println();
        }
    }

    public void printResult(int player){
    }

    //question I am not sure if this is a correct way to override the interface, current printResults, is impossible
    // to implement it asks as to assess if tie was achieved, but it is not possible without howMany parameter).
    public void printResult(int player, int howMany) {
        if (hasWon(player, howMany)){
            if(player==1)
                System.out.println("----- X won! -----");
            else if (player == 2)
                System.out.println("----- O won! -----");
        } else {
            System.out.println("----- It's a tie! -----");
        }
    }

    public void enableAi(int player) {
    }

    public void play(int howMany) {
        System.out.println("You are about to start playing Five-in-a-row. This is your board");
        printBoard();
        boolean infiniteLoop = true;
        while(infiniteLoop){
            for (int player = 1; player <= 2; player++) {
                int[] newMove = getMove(player);
                mark(player,newMove[0],newMove[1]);
                printBoard();
                if(hasWon(player,howMany)){
                    infiniteLoop = false;
                    printResult(player,howMany);
                    printBoard();
                    break;}
                if(isFull()){
                    infiniteLoop = false;
                    printResult(player,howMany);
                    printBoard();
                    break;}
            }

        }

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