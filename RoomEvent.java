import java.util.Scanner;

public class RoomEvent implements RoomEventVisitor {

    public void visit(PuzzleRoom puzzleRoom){
        puzzleRoom.showPuzzle();
    }
    public void visit(BattleRoom battleRoom){
        battleRoom.showBattle();
    }

}
