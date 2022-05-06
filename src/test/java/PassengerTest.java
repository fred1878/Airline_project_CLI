import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import passenger.Passenger;

public class PassengerTest {

    Passenger Jack;
    Passenger Adan;

    @BeforeEach
    public void setUp(){
        Jack = new Passenger("Jack",1234);
        Adan = new Passenger("Adan", 5678);
    }

    @Test
    public void hasName(){
        assertThat(Jack.getName()).isEqualTo("Jack");
    }

    @Test
    public void hasId(){
        assertThat(Jack.getPassId()).isNotNegative();
        assertThat(Jack.getPassId()).isNotNull();
        assertThat(Jack.getPassId()).isLessThan(100001);
    }
}
