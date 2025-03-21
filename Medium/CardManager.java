package Medium;
import java.util.*;

public class CardManager {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        CardCollection collection = new CardCollection();
        Scanner scanner = new Scanner(System.in);
        int choice;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                collection.addCard(new Card(rank, suit));
            }
        }

        do {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter card rank: ");
                    String rank = scanner.nextLine();
                    System.out.print("Enter card suit: ");
                    String suit = scanner.nextLine();
                    collection.addCard(new Card(rank, suit));
                    System.out.println("Card added successfully.");
                    break;
                case 2:
                    System.out.print("Enter suit to search: ");
                    suit = scanner.nextLine();
                    List<Card> cards = collection.getCardsBySuit(suit);
                    if (cards.isEmpty()) {
                        System.out.println("No cards found for suit: " + suit);
                    } else {
                        System.out.println("Cards of suit " + suit + ":");
                        for (Card card : cards) {
                            System.out.println("  " + card);
                        }
                    }
                    break;
                case 3:
                    collection.displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
