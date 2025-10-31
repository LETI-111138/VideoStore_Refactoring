package ficha3.v5;

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

    // Calculates the amount for this rental (matches UML's getAmount)
    public double getAmount() {
        double result = 0;
        Movie.Code code = _movie.getPriceCode();

        switch (code) {
            case REGULAR:
                result += 2;
                if (_daysRented > 2) {
                    result += (_daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += _daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (_daysRented > 3) {
                    result += (_daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    // Moved frequent-renter-points logic here (no parameter)
    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        if (_movie.getPriceCode() == Movie.Code.NEW_RELEASE && _daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}