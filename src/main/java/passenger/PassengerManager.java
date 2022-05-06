package passenger;

import java.util.ArrayList;
import java.util.Objects;

public class PassengerManager {

    ArrayList<Passenger> passengersWaiting;

    public PassengerManager(){
        passengersWaiting = new ArrayList<>();
    }

    public void createPassenger(String name, int contactInfo){
        Passenger passenger = new Passenger(name,contactInfo);
        passengersWaiting.add(passenger);
    }

    public ArrayList<Passenger> getPassengersWaiting() {
        return passengersWaiting;
    }

    public String getPassengerLounge(){
        String passString = "";
        for(int i = 0; i< passengersWaiting.size();i++){
            Passenger p = passengersWaiting.get(i);
            passString += "Name: " + p.getName() + " Id: " + p.getPassId() + "\n";
        }
        return passString;
    }

    public void addPassengerToLounge(Passenger passenger){
        passengersWaiting.add(passenger);
    }

    public void removePassengerFromLounge(Passenger passenger){
        passengersWaiting.remove(passenger);
    }

    public Passenger getPassengerFromId(int id){
        for(int i = 0; i< passengersWaiting.size();i++){
            Passenger p = passengersWaiting.get(i);
            try{
                if(Objects.equals(p.getPassId(),id)){
                    return p;
                } else {
                    throw new Exception("Passenger with that id not found");
                }
            } catch (Exception exception){
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
    }
        return null;
    }
}
