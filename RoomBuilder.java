public class RoomBuilder {

    private String name;
    private String type;
    private Boolean canForward;
    private Boolean canBackward;
    private Boolean canLeft;
    private Boolean canRight;


    public RoomBuilder(String name, String type) {
        this.name = name;
        this.type = type;
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

    public Room build(){
        return new Room(this);
    }

}