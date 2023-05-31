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
    private String description;
    private HashMap<Direction, Room> roomDirection;
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

    public void setToPortkey()
    {
        this.portkey = true;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExits(String direction, Room neighbour) {
        Directions directions = new Directions();
        if (directions.isDirection(direction)) {
            roomDirection.put(directions.getDirection(direction), neighbour);
        }
        else {
            System.out.println("There is no such direction");
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param direction user want to go
     * @return the room that is located at that direction
     */
    public Room getRoom(Direction direction){
        return roomDirection.get(direction);
    }

    public String getPossibleExits() {

        StringBuilder directionstr = new StringBuilder();
        for (HashMap.Entry<Direction, Room> entry : this.roomDirection.entrySet()) {
            Direction direction = entry.getKey();
            switch (direction) {
                case NORTH:
                    directionstr.append("north up ");
                    break;
                case SOUTH:
                    directionstr.append("south down ");
                    break;
                default:
                    directionstr.append(direction.toString().toLowerCase() + ' ');
            }
        }
        return directionstr.toString();
    }

}
