
public class moves{

    public Room currentRoom, forwardRoom, leftRoom, rightRoom, backRoom;
    public int moves = 0;

    

    public moves(Room currentRoom, int moves, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom) {
        this.currentRoom = currentRoom;
        this.moves = moves;
        this.forwardRoom = forwardRoom;
        this.leftRoom = leftRoom;
        this.rightRoom = rightRoom;
        this.backRoom = backRoom;
        
    }

    

    public void scanRoom(){
        if(currentRoom.getType() == "Empty"){
            System.out.println("The room is... empty. Nothing valuable to be found here. We should go deeper.");
        }
    }

    public void moveForward(){
        if(currentRoom.isCanForward()){
            System.out.println("You move forward towards the next room.");
            currentRoom = forwardRoom;
            
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveLeft(){
        if(currentRoom.isCanLeft()){
            System.out.println("You move left towards another room.");
            currentRoom = leftRoom;
            
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveRight(){
        if(currentRoom.isCanRight()){
            System.out.println("You move right towards another room.");
            currentRoom = rightRoom;
            
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
    public void moveBackward(){
        if(currentRoom.isCanBackward()){
            System.out.println("You move back towards another room.");
            currentRoom = backRoom;
            
        }
        else{
            System.out.println("Cant go that way.");
        }
    }
}
