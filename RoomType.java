package src;

import java.lang.reflect.Type;

// https://www.w3schools.com/java/java_enums.asp
public enum RoomType {
    SINGLE(50, "Single room",SingleRoom.class),
    DOUBLE(90, "Double room",DoubleRoom.class),
    DELUXE(110, "Deluxe room",DeluxeRoom.class);

    public final int price;
    public final String description;

    public final Class<? extends Room> roomClass;

    // each type of room extends the room class
    //public final Class<?> roomClass; Class<?> roomClass; this.roomClass = roomClass;

    RoomType(int price, String description, Class<? extends Room> roomClass){
        this.price = price;
        this.description = description;
        this.roomClass = roomClass;
    }

    public int getPrice(){
        return price;
    }

    public String getDescription() {
        return description;
    }

}
