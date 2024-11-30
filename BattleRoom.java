import java.util.Scanner;

public class BattleRoom extends Room implements IBattle {

    private Enemy enemy;
    
    public BattleRoom(String name, int roomLevel, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom, Player player, Enemy enemy) {
        super(name, roomLevel, locked, forwardRoom, leftRoom, rightRoom, backRoom, player);
        this.enemy = enemy;
    }

    @Override
    public void accept(RoomEventVisitor visitor){
        visitor.visit(this);
    }

    public void showBattle(){
        System.out.println("You can hear noises coming from behind a wall. Investigate?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input == 1){
            boolean battle = true;

            System.out.println("They must've heard you! A " + enemy.getName() + " Jumps out and attacks!!");

            while(battle){
                if(player.getHealth() <= 0){
                    System.out.println("YOU DIED");
                    System.out.println("GAME OVER");
                    App.finish = true;
                    break;
                }
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
                    System.out.println("The " + enemy.getName() + " perishes! You won!");
                    System.out.println("The enemy drops their weapon!");
                    if (roomLevel == 1){
                        int prizeNo = (int)(Math.random() * (2 - 0)); //chooses a random prize from 3 options
                        Weapon newWeapon = App.level2Weapons[prizeNo];
                        System.out.println("You got the " + newWeapon.getName() + "! Take it?");
                        System.out.println("1 - YES");
                        System.out.println("2 - NO");
                        int input3 = sc.nextInt();
                        if (input3 == 1){
                            System.out.println("You take the " + newWeapon.getName() + ".");
                            player.setWeapon(newWeapon);
                        }
                        if(input3 == 2){
                            System.out.println("You leave the " + newWeapon.getName() + ".");
                        }
                        System.out.println("Yoo also found medicine. +20HP +1000 SCORE");
                        player.score += 1000;
                        player.health += 20;
                    }
                    else if (roomLevel == 2){
                        int prizeNo = (int)(Math.random() * (2 - 0)); //chooses a random prize from 3 options
                        Weapon newWeapon = App.level3Weapons[prizeNo];
                        System.out.println("You got the " + newWeapon.getName() + "! Take it?");
                        System.out.println("1 - YES");
                        System.out.println("2 - NO");
                        int input3 = sc.nextInt();
                        if (input3 == 1){
                            System.out.println("You take the " + newWeapon.getName() + ".");
                            player.setWeapon(newWeapon);
                        }
                        if(input3 == 2){
                            System.out.println("You leave the " + newWeapon.getName() + ".");
                        }
                        System.out.println("Yoo also found medicine. +20HP +2000 SCORE");
                        player.score += 1000;
                        player.health += 20;
                    }
                    battle = false;
                    App.currentRoom.setLocked(false);
                }

                

                
            }
        }
    }

    public void prize(){
        Scanner sc = new Scanner(System.in);
        System.out.println("You hear a click come from a locked drawer. The drawer opens!");
        if (roomLevel == 1){
            int prizeNo = (int)(Math.random() * (2 - 0));
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
            System.out.println("Yoo also found medicine. +20HP");
            player.health += 20;
        }
        else if (roomLevel == 2){
            int prizeNo = (int)(Math.random() * (2 - 0));
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
            System.out.println("Yoo also found medicine. +20HP");
            player.health += 20;
        }
    }
}
