package game;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class Games {

    List<Word> wordsForGame;
    WordDatabase database;

    public Games() throws FileNotFoundException {
        database = new WordDatabase("linuxwords.txt");
        wordsForGame = database.getWordWithLength(6);
    }

    public Word getAword() {
        Random rand = new Random();
        if (wordsForGame.size() == 0){
            wordsForGame = database.getWordWithLength(6);
        }
        int randomIndex = rand.nextInt(wordsForGame.size());
        Word returnedword =wordsForGame.get(randomIndex);
        wordsForGame.remove(randomIndex);
        return returnedword ;
    }

    public void play(){
        int end = 1;
        Word wordForThisgame;
        while (end == 1) {
            wordForThisgame = getAword();
            Game aGame = new Game(wordForThisgame, allPossibleword(wordForThisgame));
            end = aGame.start();
            aGame = null;
        }
    }

    public List<Word> allPossibleword(Word word){
        return database.getAllSubWords(word, 2);
    }

}
