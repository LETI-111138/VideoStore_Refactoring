package ficha3.v5;

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

    // Refactored statement() method
    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            // Direct call to getAmount() instead of using temp variable
            double thisAmount = each.getAmount();

            // Get frequent renter points from Rental (moved method)
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        // Add footer lines
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    // New method to calculate total amount
    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : _rentals) {
            totalAmount += each.getAmount();
        }
        return totalAmount;
    }

    // New method to calculate total frequent renter points
    public int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : _rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}