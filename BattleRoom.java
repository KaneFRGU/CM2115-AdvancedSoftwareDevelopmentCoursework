import java.util.Scanner;

public class BattleRoom extends Room implements IBattle {

    private Enemy enemy;
    
    public BattleRoom(String name, int roomLevel, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom,
            Room backRoom, Player player, Enemy enemy) {
        super(name, roomLevel, locked, forwardRoom, leftRoom, rightRoom, backRoom, player);
        this.enemy = enemy;
    }

    @Override
    public void accept(RoomEventVisitor visitor){
        visitor.visit(this);
    }

    public void showBattle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("They must've heard you! A " + enemy.getName() + " Jumps out and attacks!!");
        System.out.println("What do you do?");
        System.out.println("1 - ATTACK ROLL");
        System.out.println("2 - CHECK STATS");
        int input = sc.nextInt();

        if(input == 2){
            System.out.println("NAME: " + player.getName());
        }

    }


}
