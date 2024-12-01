import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class App {
    public static Room currentRoom;
    
    static boolean finish = false;
    public static Player player;

    //====================Storing weapons=====================

    public static Weapon[] level2Weapons = {new Weapon("Liberty 9mm", 2, 20),
                                            new Weapon("X-2 Kenshin 9mm", 2, 25),
                                            new Weapon("Overture Revolver", 2, 30)
                                            };
    public static Weapon[] level3Weapons = {new Weapon("Mantis Blades", 3, 30),
                                            new Weapon("Militech Rasetsu .50", 3, 35),
                                            new Weapon("E-9 Cynosure Erebus", 3, 35)
                                            };
    
        public static void main(String[] args) {

            //=============Displays highscore from highscore file==================
            
            //if there is a duplicate highscore, will display the first person to get the score.
            try {
                File file = new File("score.txt");
                Scanner sc = new Scanner(file);
                
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] nums = line.split(", ");
                    
                    int highScore = 0;
                    int highscorenumber = 0;

                    for(int i = 0; i < nums.length; ++i) {
                        int score = ((Number)NumberFormat.getInstance().parse(nums[i])).intValue(); //gets only the int value from the field

                        if(score > highScore){
                            highScore = score;
                            highscorenumber = i;
                        }
                    }
                    System.out.println("HIGH SCORE: " + nums[highscorenumber].replaceAll("[0-9]", "") + " - " + highScore);
                }
            } catch (FileNotFoundException | ParseException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
            //=================initializing objects===========================
            Weapon knife = new Weapon("Knife", 1, 10);    
            Player player = new Player (null, 100, knife);

            Enemy scavengerA = new Enemy("Scavenger grunt", 1, 30, 10);
            Enemy scavengerB = new Enemy("Scavenger Brute", 2, 60, 20);
            Enemy scavengerC = new Enemy("Scavenger Leader", 3, 100, 25);
         
            Enemy maelstromA = new Enemy("Maelstrom grunt", 1, 30, 10);
            Enemy maelstromB = new Enemy("Maelstrom Brute", 2, 60, 10);
            Enemy maelstromC = new Enemy("Maelstrom Leader", 3, 100, 25);
    
            //connected rooms set to null when rooms are initialized so the rooms that are to be connected actually exist.
            Room Starter = new PuzzleRoom("Entrance Room", 1, false, null, null, null, null, player);
            Room room1 = new PuzzleRoom("Server Room", 1, true, null, null, null, null, player);
            Room room2 = new BattleRoom("Office block", 1, true, null, null, null, null, player, scavengerA);
            Room room3 = new BattleRoom("Lab", 1, true, null, null, null, null, player, maelstromA);
            Room room1_1 = new BattleRoom("Engineering bay", 2, true, null, null, null, null, player, maelstromB);
            Room room1_2 = new UltimateRoom("Engineer's Lockup", 3, true, null, null, null, null, player, maelstromC);
            Room room2_1 = new PuzzleRoom("Manager's Office", 2, true, null, null, null, null, player);
            Room room2_2 = new UltimateRoom("Safe room", 3, true, null, null, null, null, player, scavengerC);
            Room room3_1 = new PuzzleRoom("Lab Storage", 2, true, null, null, null, null, player);
            Room room3_2 = new BattleRoom("Factory Floor", 3, true, null, null, null, null, player, scavengerB);
            Room room3_3 = new UltimateRoom("Lab Lockup", 3, true, null, null, null, null, player, scavengerC);
            
            //rooms are then connected by setting individually
            Starter.setForwardRoom(room1); Starter.setLeftRoom(room2); Starter.setRightRoom(room3);
            room1.setBackRoom(Starter); room1.setForwardRoom(room1_1);
            room2.setRightRoom(Starter); room2.setForwardRoom(room2_1);
            room3.setLeftRoom(Starter); room3.setForwardRoom(room3_1);
            room1_1.setForwardRoom(room1_2); room1_1.setBackRoom(room1);
            room2_1.setForwardRoom(room2_2); room2_1.setBackRoom(room2);
            room3_1.setForwardRoom(room3_2); room3_1.setBackRoom(room3);
            room3_2.setForwardRoom(room3_3); room3_2.setBackRoom(room3_1);

    
            Scanner sc = new Scanner(System.in);
            currentRoom = Starter;
            
        //========================START OF GAMEPLAY LOOP=============================

        System.out.println("The year is 2133. Earth's governments have fallen. Cities have been taken by surviving gangs and scavengers. Remaining civilian survivors must gather supplies to continue to survive. \n You turn on your issued surveying device... \n INPUT NAME ");
        String input = sc.next();
        player.setName(input);
        System.out.println("GREETINGS, " + player.getName() + ". \nYOU ARE TASKED WITH SURVEYING [ABANDONED BUILDING 332K] FOR POTENTIAL RESOURCES AND SUPPLIES. \nDO NOT FAIL. YOUR COLONY DEPENDS ON YOU.");
        moves move = new moves(player);

        while(!finish){
            move.moveset();
        }

        //writes score to score.txt file
        try {
            Files.write(Paths.get("score.txt"), (", " + player.getScore() + player.getName()).getBytes(), StandardOpenOption.APPEND);
        } 
        catch (IOException e) {
            System.out.println("An error occurred when writing to file.");
            e.printStackTrace();
        }
    }
}
