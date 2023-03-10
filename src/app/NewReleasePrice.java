package app;

public class NewReleasePrice extends Price {
    public double getCharge(int daysRented) {
        return (double) (daysRented * 3);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
