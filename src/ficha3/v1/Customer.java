package ficha3.v1;

import java.util.Vector;

public class Customer
{
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name)
    {
        _name = name;
    }

    public void addRental(Rental arg)
    {
        _rentals.addElement(arg);
    }

    public String getName()
    {
        return _name;
    }

    // statement now delegates pricing and points to Rental
    public String statement()
    {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (int i = 0; i < _rentals.size(); i++) {
            Rental each = (Rental) _rentals.elementAt(i);

            double thisAmount = each.getCharge();
            frequentRenterPoints += each.getFrequentRenterPoints();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }
}