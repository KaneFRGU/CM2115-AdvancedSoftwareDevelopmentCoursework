import java.util.Scanner;

public class PuzzleRoom extends Room implements IPuzzle{
    private int int1;
    private int int2;
    private int int3;
    
    public PuzzleRoom(String name, int roomLevel, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom, Player player) {
        super(name, roomLevel, locked, forwardRoom, leftRoom, rightRoom, backRoom, player);
    }

    @Override
    public void accept(RoomEventVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public void showPuzzle(){
        
        System.out.println("The room is filled with strange contraptions. Investigate?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input == 1){
            int1 = (int)(Math.random() * (100 - 1)) + 1;
            int2 = (int)(Math.random() * (100 - 1)) + 1;
            int3 = int1 + int2;
            System.out.println("A command screen flashes open. The text reads:");
            System.out.println("What is " + int1 + " + " + int2 + "?");
            int input2 = sc.nextInt();
            
            if(input2 == int3){
                System.out.println("The screen flashes green and you hear the door unlock!");
                App.currentRoom.setLocked(false);
                prize();

            }
            else{
                System.out.println("Wrong! The contraption shocks you!");
                player.health -= 10;
            }
        }
        if(player.getHealth() <= 0){
            System.out.println("YOU DIED");
            System.out.println("GAME OVER");
            App.finish = true;
        }
           
    }

    public void prize(){
        Scanner sc = new Scanner(System.in);
        System.out.println("You hear a click come from a locked drawer. The drawer opens!");
        if (roomLevel == 1){
            int prizeNo = (int)(Math.random() * (3));
            Weapon newWeapon = App.level2Weapons[prizeNo];
            System.out.println("You got the " + newWeapon.getName() + "! Take it?");
            System.out.println("1 - YES");
            System.out.println("2 - NO");
            int input = sc.nextInt();
            if (input == 1){
                System.out.println("You take the " + newWeapon.getName() + ".");
                player.setWeapon(newWeapon);
            }
            if(input == 2){
                System.out.println("You leave the " + newWeapon.getName() + ".");
            }
            System.out.println("Yoo also found medicine. +20HP +1000 SCORE");
            player.health += 20;
            player.score += 1000;
        }
        else if (roomLevel == 2){
            int prizeNo = (int)(Math.random() * (3));
            Weapon newWeapon = App.level3Weapons[prizeNo];
            System.out.println("You got the " + newWeapon.getName() + "! Take it?");
            System.out.println("1 - YES");
            System.out.println("2 - NO");
            int input = sc.nextInt();
            if (input == 1){
                System.out.println("You take the " + newWeapon.getName() + ".");
                player.setWeapon(newWeapon);
            }
            if(input == 2){
                System.out.println("You leave the " + newWeapon.getName() + ".");
            }
            System.out.println("Yoo also found medicine. +20HP +2000 SCORE");
            
            player.score += 2000;
            player.health += 20;
        }
    }
}
