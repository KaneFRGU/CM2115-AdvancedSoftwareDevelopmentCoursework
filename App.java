import java.util.*;

public class App {
    public static Room currentRoom;
    public static Player player;
    private static boolean finish = false;

    public static void main(String[] args) {

        RoomEvent event = new RoomEvent();

            Room Starter = new PuzzleRoom("Entrance Room", "puzzle", false, null, null, null, null);
            Room room1 = new PuzzleRoom("Room 1", "puzzle", true, null, null, null, null);
            Room room2 = new Room("Room 2", "puzzle", true, null, null, null, null);
            Room room3 = new Room("Room 3", "empty", true, null, null, null, null);
                            
        Player player = new Player(null, 100, 10);
    

        Starter.setForwardRoom(room1); Starter.setLeftRoom(room2); Starter.setRightRoom(room3);
        room1.setBackRoom(Starter);
        

        moves move = new moves();

        Scanner sc = new Scanner(System.in);

        currentRoom = Starter;

        System.out.println("The year is 2133. Earth has fallen. Cities have been taken by surviving gangs and scavengers. Remaining civilian survivors must gather supplies to continue to survive. \n You turn on your issued surveying device... \n INPUT NAME ");
        String input = sc.next();
        player.setName(input);
        System.out.println("GREETINGS, " + player.getName() + ". \nYOU ARE TASKED WITH SURVEYING [ABANDONED BUILDING 332K] FOR POTENTIAL RESOURCES AND SUPPLIES. \nDO NOT FAIL. YOUR COLONY DEPENDS ON YOU.");
        
        while(!finish){

            System.out.println("You stand in the " + currentRoom.getName() + ". ");
            System.out.println("1 - Scan");
            System.out.println("2 - Forward");
            System.out.println("3 - Left");
            System.out.println("4 - Right");
            System.out.println("5 - Backward");



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
