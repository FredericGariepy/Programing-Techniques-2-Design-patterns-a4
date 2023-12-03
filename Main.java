package src;

public class Main {
    public static void main(String[] args) throws Exception {

        RoomFactory factory = new RoomFactory();

        Room single1 = factory.createRoom(RoomType.SINGLE);
        //Room double1 = factory.createRoom(RoomType.DOUBLE);
        //Room deluxe1 = factory.createRoom(RoomType.DELUXE);

        System.out.println();
        System.out.println(single1.getReservationStatus());
        single1.reserveTheRoom();
        System.out.println(single1.getReservationStatus());

        System.out.println(single1.getDescription());
        System.out.println(single1.getPrice());

        Room singleRoom1WithView = new WithView(single1);
        System.out.println(singleRoom1WithView.getDescription());
        System.out.println(singleRoom1WithView.getPrice());

        Room singleRoom1WithNetflixAndView = new WithNetflixAccess(singleRoom1WithView);
        System.out.println(singleRoom1WithNetflixAndView.getDescription());
        System.out.println(singleRoom1WithNetflixAndView.getPrice());

    }
}