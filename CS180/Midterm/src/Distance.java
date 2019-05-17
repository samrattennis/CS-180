/**
 * Question 3 - Numerical Data
 */

public class Distance {

    public static double distanceTravelled(double initialVelocity,
                                           double acceleration, double travelTime) {
        return initialVelocity * travelTime + 0.5 * acceleration * Math.pow(travelTime, 2);
    }
}
