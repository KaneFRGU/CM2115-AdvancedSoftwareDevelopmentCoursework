import java.util.*;

public class App {
    public Room currentRoom, forwardRoom, leftRoom, rightRoom, backRoom;
 
    private static int moves = 0;
    public static void main(String[] args) {

        Room Starter = new RoomBuilder("Entrance room", "Empty")
                            .canMoveForward()
                            .canMoveLeft()
                            .canMoveRight()
                            .build();
        Room room1 = new RoomBuilder("Dark room", "Puzzle")
                            .canMoveForward()  
                            .canMoveLeft()
                            .canMoveRight()
                            .canMoveBackward()
                            .build();
        Room room2 = new RoomBuilder("Dark room2", "Puzzle")
                            .canMoveForward()  
                            .canMoveLeft()
                            .canMoveRight()
                            .canMoveBackward()
                            .build();
        Room room3 = new RoomBuilder("Dark room3", "Puzzle")
                            .canMoveForward()  
                            .canMoveLeft()
                            .canMoveRight()
                            .canMoveBackward()
                            .build();                             

        Room currentRoom = Starter;
        Room forwardRoom = room1;
        Room leftRoom = room2;
        Room rightRoom = room3;
        Room backRoom = null;
        moves move = new moves(currentRoom, moves, forwardRoom, leftRoom, rightRoom, backRoom);

        Scanner sc = new Scanner(System.in);

        System.out.println("The year is 2133. Earth has fallen. Cities have been taken by surviving gangs and scavengers. Remaining civilian survivors must gather supplies to continue to survive. \n You turn on your issued surveying device... \n INPUT NAME ");
        String input = sc.next();
        System.out.println("GREETINGS, " + input + ". \nYOU ARE TASKED WITH SURVEYING [ABANDONED BUILDING 332K] FOR POTENTIAL RESOURCES AND SUPPLIES. \nDO NOT FAIL. YOUR COLONY DEPENDS ON YOU.");
        

        while(moves < 2){
            System.out.println("You stand in the " + move.currentRoom.getName() + ". ");
            System.out.println("1 - Scan");
            System.out.println("2 - Forward");
            System.out.println("3 - Left");
            System.out.println("4 - Right");
            System.out.println("5 - Backward");
            int input2 = sc.nextInt();
            if (input2 == 1){
                move.scanRoom();
            }
            else if(input2 == 2){
                move.moveForward();
            }
            else if(input2 == 3){
                move.moveLeft();
            }
            else if(input2 == 4){
                move.moveRight();
            }
            else if(input2 == 5){
                move.moveBackward();
            }
        }


    }
}
