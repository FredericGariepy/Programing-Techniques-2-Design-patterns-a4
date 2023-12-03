package src;

public class SingleRoom implements Room{

    private boolean reserved = false;
    @Override
    public int getPrice() {
        return RoomType.SINGLE.getPrice();
    }

    @Override
    public String getDescription() {
        return RoomType.SINGLE.getDescription();
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
