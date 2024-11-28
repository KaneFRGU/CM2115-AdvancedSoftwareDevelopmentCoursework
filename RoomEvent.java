import java.util.Scanner;

public class RoomEvent implements RoomEventVisitor {

    public void visit(PuzzleRoom puzzleRoom){
        puzzleRoom.showPuzzle();
    }
    
}
