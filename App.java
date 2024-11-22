import java.util.*;

public class App {
    public static Room currentRoom;
    public static roomConnector currentRoomConnector;
 
    private static int moves = 0;
    private static boolean finish = false;
    public static void main(String[] args) {

        Room Starter = new RoomBuilder("Entrance room", "Empty", null)
                            .canMoveForward()
                            .canMoveLeft()
                            .canMoveRight()
                            .build();
        Room room1 = new RoomBuilder("Dark room", "Puzzle", null)
                            .canMoveForward()  
                            .canMoveBackward()
                            .build();
        Room room2 = new RoomBuilder("Dark room2", "Puzzle", null)
                            .canMoveForward()  
                            .canMoveRight()
                            .build();
        Room room3 = new RoomBuilder("Dark room3", "Puzzle", null)
                            .canMoveForward()  
                            .canMoveLeft()
                            .build();                             


        roomConnector StarterConnector = new roomConnector(Starter, room1, room2, room3, null);
        Starter.setRoomConnector(StarterConnector);
        roomConnector room1Connector = new roomConnector(room1, null, null, null, Starter);
        room1.setRoomConnector(room1Connector);
        roomConnector room2Connector = new roomConnector(room2, null, null, Starter, null);
        room2.setRoomConnector(room2Connector);
        roomConnector room3Connector = new roomConnector(room3, null, Starter, null, null);
        room3.setRoomConnector(room3Connector);


        moves move = new moves();

        Scanner sc = new Scanner(System.in);

        currentRoom = Starter;

        System.out.println("The year is 2133. Earth has fallen. Cities have been taken by surviving gangs and scavengers. Remaining civilian survivors must gather supplies to continue to survive. \n You turn on your issued surveying device... \n INPUT NAME ");
        String input = sc.next();
        System.out.println("GREETINGS, " + input + ". \nYOU ARE TASKED WITH SURVEYING [ABANDONED BUILDING 332K] FOR POTENTIAL RESOURCES AND SUPPLIES. \nDO NOT FAIL. YOUR COLONY DEPENDS ON YOU.");
        
        while(!finish){

            System.out.println("You stand in the " + currentRoom.getName() + ". ");
            System.out.println("         1 - Scan");
            System.out.println("         2 - Forward");
            System.out.println("3 - Left                4 - Right");
            System.out.println("         5 - Backward");

            int input2 = Integer.parseInt(sc.next());;

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
