import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import flights.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import passenger.Passenger;

public class FlightTest {

    Passenger Jack;
    Passenger Adan;
    Flight flight1;

    @BeforeEach
    public void setUp(){
        Jack = new Passenger("Jack",1234);
        Adan = new Passenger("Adan", 5678);
        flight1 = new Flight("Amsterdam");
    }

    @Test
    public void hasName(){
        assertThat(flight1.getDestination()).isEqualTo("Amsterdam");
    }

    @Test
    public void hasId(){
        assertThat(flight1.getFlightId()).isNotNull();
        assertThat(flight1.getFlightId()).isNotNegative();
        assertThat(flight1.getFlightId()).isLessThan(100001);
    }

    @Test
    public void canAddPassenger(){
        flight1.addPassengerToFlight(Jack);
        flight1.addPassengerToFlight(Adan);
        assertThat(flight1.getPassengers().size()).isEqualTo(2);
    }

    @Test
    public void canRemovePassenger(){
        flight1.addPassengerToFlight(Jack);
        flight1.addPassengerToFlight(Adan);
        assertThat(flight1.getPassengers().size()).isEqualTo(2);
        flight1.removePassengerFromFlight(Jack);
        assertThat(flight1.getPassengers().size()).isEqualTo(1);
    }

    @Test
    //supposed to fail
    public void cannotAddDuplicatePassenger(){
        flight1.addPassengerToFlight(Jack);
        flight1.addPassengerToFlight(Jack);
        assertThat(flight1.getPassengers().size()).isEqualTo(1);
    }

    @Test
    public void cannotRemovePassengerNotOnFlight(){
        flight1.removePassengerFromFlight(Jack);
        assertThat(flight1.getPassengers().size()).isEqualTo(0);
    }
}
