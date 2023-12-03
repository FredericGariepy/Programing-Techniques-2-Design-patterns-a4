package src;

public class DoubleRoom implements Room{
    private boolean reserved = false;
    @Override
    public int getPrice() {
        return RoomType.DOUBLE.getPrice();
    }

    @Override
    public String getDescription() {
        return RoomType.DOUBLE.getDescription();
    }

    @Override
    public boolean getReservationStatus() {
        return reserved;
    }

    @Override
    public boolean reserveTheRoom() {
        if(!reserved){
            reserved = true;
            return reserved;
        }
        return reserved;
    }
}
