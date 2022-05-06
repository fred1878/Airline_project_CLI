package flights;

import idgen.FlightIdGen;
import passenger.Passenger;

import java.util.ArrayList;

public class Flight {

    String destination;
    int FlightId;
    ArrayList<Passenger> passengers;

    public Flight(String destination){
        this.destination = destination;
        this.passengers = new ArrayList<>();
        this.FlightId =  FlightIdGen.genFlightId();
    }



    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightId() {
        return FlightId;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassengerToFlight(Passenger passenger){
        try{
            if(!passengers.contains(passenger)) {
                passengers.add(passenger);
            } else {
                throw new Exception("Passenger already on flight");
            }
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    public void removePassengerFromFlight(Passenger passenger){
        try{
            if(passengers.contains(passenger)) {
                passengers.remove(passenger);
            } else {
                throw new Exception("Passenger not on flight");
            }
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
