package ficha3.v5;

public class Main {

    /***

     @param args***/
    public static void main(String[] args) {
        Customer customer = new Customer("Joe");

        Movie m1 = new Movie("The Matrix", Movie.Code.REGULAR);
        Movie m2 = new Movie("Toy Story", Movie.Code.CHILDRENS);
        Movie m3 = new Movie("Avengers: Endgame", Movie.Code.NEW_RELEASE);

        Rental r1 = new Rental(m1, 3); // regular, 3 dias
        Rental r2 = new Rental(m2, 4); // infantil, 4 dias
        Rental r3 = new Rental(m3, 2); // lançamento, 2 dias (pontos extras)

        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);

        // Testando a saída da função statement() após as alterações
        System.out.println(customer.statement());

        // Verificando se o cálculo do totalAmount e frequentRenterPoints está correto:
        System.out.println("Total Amount: " + customer.getTotalAmount());
        System.out.println("Total Frequent Renter Points: " + customer.getTotalFrequentRenterPoints());
    }
}