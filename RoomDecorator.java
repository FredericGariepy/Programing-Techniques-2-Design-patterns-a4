package src;
// https://www.baeldung.com/java-decorator-pattern
public abstract class RoomDecorator implements Room {

    protected Room decoratedRoom;

    public RoomDecorator(Room decoratedRoom) {
        this.decoratedRoom = decoratedRoom;
    }

    @Override
    public int getPrice() {
        return decoratedRoom.getPrice();
    }

    @Override
    public String getDescription() {
        return decoratedRoom.getDescription();
    }

    @Override
    public boolean getReservationStatus() {
        return decoratedRoom.getReservationStatus();
    }

    @Override
    public boolean reserveTheRoom() {
        return decoratedRoom.reserveTheRoom();
    }
}
