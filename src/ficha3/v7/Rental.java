package ficha3.v7;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    // Delegate to Movie.getRentalAmount(int)
    public double getAmount() {
        return _movie.getRentalAmount(_daysRented);
    }

    // Delegate to Movie.getFrequentRenterPoints(int)
    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}