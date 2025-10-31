package ficha3.v9;

public class Main {
    public static void main(String[] args) {

        // Criar o cliente
        Customer customer = new Customer("John Doe");

        // Criar filmes com diferentes tipos de preço
        Movie m1 = new Movie("The Matrix", new RegularPrice());  // Regular Price
        Movie m2 = new Movie("Toy Story", new ChildrensPrice()); // Childrens Price
        Movie m3 = new Movie("Avengers: Endgame", new NewReleasePrice()); // New Release Price

        // Criar alugueres
        Rental r1 = new Rental(m1, 3); // regular, 3 dias
        Rental r2 = new Rental(m2, 4); // infantil, 4 dias
        Rental r3 = new Rental(m3, 2); // novo lançamento, 2 dias

        // Associar alugueres ao cliente
        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);

        // Testar a saída em texto simples
        System.out.println("===== TEXT STATEMENT =====");
        System.out.println(customer.statement());

        // Testar a saída em HTML
        System.out.println("\n===== HTML STATEMENT =====");
        System.out.println(customer.htmlStatement());

        // Mostrar totais para verificação
        System.out.println("\n===== TOTALS =====");
        System.out.println("Total Amount: " + customer.getTotalAmount());
        System.out.println("Total Frequent Renter Points: " + customer.getTotalFrequentRenterPoints());
    }
}