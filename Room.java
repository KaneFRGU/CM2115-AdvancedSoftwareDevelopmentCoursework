public class Room {
    private String name;
    private String type;
    public boolean locked;
    public Room forwardRoom;
    public Room leftRoom;
    public Room rightRoom;
    public Room backRoom;

    public Room(String name, String type, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom, Room backRoom) {
        this.name = name;
        this.type = type;
        this.locked = locked;
        this.forwardRoom = forwardRoom;
        this.leftRoom = leftRoom;
        this.rightRoom = rightRoom;
        this.backRoom = backRoom;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
