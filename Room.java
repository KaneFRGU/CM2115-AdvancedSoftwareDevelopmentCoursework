public abstract class Room {
    private String name;
    protected int roomLevel;
    private boolean locked;
    private  Room forwardRoom;
    private Room leftRoom;
    private Room rightRoom;
    private Room backRoom;
    protected Player player;


    public Room(String name, int roomLevel, boolean locked, Room forwardRoom, Room leftRoom, Room rightRoom,
            Room backRoom, Player player) {
        this.name = name;
        this.roomLevel = roomLevel;
        this.locked = locked;
        this.forwardRoom = forwardRoom;
        this.leftRoom = leftRoom;
        this.rightRoom = rightRoom;
        this.backRoom = backRoom;
        this.player = player;

    }

    public int getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(int roomLevel) {
        this.roomLevel = roomLevel;
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

    public void accept(RoomEventVisitor visitor){
    }

    
}
