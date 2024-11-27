import java.util.*;
public class moves{

    public void scanRoom(){

        RoomEvent event = new RoomEvent();

        if(App.currentRoom.locked == true){
            System.out.println("The doors must have locked once i stepped in.");
        }
        if(App.currentRoom.getType() == "empty"){
            System.out.println("The room is... empty. Nothing valuable to be found here. I should go deeper.");
        }
        else if(App.currentRoom.getType() == "puzzle"){
            System.out.println("The room is filled with strange contraptions. Investigate?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if(input == 1){
                App.currentRoom.accept(event);
            }
            if(input == 2){
                System.out.println("ok no");
            }
            else{
                scanRoom();
            }
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
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveLeft(){
        if(App.currentRoom.leftRoom != null && App.currentRoom.locked == false){
            System.out.println("You move left towards another room.");
            App.currentRoom = App.currentRoom.leftRoom;
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
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveBackward(){
        if(App.currentRoom.backRoom != null && App.currentRoom.locked == false){
            System.out.println("You move back towards another room.");
            App.currentRoom = App.currentRoom.backRoom;
        }
        else{
            System.out.println("Cant go that way.");
        }
    
    }
    public void checkStats(){
        System.out.println("NAME: " + App.player.getName());
        System.out.println("HEALTH: " + App.player.getHealth());
        System.out.println("WEAPON: " + App.player.getDamage());
    }
}
