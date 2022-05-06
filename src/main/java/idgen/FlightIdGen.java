package idgen;

import java.util.ArrayList;
import java.util.List;

public class FlightIdGen {
    private static List<Integer> allFlightIds = new ArrayList<>();

    public static int genFlightId(){
        int newFlightId = (int)(Math.random()*100000);
        if(!allFlightIds.contains(newFlightId)){
            allFlightIds.add(newFlightId);
            return newFlightId;
        } else {
            return genFlightId();
        }
    }


}
