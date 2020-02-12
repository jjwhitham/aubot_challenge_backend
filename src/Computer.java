/**
 * Concrete Computer agent
 * */
public class Computer extends Player {

    public Computer(Deck deck) {
        super(deck);
    }


    public Card playCard(Card cardOnTopOfPile) {
        // Pick random card, keeping track of hand indices not yet tested
        super.shuffleHand();
        int i = 0;
        for (i = 0; i < super.getNumberOfCardsInHand(); i++) {
            Card cardToPlay = super.getCard(i);
            if (super.canCardBePlayed(cardToPlay, cardOnTopOfPile)) {
                // Log which card has been played
//                System.out.println("Computer's current hand:");
//                for (int j = 0; j < super.getNumberOfCardsInHand(); j++) {
//                    System.out.println(j + ": " + super.printCardInHand(j));
//                }
                System.out.print("The Computer has played: ");
                System.out.println(super.printCardInHand(i));
                super.playCard(i);
                System.out.println("There are " + super.getNumberOfCardsInHand() + " cards left in the Computer's hand. \n");
                return cardToPlay;
            }
        }
        System.out.println("The Computer just picked up a card \n");
        return null;
    }

}