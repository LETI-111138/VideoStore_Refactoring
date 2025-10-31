package ficha3.v3;

import v2.Movie;
import v2.Rental;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    // Extracted Method for frequent rental points
    public int getFrequentRentalPoints(Rental each) {
        int frequentRenterPoints = 1; // regular points

        // add bonus for a two day new release rental
        if (each.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE && each.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            // Direct call to getAmount() instead of using temp variable
            double thisAmount = each.getAmount();

            // Get frequent renter points using the extracted method
            frequentRenterPoints += getFrequentRentalPoints(each);

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // Add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}