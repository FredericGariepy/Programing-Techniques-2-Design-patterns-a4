package src;

public class WithNetflixAccess extends RoomDecorator{

    public WithNetflixAccess(Room decoratedRoom){
        super(decoratedRoom);
    }

    @Override
    public int getPrice(){
        return  super.getPrice()+10;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + Netflix Access";
    }
}
