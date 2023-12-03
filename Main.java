package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        boolean demoIsFinished = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the name for your hotel: ");
        String hotelName =  scanner.nextLine();
        Hotel myHotel = new Hotel(hotelName);
        int choice = 0;

        while(choice!=4){
            System.out.println("Welcome to " + hotelName + " hotel maker. Please select the room you would like to have in your hotel:");
            System.out.println("1: "+ RoomType.SINGLE.description+" $"+RoomType.SINGLE.price);
            System.out.println("2: "+ RoomType.DOUBLE.description+" $"+RoomType.DOUBLE.price);
            System.out.println("3: "+ RoomType.DELUXE.description+" $"+RoomType.DELUXE.price);
            System.out.println("4: Done, go to reservation");
            choice = scanner.nextInt();
            RoomType roomType;
            //Room newRoom;
            // assemble newRoom with room Type  Hotel.factory.newROom(etc...) and then wrap it with decorators before adding
            switch (choice){
                case 1:
                    roomType = RoomType.SINGLE;
                    break;
                case 2:
                    roomType = RoomType.DOUBLE;
                    break;
                case 3:
                    roomType = RoomType.DELUXE;
                    break;
            }

            //myHotel.factory.createRoom(RoomType.DOUBLE)

            while (choice!=4){
                System.out.println("What feature the room has?");
                System.out.println("1: With view $50");
                System.out.println("2: With Netflix access $20");
                System.out.println("3: Nothing");
                System.out.println("4: Done");
                choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        //if(newRoom.getDescription().contains())
                        break;
                    case 2:
                        //myHotel.addRooms(myHotel.factory.createRoom(RoomType.DOUBLE));
                        break;
                    case 3:
                        //myHotel.addRooms(myHotel.factory.createRoom(RoomType.DOUBLE));
                        break;
                    case 4:
                        choice =0;
                        break;
                }

            }

        }


//        int choice =  choice = scanner.nextInt();;
//        while (choice != 4){
//
//        }



//        Room single1 = factory.createRoom(RoomType.SINGLE);
//        //Room double1 = factory.createRoom(RoomType.DOUBLE);
//        //Room deluxe1 = factory.createRoom(RoomType.DELUXE);
//
//        System.out.println();
//        System.out.println(single1.getReservationStatus());
//        System.out.println(single1.getDescription());
//        System.out.println(single1.getPrice());
//
//        Room singleRoom1WithView = new WithView(single1);
//        System.out.println(singleRoom1WithView.getDescription());
//        System.out.println(singleRoom1WithView.getPrice());
//
//        Room singleRoom1WithNetflixAndView = new WithNetflixAccess(singleRoom1WithView);
//        System.out.println(singleRoom1WithNetflixAndView.getDescription());
//        System.out.println(singleRoom1WithNetflixAndView.getPrice());
//        System.out.println();
//
//        //Hotel myHotel = new Hotel("Sheraton");
//        myHotel.addRooms(single1);
//        System.out.println(single1.getReservationStatus());
//        System.out.println(myHotel.reverseRoom(RoomType.SINGLE));
//
//        Room single2 = factory.createRoom(RoomType.SINGLE);
//        System.out.println(myHotel.reverseRoom(RoomType.SINGLE));
//        myHotel.addRooms(single2);
//        System.out.println(myHotel.reverseRoom(RoomType.SINGLE));
//        //myHotel.reverseRoom(RoomType.SINGLE);
//
//        System.out.println(myHotel.getInstance());
//
//        System.out.println(myHotel.getRevenue());
//
    }
}
