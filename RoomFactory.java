package src;

public class RoomFactory {
    public Room createRoom(RoomType type) throws Exception{

       return type.roomClass.getDeclaredConstructor().newInstance();

    }

}
