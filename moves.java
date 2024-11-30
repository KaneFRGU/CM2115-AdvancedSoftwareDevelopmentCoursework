import java.util.*;
public class moves{

    private Player player;


    public moves(Player player) {
        this.player = player;
    }

    public void scanRoom(){
        
        RoomEvent event = new RoomEvent();
        if(App.currentRoom.isLocked()){
            App.currentRoom.accept(event);
        }
        else{
            System.out.println("The room is... empty. Nothing valuable to be found here. I should go deeper.");
        }
    }

    public void moveForward(){
        if(App.currentRoom.getForwardRoom() != null && App.currentRoom.isLocked() == false){
            System.out.println("You move forward towards the next room.");
            App.currentRoom = App.currentRoom.getForwardRoom();
        }
        else if(App.currentRoom.isLocked()){
            System.out.println("The doors seem to be locked");
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveLeft(){
        if(App.currentRoom.getLeftRoom() != null && App.currentRoom.isLocked() == false){
            System.out.println("You move left towards another room.");
            App.currentRoom = App.currentRoom.getLeftRoom();
        }
        else if(App.currentRoom.isLocked()){
            System.out.println("The doors seem to be locked");
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveRight(){
        if(App.currentRoom.getRightRoom() != null && App.currentRoom.isLocked() == false){
            System.out.println("You move right towards another room.");
            App.currentRoom = App.currentRoom.getRightRoom();
        }
        else if(App.currentRoom.isLocked()){
            System.out.println("The doors seem to be locked");
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveBackward(){
        if(App.currentRoom.getBackRoom() != null && App.currentRoom.isLocked() == false){
            System.out.println("You move back towards another room.");
            App.currentRoom = App.currentRoom.getBackRoom();
        }
        else if(App.currentRoom.isLocked()){
            System.out.println("The doors seem to be locked");
        }
        else{
            System.out.println("Cant go that way.");
        }
    
    }
    public void checkStats(){
        System.out.println("NAME: " + player.getName());
        System.out.println("HEALTH: " + player.getHealth());
        System.out.println("WEAPON: " + player.getWeapon().getName());
        System.out.println("    LEVEL: " + player.getWeapon().getLevel());
        System.out.println("    DAMAGE: " + player.getWeapon().getDamage());
    }

    public void moveset(){
        Scanner sc = new Scanner(System.in);
        if(player.getHealth() > 100){
            player.health = 100;
        }
        System.out.println("You stand in the " + App.currentRoom.getName() + ". ");
        
        System.out.println("1 - Scan");
        if(App.currentRoom.getForwardRoom() != null){
            System.out.println("2 - Forward");
        }
        if(App.currentRoom.getLeftRoom() != null){
            System.out.println("3 - Left");
        }
        if(App.currentRoom.getRightRoom() != null){
            System.out.println("4 - Right");
        }
        if(App.currentRoom.getBackRoom() != null){
            System.out.println("5 - Backward");
        }
        System.out.println("6 - Check Stats");

        int input2 = Integer.parseInt(sc.next());

        if (input2 == 1){
            scanRoom();
        }
        else if(input2 == 2){
            moveForward();
        }
        else if(input2 == 3){
            moveLeft();
        }
        else if(input2 == 4){
            moveRight();
        }
        else if(input2 == 5){
            moveBackward();
        }
        else if(input2 == 6){
            checkStats();
        }
    }
}
