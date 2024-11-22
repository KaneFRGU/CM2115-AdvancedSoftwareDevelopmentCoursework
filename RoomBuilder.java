public class RoomBuilder {

    private String name;
    private String type;
    private roomConnector roomConnector;
    private Boolean canForward = false, canBackward = false, canLeft = false, canRight = false, isPuzzle = false, isBattle = false;

    public roomConnector getRoomConnector() {
            return roomConnector;
    }

    public void setRoomConnector(roomConnector roomConnector) {
        this.roomConnector = roomConnector;
    }

    public Boolean getIsPuzzle() {
        return isPuzzle;
    }

    public void setIsPuzzle(Boolean isPuzzle) {
        this.isPuzzle = isPuzzle;
    }

    public Boolean getIsBattle() {
        return isBattle;
    }

    public void setIsBattle(Boolean isBattle) {
        this.isBattle = isBattle;
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

    public Boolean getCanForward() {
        return canForward;
    }

    public void setCanForward(Boolean canForward) {
        this.canForward = canForward;
    }

    public Boolean getCanBackward() {
        return canBackward;
    }

    public void setCanBackward(Boolean canBackward) {
        this.canBackward = canBackward;
    }

    public Boolean getCanLeft() {
        return canLeft;
    }

    public void setCanLeft(Boolean canLeft) {
        this.canLeft = canLeft;
    }

    public Boolean getCanRight() {
        return canRight;
    }

    public void setCanRight(Boolean canRight) {
        this.canRight = canRight;
    }

    public RoomBuilder(String name, String type, roomConnector roomConnector) {
        this.roomConnector = roomConnector;
        this.name = name;
        this.type = type;
    }

    public RoomBuilder canMoveForward(){
        this.canForward = true;
        return this;
    };
    public RoomBuilder canMoveBackward(){
        this.canBackward = true;
        return this;
    };
    public RoomBuilder canMoveLeft(){
        this.canLeft = true;
        return this;
    };
    public RoomBuilder canMoveRight(){
        this.canRight = true;
        return this;
    };
    public RoomBuilder isPuzzle(){
        this.isPuzzle = true;
        return this;
    }
    public RoomBuilder isBattle(){
        this.isPuzzle = true;
        return this;
    }


    public Room build(){
        return new Room(this);
    }

}
