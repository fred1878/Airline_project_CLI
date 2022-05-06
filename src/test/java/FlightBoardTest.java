import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import flights.Flight;
import flights.FlightBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import passenger.Passenger;

public class FlightBoardTest {

    Passenger Jack;
    Passenger Adan;
    Flight flight1;
    Flight flight2;
    Flight flight3;
    FlightBoard flightBoard;

    @BeforeEach
    public void setUp(){
        Jack = new Passenger("Jack",1234);
        Adan = new Passenger("Adan", 5678);
        flight1 = new Flight("Amsterdam");
        flight2 = new Flight("Rome");
        flight3 = new Flight("London");
        flightBoard = new FlightBoard();
    }

    @Test
    public void canAddFlights(){
        flightBoard.addFlight(flight1);
        assertThat(flightBoard.getAllFlightsList().size()).isEqualTo(1);
    }

    @Test
    public void canCancelFlights(){
        flightBoard.addFlight(flight1);
        flightBoard.cancelFlight(flight1);
        assertThat(flightBoard.getAllFlightsList().size()).isEqualTo(0);
    }

    @Test
    public void canSeeFlights(){
        flightBoard.addFlight(flight1);
        flightBoard.addFlight(flight2);
        flightBoard.addFlight(flight3);
        assertThat(flightBoard.getFlights()).isEqualTo(1);
    }

    @Test
    public void canGetFlightFromDestination(){
        flightBoard.addFlight(flight1);
        flightBoard.addFlight(flight2);
        flightBoard.addFlight(flight3);
        assertThat(flightBoard.getFlight("Rome")).isNotNull();
    }

    @Test
    public void canGetFlightFromId(){
        flightBoard.addFlight(flight1);
        flightBoard.addFlight(flight2);
        flightBoard.addFlight(flight3);
        assertThat(flightBoard.getFlight(flight1.getFlightId())).isNotNull();
    }
}
