package ficha3.v7;

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
            double thisAmount = each.getAmount();  // Direct call to getAmount()
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

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

    // New htmlStatement() method to generate the HTML formatted statement
    public String htmlStatement() {
        String result = "<h1>Rental Record for " + getName() + "</h1>\n";
        result += "<ul>";

        for (Rental each : _rentals) {
            double thisAmount = each.getAmount();
            result += "<li>" + each.getMovie().getTitle() + ": " + thisAmount + "</li>\n";
        }

        result += "</ul>\n";
        result += "<p>Amount owed is <strong>" + getTotalAmount() + "</strong></p>\n";
        result += "<p>You earned <strong>" + getTotalFrequentRenterPoints() + "</strong> frequent renter points</p>";
        return result;
    }
}