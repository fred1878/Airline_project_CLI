import flights.Flight;
import flights.FlightBoard;
import passenger.PassengerManager;

import java.util.Objects;
import java.util.Scanner;

public class Airline {
    Scanner scanner;
    PassengerManager passengerManager;
    boolean exit;
    FlightBoard flightBoard;

    public Airline(){
        this.scanner = new Scanner(System.in);
        this.passengerManager = new PassengerManager();
        this.exit = false;
        this.flightBoard = new FlightBoard();
    }

    public void start(){
        System.out.println("Welcome to the app, enter your name");
        String userName = scanner.nextLine();
        while(!exit){
            System.out.println("\n" + "Hello " + userName + " Choose an option:" + "\n" + "\n" + "exit - exit the app" + "\n" + "addpassenger - add a passenger"+ "\n" +
                    "displaylounge - display passengers not on flights" + "\n" + "displayflights - display all flights" + "\n" + "addflight - add a flight" + "\n" +
                    "cancelflight - cancel a flight" + "\n" + "addtoflight - add a passenger to a flight");
            String option = scanner.nextLine();
            switch(option) {
                case "addpassenger":
                    System.out.println("Add a name");
                    String name = scanner.nextLine();
                    System.out.println("Add contact info");
                    int contactInfo = scanner.nextInt();
                    passengerManager.createPassenger(name, contactInfo);
                    System.out.println("Added " + name +" to lounge");
                    break;
                case "displaylounge":
                    System.out.println(passengerManager.getPassengerLounge());
                    break;
                case "displayflights":
                    System.out.println(flightBoard.getFlights());
                    break;
                case "addflight":
                    System.out.println("Add a destination");
                    String destination = scanner.nextLine();
                    flightBoard.addFlight(destination);
                    System.out.println("Added flight to " + destination);
                    break;
                case "cancelflight":
                    System.out.println(flightBoard.getFlights());
                    System.out.println("Would you like to cancel by 'id' or 'destination' ?");
                    String s = scanner.nextLine();
                    if(Objects.equals(s, "id")){
                        System.out.println("Choose a flight id");
                        int id = scanner.nextInt();
                        flightBoard.cancelFlight(id);
                        System.out.println("Flight with id: " + id + " cancelled");
                        break;
                    } else if(Objects.equals(s, "destination")){
                        System.out.println("Choose a flight destination");
                        String dest = scanner.nextLine();
                        flightBoard.cancelFlight(dest);
                        System.out.println("Flight to " + dest + " cancelled");
                        break;
                    } else {
                        System.out.println("Choose 'id' or 'destination'");
                        break;
                    }
                case "addtoflight":
                    System.out.println(passengerManager.getPassengerLounge());
                        System.out.println("Choose a passenger id");
                        int passid = scanner.nextInt();
                        System.out.println(flightBoard.getFlights());
                        System.out.println("Choose a flight id");
                        int f = scanner.nextInt();
                        Flight flight = flightBoard.getFlight(f);
                        flight.addPassengerToFlight(passengerManager.getPassengerFromId(passid));
                        System.out.println("Passenger: " + passid + " booked on flight to " + flight.getDestination());
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a command");
            }
        }
    }
}
