import java.util.Scanner;

public class PuzzleRoom extends Room{
    
    public PuzzleRoom(String name, String type, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom) {
        super(name, type, locked, forwardRoom, leftRoom, rightRoom, backRoom);
    }

    public void accept(RoomEventVisitor visitor){
        visitor.visit(this);
    }

}
