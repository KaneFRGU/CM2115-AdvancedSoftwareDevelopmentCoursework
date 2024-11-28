import java.util.Scanner;

public class PuzzleRoom extends Room implements IPuzzle{
    private int int1;
    private int int2;
    private int int3;
    
    public PuzzleRoom(String name, String type, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom) {
        super(name, type, locked, forwardRoom, leftRoom, rightRoom, backRoom);
    }

    @Override
    public void accept(RoomEventVisitor visitor){
        visitor.visit(this);
    }

    public void showPuzzle(){
        Scanner sc = new Scanner(System.in);
        int1 = (int)(Math.random() * (100 - 1)) + 1;
        int2 = (int)(Math.random() * (100 - 1)) + 1;
        int3 = int1 + int2;
        System.out.println("A command screen flashes open. The text reads:");
        System.out.println("What is " + int1 + " + " + int2 + "?");
        int input = sc.nextInt();
        
        if(input == int3){
            System.out.println("The screen flashes green and you hear the door unlock!");
            App.currentRoom.locked = false;
        }
        else{
            System.out.println("Wrong! The contraption shocks you!");
            int health = App.player.getHealth();
            health -= 10;
            App.player.setHealth(health);
        }   
        sc.close();
    }
}
