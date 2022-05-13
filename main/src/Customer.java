
import java.lang.*;
import java.util.*;

class Customer {
    private final String name;

    private final List<Rental> rentals = new ArrayList<>();

    public Customer (String newname){
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }
    public String getName (){
        return name;
    }
    public String statement() {

        double totalAmount = rentals.stream().mapToDouble(this::amountFor).sum();

        long frequentRenterPoints = rentals.size() +
                // add bonus for a two day new release rental
                rentals.stream()
                        .filter(rental -> rental.getDaysRented() > 1)
                        .filter(rental -> rental.getMovie().getPriceCode() == MovieType.NEW_RELEASE)
                        .count();

        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n")
                .append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        rentals.stream()
                        .map(rental -> "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + amountFor(rental) + "\n")
                        .forEach(result::append);

        //add footer lines
        result.append("Amount owed is ").
                append(totalAmount).
                append("\n").
                append("You earned ").
                append(frequentRenterPoints).
                append(" frequent renter points");

        return result.toString();
    }

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case REGULAR -> {
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
            }
            case NEW_RELEASE -> thisAmount += each.getDaysRented() * 3;
            case CHILDREN -> {
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
            }
        }
        return thisAmount;
    }

}
    