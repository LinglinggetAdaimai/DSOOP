package game;

import java.io.FileNotFoundException;
import java.util.*;

public class Game {

    private long start; // keep track of time
    private int score; // keep track score
    private HashMap<String, Integer> revealedwords; // <actual word, index>
    private HashMap<Integer,String> unrevealedwords; // <index, ?????>
    private Word baseword;
    private String twistedbase;
    private Command cmd = new Command();
    private List<Word> possibleWords; // word that can be formed by the baseword

    public Game(Word word, List<Word> possibleWords){
        baseword = word;
        sortList(possibleWords);
        this.possibleWords = possibleWords;
        generateRevealed(possibleWords);
        generateUnrevealed();
        twistedbase = baseword.twist();
    }

    public int start() {
        start = System.currentTimeMillis();
        // if quit == to
        // 0 == quit
        // 1 == new game
        // 2 == continue this game
        int quit = 2;
        while (quit == 2) {
            printPromt();
            Parser parse = new Parser();
            String input = parse.getInput();
            quit = processInput(input);

            if (score == revealedwords.size()) {
                userWin();
                return 1;
            }
        }
        return quit;
    }

    public void sortList(List<Word> list){
        Collections.sort(list);
        Collections.reverse(list);
    }

    public void generateRevealed(List<Word> list){
        revealedwords = new HashMap<>();
        int index = 0;
        for (Word word : list) {
            revealedwords.put(word.getWord(), index++);
        }
    }

    public void generateUnrevealed(){
        Iterator<String> it = revealedwords.keySet().iterator();
        unrevealedwords = new HashMap<>();
        while (it.hasNext()){
            String currWord = it.next();
            unrevealedwords.put(revealedwords.get(currWord), "?".repeat(currWord.length()));
        }
    }

    public int processCommand(CommandWords cmd){

        switch (cmd){
            case INFO:
                printUnrevealed();
                break;
            case GIVEUP:
                printRevealed();
                return 1;
            case QUIT:
                quit();
                return 0;
            case TWIST:
                twistedbase = baseword.twist();
                break;
        }
        return 2;
    }

    public void printPromt() {
        float sec = (System.currentTimeMillis()- start)/1000F;
        System.out.printf("\u001B[38;2;204;255;178m\nElapsed Time: %.2f seconds,",sec);
        System.out.printf(" Score: %d/%d\n\033[0m", score, possibleWords.size());
        System.out.println("\u001B[38;2;196;255;221mCommands: q - quit, ! - give up, ? - info, tw - twist");
        printTwistedWord();
    }

    public void printTwistedWord(){
        System.out.printf("\u001B[38;2;231;206;255m[%s]\033[0m", twistedbase);
    }

    public void printRevealed(){
        for(int i = 0 ; i < possibleWords.size(); i++){
            if (i%5 == 0) {
                System.out.println();
            }
            System.out.printf("\u001B[38;2;196;255;221m%s ", possibleWords.get(i).getWord());
        }
    }
    public void printUnrevealed(){
        for(int i = 0 ; i < unrevealedwords.size(); i++){
            if (i%5 == 0) {
                System.out.println();
            }
            System.out.printf("\u001B[38;2;196;255;221m%s ", unrevealedwords.get(i));
        }
    }

    public int processInput(String input) {
        if(input == null){
            System.out.println("\u001B[38;2;196;255;221m\nI don't understand\033[0m");
            return 2;
        }

        if (cmd.isCommand(input)){
            return processCommand(cmd.getCommandWord(input));
        }
        Word aWord = new Word(input.toLowerCase());
        if (formable(aWord)) {
            unrevealedwords.put(revealedwords.get(aWord.getWord()), aWord.getWord());
            score++;
        }
        return 2;
    }

    public boolean formable(Word aWord){ return revealedwords.containsKey(aWord.getWord()); }

    public void quit (){
        System.out.println("\u001B[38;2;204;255;178m\nThank you for playing! Bye!\033[0m");
    }

    public void userWin(){ System.out.println("\u001B[38;2;204;255;178m\nYou've solved every words. Well done!\033[0m");}

}


