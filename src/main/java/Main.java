import flights.FlightBoard;

public class Main {

    public static void main(String[] args) {

        Airline airline = new Airline();
        airline.flightBoard.addFlight("Paris");
        airline.passengerManager.createPassenger("Jack",1234);
        airline.start();
    }
}
