import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room
{
    public String description;
    public HashMap<String, Room> roomDirection;
    public boolean portkey;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        roomDirection = new HashMap<>();
    }

    public Room(String description, boolean portkey)
    {
        this.description = description;
        roomDirection = new HashMap<>();
        this.portkey = true;

    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExits(String direction, Room neighbour) {
        Directions directions = new Directions();
        if (directions.isDirection(direction)) {
            roomDirection.put(direction, neighbour);
        }
        else {
            System.out.println("There is no such direction");
        }
    }

    public boolean hasDoor(String direction) {
        return (roomDirection.get(direction)!= null);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
