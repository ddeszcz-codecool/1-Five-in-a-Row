package com.codecool.fiveinarow;

import java.util.Arrays;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(5, 5);
        game.enableAi(1);
        game.enableAi(2);
        game.play(5);
        System.out.println(Arrays.deepToString(game.getBoard())); //todo - testing to be removed
//        int[] newMove = game.getMove(1);   //todo - testing to be changed - remove
//        System.out.println(Arrays.toString(newMove)); //todo - testing to be removed
//        game.mark(1,newMove[0], newMove[1]);
        System.out.println(Arrays.deepToString(game.getBoard())); //todo - testing to be removed
//        game.fillBoard();
        System.out.println(Arrays.deepToString(game.getBoard())); //todo - testing to be removed
        System.out.println(game.hasWon(1,3));
        System.out.println(game.isFull());



    }
}