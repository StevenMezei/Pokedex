
import type.Effectiveness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EffectivenessTest {
    private Effectiveness effectiveness;



    @BeforeEach
    public void createStartingList(){
        effectiveness = new Effectiveness();
    }

    @Test
    public void testSingleType(){
        ArrayList waterList = new ArrayList<>();
        waterList.add("Water");
        effectiveness.setResistances(waterList);
        ArrayList correctList = new ArrayList<>();
        correctList.add(4);
        correctList.add(2);
        correctList.add(2);
        correctList.add(8);
        correctList.add(8);
        correctList.add(2);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(2);
        correctList.add(4);
        assertEquals(effectiveness.getDefEff(),correctList);
    }
    @Test
    public void testDoubleType(){
        ArrayList waterflyinglist = new ArrayList<>();
        waterflyinglist.add("Water");
        waterflyinglist.add("Flying");
        effectiveness.setResistances(waterflyinglist);
        ArrayList correctList = new ArrayList<>();
        correctList.add(4);
        correctList.add(2);
        correctList.add(2);
        correctList.add(4);
        correctList.add(16);
        correctList.add(4);
        correctList.add(2);
        correctList.add(4);
        correctList.add(0);
        correctList.add(4);
        correctList.add(4);
        correctList.add(2);
        correctList.add(8);
        correctList.add(4);
        correctList.add(4);
        correctList.add(4);
        correctList.add(2);
        correctList.add(4);
        assertEquals(effectiveness.getDefEff(),correctList);
    }
}
