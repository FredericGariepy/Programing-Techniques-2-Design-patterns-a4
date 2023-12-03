package src;
import java.util.Scanner;
// Frederic Gariepy 12.03.2023
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Please enter the name for your hotel: ");
        Scanner scanner = new Scanner(System.in);
        String hotelName =  scanner.nextLine();
        Hotel myHotel = new Hotel(hotelName);
        int choice = 0;
        RoomType roomType = null;
        boolean roomBuilderActivity = true;

        // Room builder activity
        while(roomBuilderActivity){

            roomBuilderMenu(hotelName); // Display room type choices
            choice = scanner.nextInt();

            // Room Builder, chose a RoomType
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
                case 4: roomBuilderActivity = false; // breaks out of the room builder while loop
            }

            // feature builder, chose features
            Boolean withView = false;
            Boolean withNetflix = false;
            while (choice!=4){
                featureMenu(); // Display feature options
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        if(withView){featureAlreadyPresent();}
                        else{
                            withView = true;
                        }
                        break;
                    case 2:
                        if(withNetflix){featureAlreadyPresent();}
                        else {
                            withNetflix = true;
                        }
                        break;
                    case 3:
                        break; // Do nothing
                    case 4:
                        break; // Escape out of while loop
                }
            }

            if(roomBuilderActivity){
                // Create the room
                Room newRoom = myHotel.factory.createRoom(roomType); // Factory pattern with Room type
                if(withView) { // room View feature
                    newRoom = new WithView(newRoom); // Decorator pattern
                }
                if(withNetflix){ // room Netlfix feature
                    newRoom = new WithNetflixAccess(newRoom); // Decorator pattern
                }
                // add the new room
                myHotel.addRooms(newRoom);
            }
            //reset variables
            choice = 0;
            roomType = null;
        }// END of Room Builder

        Boolean customerActivity = true;
        //Customer activity
        while(choice!=4){
            currentRoomStatus(myHotel); // show current rooms
            customerMenu();
            choice = scanner.nextInt();


            boolean reverseSucess = false;
            switch (choice){
                /*
                * In retrospect, I wish I did this slightly differently,
                * Since I am using a decorator,
                * an object of the class src.SingleRoom
                * when decorated with View (for example)
                * that same object will become class src.WithView...
                * Because of this, I cannot simply case-out using Classes
                * Instead I must build cases with .contains(String)
                * */
                case 1:
                    for(Room room: myHotel.hotelRooms){
                        if(room.getDescription().contains("Single")){
                            if(!room.getReservationStatus()){
                                room.reserveTheRoom();
                                reverseSucess = true;
                                break;
                            }
                        }
                    }
                    isReservationSuccessful(reverseSucess);
                    break;
                case 2:
                    for(Room room: myHotel.hotelRooms){
                        if(room.getDescription().contains("Double")){
                            if(!room.getReservationStatus()){
                                room.reserveTheRoom();
                                reverseSucess = true;
                                break;
                            }
                        }
                    }
                    isReservationSuccessful(reverseSucess);
                    break;
                case 3:
                    for(Room room: myHotel.hotelRooms){
                        if(room.getDescription().contains("Deluxe")){
                            if(!room.getReservationStatus()){
                                room.reserveTheRoom();
                                reverseSucess = true;
                                break;
                            }
                        }
                    }
                    isReservationSuccessful(reverseSucess);
                    break;
                case 4:
                    System.out.print(myHotel.getRevenue());
            }
        }//END of Customer Activity
    }// END of Main()



    // BELLOW IS ALL DISPLAY TEXT  --------------
    static void roomBuilderMenu(String hotelName){
        System.out.println("Welcome to " + hotelName + " hotel maker. Please select the room you would like to have in your hotel:");
        System.out.println("1: "+ RoomType.SINGLE.description+" $"+RoomType.SINGLE.price);
        System.out.println("2: "+ RoomType.DOUBLE.description+" $"+RoomType.DOUBLE.price);
        System.out.println("3: "+ RoomType.DELUXE.description+" $"+RoomType.DELUXE.price);
        System.out.println("4: Done, go to reservation");
    }

    static void featureMenu(){
        System.out.println("What feature the room has?");
        System.out.println("1: With view $50");
        System.out.println("2: With Netflix access $20");
        System.out.println("3: Nothing");
        System.out.println("4: Done");
    }

    static void featureAlreadyPresent(){
        System.out.println("Sorry you already have this feature.");
    }

    static void currentRoomStatus(Hotel hotel){
        System.out.println("Current rooms status: [");
        for(Room room: hotel.hotelRooms){
            System.out.println("Type="+room.getDescription()+", Price="+room.getPrice()+", isReserved?="+room.getReservationStatus());
        }
        System.out.println("]");
    }

    static void customerMenu(){
        System.out.println("Hi customer, what room would you like?:");
        System.out.println("1: Single Room");
        System.out.println("2: Double Room");
        System.out.println("3: Deluxe Room");
        System.out.println("4: Done, show hotel revenue");
    }

    static void isReservationSuccessful(boolean bool) {
        if (bool) {System.out.println("Reservation successful\n");}
        else{System.out.println("The room is not available\n");}
    }
}
