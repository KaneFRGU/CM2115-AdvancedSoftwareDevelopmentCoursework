public class BattleRoom extends Room implements IBattle {

    private Enemy enemy;
    
    public BattleRoom(String name, String type, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom,
            Room backRoom, Enemy enemy) {
        super(name, type, locked, forwardRoom, leftRoom, rightRoom, backRoom);
        this.enemy = enemy;
    }

    @Override
    public void accept(RoomEventVisitor visitor){
        visitor.visit(this);
    }

    public void showBattle(){
        System.out.println("");
    }


}
