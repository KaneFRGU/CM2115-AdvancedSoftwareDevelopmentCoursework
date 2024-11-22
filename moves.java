import java.util.*;
public class moves{

    public void scanRoom(){
        if(App.currentRoom.getType() == "Empty"){
            System.out.println("The room is... empty. Nothing valuable to be found here. I should go deeper.");
        }
        else if(App.currentRoom.getType() == "Puzzle"){
            System.out.println("The room is filled with strange contraptions. Investigate?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if(input == "1" ){
                System.out.println("ok yes");
            }
            if(input == "2" ){
                System.out.println("ok no");
            }
            else{
                scanRoom();
            }
        }
        else if(App.currentRoom.getType() == "Battle"){
            System.out.println("The room is... empty. Nothing valuable to be found here. I should go deeper.");
        }
    }

    public void moveForward(){
        if(App.currentRoom.isCanForward()){
            System.out.println("You move forward towards the next room.");
            App.currentRoom = App.currentRoom.roomConnector.forwardRoom;
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveLeft(){
        if(App.currentRoom.isCanLeft()){
            System.out.println("You move left towards another room.");
            App.currentRoom = App.currentRoom.roomConnector.leftRoom;
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveRight(){
        if(App.currentRoom.isCanRight()){
            System.out.println("You move right towards another room.");
            App.currentRoom = App.currentRoom.roomConnector.rightRoom;
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveBackward(){
        if(App.currentRoom.isCanBackward()){
            System.out.println("You move back towards another room.");
            App.currentRoom = App.currentRoom.roomConnector.backRoom;
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
}
