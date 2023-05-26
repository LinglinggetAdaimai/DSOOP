import java.util.HashMap;


/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom;
    private Room[] allRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        allRoom = new Room[7];

        // create the rooms
        Room Portkey = new Room("in the portkey room!, hold on tight!");
        Portkey.setToPortkey();

        allRoom[0] = new Room("in the Library");
        allRoom[1] = new Room("in the Defence Against the Dark Arts classroom");
        allRoom[2] = new Room("Potions classroom");
        allRoom[3] = new Room("in the Great Hall");
        allRoom[4] = new Room("in the broom cupboard");
        allRoom[5] = new Room("outside of university");
        allRoom[6] = new Room("in the woods");


        allRoom[5].setExits("north", allRoom[3]);
        allRoom[5].setExits("east", allRoom[6]);

        allRoom[6].setExits("west", allRoom[5]);
        allRoom[6].setExits("north", allRoom[2]);

        allRoom[2].setExits("south", allRoom[6]);
        allRoom[2].setExits("north", Portkey);
        allRoom[2].setExits("west", allRoom[1]);

        allRoom[1].setExits("east", allRoom[2]);
        allRoom[1].setExits("south", allRoom[3]);

        allRoom[3].setExits("north", allRoom[1]);
        allRoom[3].setExits("west", allRoom[4]);
        allRoom[3].setExits("south", allRoom[5]);

        allRoom[4].setExits("east",allRoom[3]);
        allRoom[4].setExits("north", allRoom[0]);

        allRoom[0].setExits("south", allRoom[4]);

        currentRoom = allRoom[5];  // start game outside the university
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.print("The commands you can use: ");
        System.out.println(parser.listOfCommand());
        System.out.println();
        System.out.println(getLocationInfo());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Sorry, I don't know what you mean...");
            return false;
        }

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case LOOK:
                lookAround();
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case BACK:
                goBack();
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.listOfCommand());
    }

    /**
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     * @param command The command to be processed.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        Direction direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        switch (direction){
            case NORTH:
                nextRoom = currentRoom.getRoom(Direction.NORTH);
                break;
            case EAST:
                nextRoom = currentRoom.getRoom(Direction.EAST);
                break;
            case WEST:
                nextRoom = currentRoom.getRoom(Direction.WEST);
                break;
            case SOUTH:
                nextRoom = currentRoom.getRoom(Direction.SOUTH);
                break;
            case UNKNOWN:
                break;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            lastRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(getLocationInfo());
        }
    }

    /**
     * @return Detail of the current room information + the exits
     */
    private String getLocationInfo() {

        StringBuilder info = new StringBuilder();
        info.append("You are " + currentRoom.getDescription() + '\n');
        info.append(isPortkey());
        info.append("Exits: ");
        // get the possible directions that player can go
        info.append(currentRoom.getPossibleExits());

        return info.toString();
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else { return true; }  // signal that we want to quit
    }

    /**
     * "Look" was entered
     *  print out - the room the user is at
     *            - all the possible door
     */
    private void lookAround(){
        System.out.println(getLocationInfo());
    }

    /**
     * "Back" was entered.
     * move to the last room the user was in
     * also give the information about the room + the exits
     */
    private void goBack() {
        if (lastRoom != null) {
            currentRoom = lastRoom;
            lookAround();
        } else {
            System.out.println("you've just arrived here!");
        }
    }

    /**
     * User has entered the portkey room
     * @return the room description that the user is teleported to
     */
    private String isPortkey(){
        if(currentRoom.portkey) {
            int randomRoomNum = (int) (Math.random() * allRoom.length - 1);
            currentRoom = allRoom[randomRoomNum];
            return ".\n.\n.\nNow you are " + allRoom[randomRoomNum].getDescription() + "!\n";
        }
        return "";
    }

}
