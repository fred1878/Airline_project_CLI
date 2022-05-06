package idgen;

import java.util.ArrayList;
import java.util.List;

public class PassengerIdGen {
    private static List<Integer> allPassengerIds = new ArrayList<>();

    public static int genPassengerId(){
        int newPassengerId = (int)(Math.random()*100000);
        if(!allPassengerIds.contains(newPassengerId)){
            allPassengerIds.add(newPassengerId);
            return newPassengerId;
        } else {
            return genPassengerId();
        }
    }
}
