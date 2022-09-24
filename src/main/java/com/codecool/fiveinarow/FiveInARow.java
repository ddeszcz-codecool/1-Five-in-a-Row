package com.codecool.fiveinarow;

import java.util.Arrays;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(5, 10);
        game.enableAi(1);
        game.enableAi(2);
        game.play(3);




    }
}