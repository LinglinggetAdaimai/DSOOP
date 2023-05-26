import java.util.HashMap;

public class Directions {
    final HashMap<String, Direction> directionHashMap;

    public Directions(){

        directionHashMap = new HashMap<>();

        directionHashMap.put("north", Direction.NORTH);
        directionHashMap.put("up", Direction.NORTH);
        directionHashMap.put("east", Direction.EAST);
        directionHashMap.put("west", Direction.WEST);
        directionHashMap.put("south", Direction.SOUTH);
        directionHashMap.put("down", Direction.SOUTH);

    }

    public boolean isDirection(String secondword)
    {
        secondword = secondword.toLowerCase();
        return directionHashMap.containsKey(secondword);
    }

    public Direction getDirection(String secondword) {
        if (secondword != null) {
            secondword = secondword.toLowerCase();
            Direction directions = directionHashMap.get(secondword);
            if (directions != null) {
                return directions;
            }
        }
        return Direction.UNKNOWN;
    }
}
