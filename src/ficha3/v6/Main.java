package ficha3.v6;

public class Main {

    /***********************************************************
     * @param args
     ***********************************************************/
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("John Doe");

        // Create some movies
        Movie m1 = new Movie("The Matrix", Movie.Code.REGULAR);
        Movie m2 = new Movie("Toy Story", Movie.Code.CHILDRENS);
        Movie m3 = new Movie("Avengers: Endgame", Movie.Code.NEW_RELEASE);

        // Create rentals for the customer
        Rental r1 = new Rental(m1, 3); // regular, 3 days
        Rental r2 = new Rental(m2, 4); // children's, 4 days
        Rental r3 = new Rental(m3, 2); // new release, 2 days (extra points)

        // Add rentals to the customer
        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);

        // Print the plain text statement
        System.out.println("Plain text statement:\n" + customer.statement());

        // Print the HTML formatted statement
        System.out.println("\nHTML formatted statement:\n" + customer.htmlStatement());

        // Print the calculated total amount and frequent renter points
        System.out.println("\nTotal Amount: " + customer.getTotalAmount());
        System.out.println("Total Frequent Renter Points: " + customer.getTotalFrequentRenterPoints());
    }
}
