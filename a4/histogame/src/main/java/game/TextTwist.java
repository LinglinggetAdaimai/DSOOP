package game;

import java.io.FileNotFoundException;

    /**
     * There will be 5 classes 1 enum
     * TextTwist: to run the game
     * Games class: for generating the random words
     * Game class: for playing each word, dealing with commands
     * Parser class: for getting input
     * Commanword class : for validating and storing the command
     * CommandWords Enum
     */

    /**
     *  Additional: a twist command, in case the user want to a rearranged word
     */

public class TextTwist {

    public static void main(String[] args) {

        try {
            Games games = new Games();
            games.play();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

