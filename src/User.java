/**
 * Concrete User agent
 * */
import java.util.Scanner;

public class User extends Player {

    public User(Deck deck) {
        super(deck);
    }

    public Card playCard(Card cardOnTopOfPile) {
        int i = 0;

        // Display User's current hand
        System.out.println("User's current hand:");
        for (int j = 0; j < super.getNumberOfCardsInHand(); j++) {
            System.out.println(j + ": " + super.printCardInHand(j));
        }

        // Get a card number from the User, repeating if it's not a legal choice.
        // Return null if the user has chosen to pick up a card, signalling to Game
        // to invoke the pickUpCard method
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nPlease choose a card number, or -1 to pick up a card:");
            i = scanner.nextInt();
            while (i < -1 || i >= super.getNumberOfCardsInHand()) {
                System.out.println("Invalid card number... Try again");
                i = scanner.nextInt();
            }
            if (i == -1) {
                System.out.println("The User just picked up a card \n");
                return null;
            }
        } while (!super.canCardBePlayed(super.getCard(i), cardOnTopOfPile));

        // Display which card has been played and return it
        Card cardToPlay = super.getCard(i);
        System.out.print("The User has played: ");
        System.out.println(super.printCardInHand(i));
        super.playCard(i);
        System.out.println("There are " + super.getNumberOfCardsInHand() + " cards left in the User's hand. \n");
        return cardToPlay;
    }
}