public class roomConnector{

    public Room forwardRoom;
    public Room leftRoom;
    public Room rightRoom;
    public Room backRoom;
    
    
    public roomConnector(Room room, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom) {
        this.forwardRoom = forwardRoom;
        this.leftRoom = leftRoom;
        this.rightRoom = rightRoom;
        this.backRoom = backRoom;
    }   
    public Room getForwardRoom() {
        return forwardRoom;
    }

    public void setForwardRoom(Room forwardRoom) {
        this.forwardRoom = forwardRoom;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
    }

    public Room getBackRoom() {
        return backRoom;
    }

    public void setBackRoom(Room backRoom) {
        this.backRoom = backRoom;
    }

}
