package game;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class WordDatabase implements IDatabase {

    List<Word> database;

    // Load all the words from a file given by filename.
    public WordDatabase(String filename) throws FileNotFoundException {
        database = new LinkedList<>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream;
            inputStream = classLoader.getResourceAsStream(filename);
            readFromInputStream(inputStream);

        } catch (FileNotFoundException e) {
            System.out.println(new FileNotFoundException());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                Word word = new Word(line.toLowerCase(Locale.ROOT));
                database.add(word);
            }
        }
    }


    @Override
    public void add(Word w) {
        database.add(w);
    }

    @Override
    public void remove(Word w) {
        database.remove(w);
    }

    // return the word that have l length
    @Override
    public List<Word> getWordWithLength(int l) {
        List<Word> listOfWords = new LinkedList<>();
        Iterator<Word> it = database.iterator();
        while (it.hasNext()){
            Word currword = it.next();
            if (currword.getlength() == l){
                listOfWords.add(currword);
            }
        }
        return listOfWords;
    }


    // return list of word that can form w and has length at least minLen
    @Override
    public List<Word> getAllSubWords(Word w, int minLen) {
        List<Word> listOfWords = new LinkedList<>();
        Iterator<Word> it = database.iterator();
        while (it.hasNext()) {
            Word currword = it.next();
            if (currword.getlength() >= minLen && w.canForm(currword)) {
                listOfWords.add(currword);
            }
        }
        return listOfWords;
    }

    @Override
    public boolean contains(Word o) {return database.contains(o);}

}
