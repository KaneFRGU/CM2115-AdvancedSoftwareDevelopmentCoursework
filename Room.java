public class Room {
    private String name;
    private String type;
    private boolean canForward, canBackward, canLeft, canRight;

    public Room(RoomBuilder builder) {
        this.name = builder.getName();
        this.type = builder.getType();
        this.canForward = builder.getCanForward();
        this.canBackward = builder.getCanBackward();
        this.canLeft = builder.getCanLeft();
        this.canRight = builder.getCanRight();
    }

    
}
