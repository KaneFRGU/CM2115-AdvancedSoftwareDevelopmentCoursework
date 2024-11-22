public class Room {
    private String name;
    private String type;

    roomConnector roomConnector;
    private boolean canForward, canBackward, canLeft, canRight, isBattle, isPuzzle;
    public Room forwardRoom, leftRoom, rightRoom, backRoom;

    public Room(RoomBuilder builder) {
        this.name = builder.getName();
        this.type = builder.getType();
        this.roomConnector = builder.getRoomConnector();
        this.canForward = builder.getCanForward();
        this.canBackward = builder.getCanBackward();
        this.canLeft = builder.getCanLeft();
        this.canRight = builder.getCanRight();
        this.isBattle = builder.getIsBattle();
        this.isPuzzle = builder.getIsPuzzle();
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

    public roomConnector getRoomConnector() {
        return roomConnector;
    }

    public void setRoomConnector(roomConnector roomConnector) {
        this.roomConnector = roomConnector;
    }

    public boolean isCanForward() {
        return canForward;
    }

    public void setCanForward(boolean canForward) {
        this.canForward = canForward;
    }

    public boolean isCanBackward() {
        return canBackward;
    }

    public void setCanBackward(boolean canBackward) {
        this.canBackward = canBackward;
    }

    public boolean isCanLeft() {
        return canLeft;
    }

    public void setCanLeft(boolean canLeft) {
        this.canLeft = canLeft;
    }

    public boolean isCanRight() {
        return canRight;
    }

    public void setCanRight(boolean canRight) {
        this.canRight = canRight;
    }

    public boolean isBattle() {
        return isBattle;
    }

    public void setBattle(boolean isBattle) {
        this.isBattle = isBattle;
    }

    public boolean isPuzzle() {
        return isPuzzle;
    }

    public void setPuzzle(boolean isPuzzle) {
        this.isPuzzle = isPuzzle;
    }

    public static RoomBuilder builder() {
        return new RoomBuilder("", "", null);
      }

    
}
