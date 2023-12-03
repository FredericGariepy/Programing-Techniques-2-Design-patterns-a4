package src;

public class DeluxeRoom implements Room{

    private boolean reserved = false;
    @Override
    public int getPrice() {
        return RoomType.DELUXE.getPrice();
    }

    @Override
    public String getDescription() {
        return RoomType.DELUXE.getDescription();
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
