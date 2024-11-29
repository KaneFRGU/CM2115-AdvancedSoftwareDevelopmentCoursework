import java.util.*;

public class App {
    public static Room currentRoom;
    
    private static boolean finish = false;
    public static Player player;
    public static Weapon[] level2Weapons = {new Weapon("Liberty 9mm", 2, 20),
                                            new Weapon("X-2 Kenshin 9mm", 2, 25),
                                            new Weapon("Overture Revolver", 2, 30)
                                            };
    public static Weapon[] level3Weapons = {new Weapon("Mantis Blades", 3, 30),
                                            new Weapon("Cyber Blade", 3, 35),
                                            new Weapon("Militech Rasetsu .50", 3, 35)
                                            };
    
        public static void main(String[] args) {
    
            RoomEvent event = new RoomEvent();
            Weapon knife = new Weapon("Knife", 1, 10);    
            Player player = new Player(null, 100, knife);

            Enemy scavengerA = new Enemy("Scavenger grunt", 1, 30, 7);
            Enemy scavengerB = new Enemy("Scavenger Brute", 2, 60, 10);
            Enemy scavengerC = new Enemy("Scavenger Leader", 3, 100, 15);
         
            Enemy maelstromA = new Enemy("Maelstrom grunt", 1, 30, 7);
            Enemy maelstromB = new Enemy("Maelstrom Brute", 2, 60, 10);
            Enemy maelstromC = new Enemy("Maelstrom Leader", 3, 100, 15);
    
            Room Starter = new PuzzleRoom("Entrance Room", 1, false, null, null, null, null, player);
            Room room1 = new PuzzleRoom("Room 1", 1, true, null, null, null, null, player);
            Room room2 = new BattleRoom("Room 2", 1, true, null, null, null, null, player, scavengerA);
            Room room3 = new BattleRoom("Room 3", 1, true, null, null, null, null, player, maelstromA);
    
            Starter.setForwardRoom(room1); Starter.setLeftRoom(room2); Starter.setRightRoom(room3);
            room1.setBackRoom(Starter); 
            room2.setRightRoom(Starter);
            room3.setLeftRoom(Starter);
    
            Scanner sc = new Scanner(System.in);
            
            
            currentRoom = Starter;
            

        System.out.println("The year is 2133. Earth's governments have fallen. Cities have been taken by surviving gangs and scavengers. Remaining civilian survivors must gather supplies to continue to survive. \n You turn on your issued surveying device... \n INPUT NAME ");
        String input = sc.next();
        player.setName(input);
        System.out.println("GREETINGS, " + player.getName() + ". \nYOU ARE TASKED WITH SURVEYING [ABANDONED BUILDING 332K] FOR POTENTIAL RESOURCES AND SUPPLIES. \nDO NOT FAIL. YOUR COLONY DEPENDS ON YOU.");
        moves move = new moves(player);
        while(!finish){

            if(player.getHealth() > 100){
                player.health = 100;
            }
            System.out.println("You stand in the " + currentRoom.getName() + ". ");
            System.out.println("1 - Scan");
            System.out.println("2 - Forward");
            System.out.println("3 - Left");
            System.out.println("4 - Right");
            System.out.println("5 - Backward");
            System.out.println("6 - Check Stats");

            int input2 = Integer.parseInt(sc.next());

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
            else if(input2 == 6){
                move.checkStats();
            }
        }
    }
}
