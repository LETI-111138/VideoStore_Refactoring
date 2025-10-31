package ficha3.v9;

public class NewReleasePrice extends Price {

    @Override
    public double getRentalAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}