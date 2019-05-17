import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Student test cases for Q3 - Distance
 */
public class DistanceTest {

    @Test
    public void testDistanceTravelled0() {
        String message = "Distance:distanceTravelled test the correctness of your formula";
        assertEquals(message, 112, Distance.distanceTravelled(6, 2, 8), 0.1);
    }

    @Test
    public void testDistanceTraveleld1() {
        String message = "Distance:distanceTravelled test the correctness of your formula";
        assertEquals(message, 135, Distance.distanceTravelled(2, 10, 5), 0.1);

    }

    @Test
    public void testDistanceTraveleld2() {
        String message = "Distance:distanceTravelled test the correctness of your formula";
        assertEquals(message, 42930, Distance.distanceTravelled(0, 10.6, 90), 0.1);
    }

    @Test
    public void testDistanceTraveleld3() {
        String message = "Distance:distanceTravelled test the correctness of your formula";
        assertEquals(message, 1.225, Distance.distanceTravelled(0, 9.8, 0.5), 0.1);
    }


    @Test
    public void testDistanceTraveleld4() {
        String message = "Distance:distanceTravelled test the correctness of your formula";
        assertEquals(message, 16665.98, Distance.distanceTravelled(0, 9.8, 58.32), 0.1);

    }


}