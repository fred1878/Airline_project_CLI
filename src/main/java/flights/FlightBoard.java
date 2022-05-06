package flights;

import java.util.ArrayList;
import java.util.Objects;

public class FlightBoard {

    ArrayList<Flight> flights;


    public FlightBoard(){
        flights = new ArrayList<>();
    }

    public String getFlights(){
        String flightString = "";
        for(int i = 0; i< flights.size();i++){
            Flight f = flights.get(i);
            flightString += "Flight to: " + f.getDestination() + " Id: " + f.getFlightId() + "\n";
        }
        return flightString;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void addFlight(String destination){
        Flight flight = new Flight(destination);
        flights.add(flight);
    }

    public void cancelFlight(Flight flight){
        flights.remove(flight);
    }

    public Flight getFlight(String input) {
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            if (Objects.equals(f.getDestination(), input)) {
                return f;
            }
        } return null;
    }

    public Flight getFlight(int input) {
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            if (Objects.equals(f.getFlightId(), input)) {
                return f;
            }
        } return null;
    }

    public void cancelFlight(String input) {
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            if (Objects.equals(f.getDestination(), input)) {
                flights.remove(f);
            } else {
                System.out.println("Flight not found");
            }
        }
    }

    public void cancelFlight(int input) {
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            if (f.getFlightId() == input) {
                flights.remove(f);
            } else {
                System.out.println("Flight not found");
            }
        }
    }

    public ArrayList<Flight> getAllFlightsList(){
        return flights;
    }
}
