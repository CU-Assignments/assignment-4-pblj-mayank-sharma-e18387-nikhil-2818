package Medium;
import java.util.*;

public class CardCollection {
    private Map<String, List<Card>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }
    public void addCard(Card card) {
        cardMap.computeIfAbsent(card.getSuit(), k -> new ArrayList<>()).add(card);
    }
    public List<Card> getCardsBySuit(String suit) {
        return cardMap.getOrDefault(suit, new ArrayList<>());
    }
    public void displayAllCards() {
        for (Map.Entry<String, List<Card>> entry : cardMap.entrySet()) {
            System.out.println("Suit: " + entry.getKey());
            for (Card card : entry.getValue()) {
                System.out.println("  " + card);
            }
        }
    }
}
