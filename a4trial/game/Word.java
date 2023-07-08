package game;

import histogram.Histogram;
import histogram.SimpleHistogram;

import java.util.*;

public class Word implements Formable<Word>, Comparable<Word> {

    private String theWord;
    private Character[] listOfChar;
    private SimpleHistogram<Character> wordHistogram;

    // The only constructor of the class, which takes a String representation
    // of the word. The histogram is generated here from the given word.
    public Word(String word) {
        theWord = word;
        int wordLength = word.length();
        listOfChar = new Character[wordLength];
        for (int i = 0; i < wordLength; i++) { // put char in the arr
            listOfChar[i] = word.charAt(i);
        }
        wordHistogram = new SimpleHistogram<>(listOfChar);
    }

    // Returns the String representation of the word.
    public String getWord(){ return theWord;}

    // Returns a Histogram describing the character distribution of the word.
    public Histogram<Character> getHistogram() {
        return this.wordHistogram;
    }

    // check if this comes before w
    // start with checking if the length are the same
    // then loop through to check each char
    private boolean isBefore (Word w){
        if (this.getlength() != w.getlength()) {return false;}

        for (int i = 0; i < w.getlength(); i++){
            if (this.listOfChar[i] > w.listOfChar[i]){
                return false;
            }
        }
        return true;
    }

    // Returns true if the Word represented by other can be formed using some
    // or all of the characters of this word.

    // "this" is the base, so we iterate through "other" to check
    // if it forms by the char in base and the amt is the same.
    @Override
    public boolean canForm(Word other) {
        Iterator<Character> iter = other.wordHistogram.iterator();

        while (iter.hasNext()) {
            Character curr_key = iter.next();
            if (this.wordHistogram.getValue(curr_key) <
                    other.wordHistogram.getValue(curr_key)) {
                return false;
            }
        }
        return true;
    }

    public int getlength() {
        return theWord.length();
    }

    // rearrange the word
    public String twist(){
        StringBuilder twistedWord = new StringBuilder();
        HashSet<Integer> indices = new HashSet<>();
        Random rand = new Random();
        int randomIndex;

        while ( indices.size() < listOfChar.length) {
            randomIndex = rand.nextInt(listOfChar.length);
            if (!(indices.contains(randomIndex))) {
                indices.add(randomIndex);
                twistedWord.append(listOfChar[randomIndex]);
            }
        }

        return twistedWord.toString();
    }

    // Return -1 if this word is shorter than the word represented by o OR
    // when this word and the word represented by o have the same length but
    // this word comes before the word represented by o alphabetically.
    // Return 0 if this word and o word are identical.
    // Return +1 otherwise.
    @Override
    public int compareTo(Word o) {
        if (o.wordHistogram.equals(this.wordHistogram)) {return 0;}
        if (o.getlength() < this.getlength() | this.isBefore(o)) {return -1;}
        return 1;
    }

}
