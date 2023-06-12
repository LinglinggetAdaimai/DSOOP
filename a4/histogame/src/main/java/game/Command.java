package game;
import java.util.HashMap;

public class Command {

    final HashMap<String, CommandWords> validCommand;

    /**
     * Constructor - initialise the command words.
     */
    public Command()
    {
        validCommand = new HashMap<>();
        validCommand.put("?", CommandWords.INFO);
        validCommand.put("!", CommandWords.GIVEUP);
        validCommand.put("q", CommandWords.QUIT);
        validCommand.put("tw", CommandWords.TWIST);


    }

    /**
     * Check whether a given String is a valid command word.
     * Can detect command word even if it's not in lowercase.
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        aString = aString.toLowerCase();
        return validCommand.containsKey(aString);
    }

    public CommandWords getCommandWord(String aString) {return validCommand.get(aString);}
}
