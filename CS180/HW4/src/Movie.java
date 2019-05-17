import java.util.*;
public class Movie {

    private String name;
    private double criticRating;
    private double usersRating;
    private int numUsersRatings;
    private double smartScore;

    public Movie(String name, double criticRating, double usersRating, int numUsersRatings) {
        this.name = name;
        if (criticRating > 1 && criticRating <= 5) {
            this.criticRating = criticRating;
        } else {
            this.criticRating = 5.0;
        }
        if (usersRating > 1 && usersRating <= 5) {
            this.usersRating = usersRating;
        } else {
            this.usersRating = 5.0;
        }
        this.numUsersRatings = numUsersRatings;
    }
    public String getName() {
        return name;
    }
    public double getCriticRating() {
        return criticRating;
    }
    public double getUsersRating() {
        return usersRating;
    }
    public int getNumUsersRatings() {
        return  numUsersRatings;
    }

    public int reviewRange(int numUsersRatings) {
        int reviewRange = 0;
        if (numUsersRatings >= 0 && numUsersRatings <= 1000) {
            return 1;
        }
        else if (numUsersRatings >= 1001 && numUsersRatings <= 5000) {
            return 2;
        }
        else if (numUsersRatings >= 5001 && numUsersRatings <= 10000) {
            return 3;
        }
        else if (numUsersRatings >= 10001 && numUsersRatings <= 15000) {
            return 4;
        }
        else if (numUsersRatings >= 15001 && numUsersRatings <= 20000) {
            return 5;
        }
        else if (numUsersRatings >= 20001 && numUsersRatings <= 25000) {
            return 6;
        }
        else if (numUsersRatings >= 25001 && numUsersRatings <= 30000) {
            return 7;
        }
        else if (numUsersRatings >= 30001 && numUsersRatings <= 50000) {
            return 8;
        }
        else if (numUsersRatings >= 50001 && numUsersRatings <= 100000) {
            return 9;
        }
        else if (numUsersRatings > 100000) {
            return 10;
        } else {

            return reviewRange;
        }
    }
    public boolean addUserRating(int newRating) {
    if (newRating >= 1 && newRating <= 5) {
        usersRating = (usersRating * numUsersRatings) + newRating;
        numUsersRatings++;
        usersRating = usersRating / numUsersRatings;
        return true;
    } else {
        return false;
        }
    }

    public static int compareMovies(Movie movie1, Movie movie2) {
        if (movie1.criticRating > movie2.criticRating) {
            if (movie1.usersRating >= movie2.usersRating) {
                return 1;
            } else {
                double smartScore1;
                double smartScore2;

                smartScore1 = 0.5 * movie1.criticRating + 0.3 * movie1.usersRating + 0.1 * movie1.reviewRange(movie1.numUsersRatings);
                smartScore2 = 0.5 * movie2.criticRating + 0.3 * movie2.usersRating + 0.1 * movie2.reviewRange(movie2.numUsersRatings);

                if (smartScore1 > smartScore2) {
                    return 1;
                } else if (smartScore2 > smartScore1) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }

        if (movie2.criticRating > movie1.criticRating) {
            if (movie2.usersRating >= movie1.usersRating) {
                return 2;
            } else {
                double smartScore1;
                double smartScore2;

                smartScore1 = 0.5 * movie1.criticRating + 0.3 * movie1.usersRating + 0.1 * movie1.reviewRange(movie1.numUsersRatings);
                smartScore2 = 0.5 * movie2.criticRating + 0.3 * movie2.usersRating + 0.1 * movie2.reviewRange(movie2.numUsersRatings);

                if (smartScore1 > smartScore2) {
                    return 1;
                } else if (smartScore2 > smartScore1) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }

        if (movie1.criticRating == movie2.criticRating) {
            if (movie1.usersRating > movie2.usersRating) {
                return 1;
            } else if (movie2.usersRating > movie1.usersRating) {
                return 2;
            } else {
                return 0;
            }
        }
        return 0;
    }
}
