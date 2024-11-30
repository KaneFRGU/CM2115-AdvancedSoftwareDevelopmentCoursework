public interface RoomEventVisitor {
    void visit(PuzzleRoom puzzleroom);
    void visit(BattleRoom battleRoom);
    void visit(UltimateRoom ultimateRoom);
}
