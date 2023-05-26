import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords
{

    final HashMap<String, CommandWord> validCommand;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommand = new HashMap<>();

        validCommand.put("go", CommandWord.GO);
        validCommand.put("help", CommandWord.HELP);
        validCommand.put("quit", CommandWord.QUIT);
        validCommand.put("look", CommandWord.LOOK);

    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        aString = aString.toLowerCase();
        return validCommand.containsKey(aString);
    }

    public CommandWord getCommandWord(String command) {
        command = command.toLowerCase();
        CommandWord commandWord = validCommand.get(command);
        if (commandWord != null) {
            return commandWord;
        }
        else return CommandWord.UNKNOWN;
    }
}
