import java.util.*;

public class App {
    Room currentRoom;
    public static void main(String[] args) {
        
        Room Starter = new RoomBuilder("Entrance room", "Empty")
                            .canMoveForward()  
                            .canMoveLeft()
                            .canMoveRight()
                            .build();

                            
        
        Room currentRoom = Starter;

        Scanner sc = new Scanner(System.in);

        System.out.println("The year is 2133. Earth has fallen. Cities have been taken by surviving gangs and scavengers. Remaining civilian survivors must gather supplies to continue to survive. \n You turn on your issued surveying device... \n INPUT NAME ");
        String input = sc.next();
        System.out.println("GREETINGS, " + input + ". \nYOU ARE TASKED WITH SURVEYING [ABANDONED BUILDING 332K] FOR POTENTIAL RESOURCES AND SUPPLIES. \nDO NOT FAIL. YOUR COLONY DEPENDS ON YOU.");
        System.out.println("You stand in the " + currentRoom.getName() + ". ");
        System.out.println("1 - Scan");
        System.out.println("2 - Forward");
        System.out.println("3 - Left");
        System.out.println("4 - Right");
        System.out.println("5 - Backward");
        

        int input2 = sc.nextInt();
        if (input2 == 1){

        }
    }
}
