public class App {
    Room currentRoom;
    public static void main(String[] args) {
        
        Room Starter = new RoomBuilder("Front Room", "empty")
                            .canMoveForward()  
                            .canMoveLeft()
                            .canMoveRight()
                            .build();
        
        Room currentRoom = Starter;

    }
}
