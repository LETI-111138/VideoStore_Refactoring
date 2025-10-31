package ficha3.v8;

public class Price {

    public enum Code { REGULAR, CHILDRENS, NEW_RELEASE }

    private Code _code;

    public Price(Code code) {
        _code = code;
    }

    public Code getCode() {
        return _code;
    }

    public double getRentalAmount(int daysRented) {
        double result = 0;
        switch (_code) {
            case REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;

            case NEW_RELEASE:
                result += daysRented * 3;
                break;

            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (_code == Code.NEW_RELEASE && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}