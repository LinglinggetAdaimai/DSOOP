import java.io.*;

public class WordDataBase {
    public WordDataBase(String filename) throws FileNotFoundException {
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
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordDataBase ne = new WordDataBase("another.txt");
    }
}