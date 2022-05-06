import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import flights.Flight;
import flights.FlightBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import passenger.Passenger;
import passenger.PassengerManager;

public class PassangerManagerTest {

    Passenger Jack;
    Passenger Adan;
    Flight flight1;
    Flight flight2;
    Flight flight3;
    FlightBoard flightBoard;
    PassengerManager passengerManager;

    @BeforeEach
    public void setUp(){
        Jack = new Passenger("Jack",1234);
        Adan = new Passenger("Adan", 5678);
        flight1 = new Flight("Amsterdam");
        flight2 = new Flight("Rome");
        flight3 = new Flight("London");
        flightBoard = new FlightBoard();
        passengerManager = new PassengerManager();
        passengerManager.addPassengerToLounge(Jack);
        passengerManager.addPassengerToLounge(Adan);
    }

    @Test
    public void passengerFromIdTest(){
        assertThat(passengerManager.getPassengerFromId(Jack.getPassId())).isNotNull();
    }
}
