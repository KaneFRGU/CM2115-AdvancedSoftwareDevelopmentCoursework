import java.util.Scanner;

public class RoomEvent implements RoomEventVisitor {
        public void visit(PuzzleRoom puzzleRoom){

            Scanner sc = new Scanner(System.in);
            int int1 = (int)(Math.random() * (100 - 1)) + 1;
            int int2 = (int)(Math.random() * (100 - 1)) + 1;
            int int3 = int1 + int2;
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
    }
}
