import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UltimateRoom extends Room implements IBattle, IPuzzle {

    private Enemy enemy;
    private int int1;
    private int int2;
    private int int3;

    public UltimateRoom(String name, int roomLevel, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom, Player player, Enemy enemy) {
        super(name, roomLevel, locked, forwardRoom, leftRoom, rightRoom, backRoom, player);
        this.enemy = enemy;
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

            }
            else{
                System.out.println("Wrong! The contraption shocks you!");
                player.health -= 10;
            }
        }
           
    }

    @Override
    public void showBattle(){
        Scanner sc = new Scanner(System.in);
        boolean battle = true;

        System.out.println("A " + enemy.getName() + " Bursts through the door and attacks!");

        while(battle){

            System.out.println("What do you do?");
            System.out.println("1 - ATTACK ROLL");
            System.out.println("2 - CHECK STATS");

            int input2 = sc.nextInt();

            if(input2 == 1){
                int damage = (int)(Math.random() * (player.getWeapon().getDamage() - player.getWeapon().getDamage()/2)) + player.getWeapon().getDamage()/2;
                System.out.println("You attack using your " + player.getWeapon().getName() + "!");
                System.out.println(enemy.getName() + " takes -" + damage + "!");
                enemy.setHealth(enemy.getHealth() - damage);
            }

            else if(input2 == 2){
                System.out.println("NAME: " + player.getName());
            }
            if (enemy.getHealth() > 0){
                System.out.println("The " + enemy.getName() + " attacks you!");
                int enemyDamage = (int)(Math.random() * (enemy.getDamage() - enemy.getDamage()/2)) + enemy.getDamage()/2;
                player.health -= enemyDamage;
                System.out.println("You take -" + enemyDamage + " damage!");
            }
            else{
                System.out.println("The " + enemy.getName() + " perishes! You won! +3000 SCORE");
                battle = false;
                player.score += 3000;
                App.currentRoom.setLocked(false);
                App.finish = true;
                System.out.println("After defeating the " + enemy.getName() + ", you collect as much materials from the " + getName() + " and escape the building.");
                System.out.println("YOU WIN!");
                System.out.println("FINAL SCORE: " + player.score);
            }  
        }
    }


    
}
