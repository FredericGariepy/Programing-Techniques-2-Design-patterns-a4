package src;

public class WithView extends RoomDecorator{

    public WithView(Room decoratedRoom){
        super(decoratedRoom);
    }
    @Override
    public int getPrice(){
        return  super.getPrice()+50;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + View";
    }


}
