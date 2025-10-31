package ficha3.v8;

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

    // Gera o extrato de alugueres (formato texto)
    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            double thisAmount = each.getMovie().getPrice().getRentalAmount(each.getDaysRented());
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    // Calcula o valor total de todos os alugueres
    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : _rentals) {
            totalAmount += each.getMovie().getPrice().getRentalAmount(each.getDaysRented());
        }
        return totalAmount;
    }

    // Calcula o total de pontos de aluguer frequente
    public int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : _rentals) {
            frequentRenterPoints += each.getMovie().getPrice().getFrequentRenterPoints(each.getDaysRented());
        }
        return frequentRenterPoints;
    }

    // Gera o extrato de alugueres (formato HTML)
    public String htmlStatement() {
        String result = "<h1>Rental Record for " + getName() + "</h1>\n";
        result += "<ul>";

        for (Rental each : _rentals) {
            double thisAmount = each.getMovie().getPrice().getRentalAmount(each.getDaysRented());
            result += "<li>" + each.getMovie().getTitle() + ": " + thisAmount + "</li>\n";
        }

        result += "</ul>\n";
        result += "<p>Amount owed is <strong>" + getTotalAmount() + "</strong></p>\n";
        result += "<p>You earned <strong>" + getTotalFrequentRenterPoints() + "</strong> frequent renter points</p>";
        return result;
    }
}