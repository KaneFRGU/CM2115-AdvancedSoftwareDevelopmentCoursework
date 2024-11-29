import java.util.*;
public class moves{

    private Player player;


    public moves(Player player) {
        this.player = player;
    }

    public void scanRoom(){

        RoomEvent event = new RoomEvent();
        if(App.currentRoom.locked == true){
            App.currentRoom.accept(event);
        }
        else{
            System.out.println("The room is... empty. Nothing valuable to be found here. I should go deeper.");
        }
    }

    public void moveForward(){
        if(App.currentRoom.forwardRoom != null && App.currentRoom.locked == false){
            System.out.println("You move forward towards the next room.");
            App.currentRoom = App.currentRoom.forwardRoom;
        }
        if(App.currentRoom.locked){
            System.out.println("The doors seem to be locked");
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveLeft(){
        if(App.currentRoom.leftRoom != null && App.currentRoom.locked == false){
            System.out.println("You move left towards another room.");
            App.currentRoom = App.currentRoom.leftRoom;
        }
        if(App.currentRoom.locked){
            System.out.println("The doors seem to be locked");
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveRight(){
        if(App.currentRoom.rightRoom != null && App.currentRoom.locked == false){
            System.out.println("You move right towards another room.");
            App.currentRoom = App.currentRoom.rightRoom;
        }
        if(App.currentRoom.locked){
            System.out.println("The doors seem to be locked");
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveBackward(){
        if(App.currentRoom.backRoom != null && App.currentRoom.locked == false){
            System.out.println("You move back towards another room.");
            App.currentRoom = App.currentRoom.backRoom;
        }
        if(App.currentRoom.locked){
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
}
