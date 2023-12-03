package src;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> hotelRooms;
    RoomFactory factory;
    private String name = "Default";
    public Hotel(String name){
        this.name = name;
        hotelRooms = new ArrayList<>();
        factory = new RoomFactory();
    }
    void addRooms(Room room){
        hotelRooms.add(room);
    }

    boolean reverseRoom(RoomType roomType) {
        for (Room r : hotelRooms) {
            if (roomType.roomClass.isInstance(r)) {
                if(!r.getReservationStatus()){
                    r.reserveTheRoom();
                    return true;
                }
            }
        }
        return false;
    }

    int getRevenue(){
        int revenue = 0;
        for(Room r: hotelRooms){
            if(r.getReservationStatus()){
                revenue += r.getPrice();
            }
        }
        return revenue;
    }

    Hotel getInstance(){
        return Hotel.this;
    }

    //Just for debuging
    public ArrayList<Room> getRooms() {
        return hotelRooms;
    }

}
