package game;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class only reads the input and return the input (String)
 */

public class Parser
{
    private Scanner reader; // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser()
    {
        reader = new Scanner(System.in);
    }

    /**
     * @return Input from the user.
     */
    public String getInput()
    {
        String inputLine;
        String para = null;
//        System.out.print("\u001B[38;2;204;178;255m > \033[0m");     // print prompt ">"
        System.out.print(">");     // print prompt ">"

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            para = tokenizer.next();
        }
        return para;
    }
}

