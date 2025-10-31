package ficha3.v4;

/***********************************************************
 * Filename: Main.java
 * @author fba 6 de Mai de 2013
 ***********************************************************/
public class Main
{

    /***********************************************************
     * @param args
     ***********************************************************/
    public static void main(String[] args)
    {
        Customer customer = new Customer("Bailan Ball");

        Movie m1 = new Movie("The Matrix", Movie.Code.REGULAR);
        Movie m2 = new Movie("Toy Story", Movie.Code.CHILDRENS);
        Movie m3 = new Movie("Avengers: Endgame", Movie.Code.NEW_RELEASE);

        Rental r1 = new Rental(m1, 3); // regular, 3 days
        Rental r2 = new Rental(m2, 4); // childrens, 4 days
        Rental r3 = new Rental(m3, 2); // new release, 2 days (bonus point)

        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);

        System.out.println(customer.statement());
    }
}