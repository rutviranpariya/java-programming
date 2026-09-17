public class practical3_2 {
    public static void main(String[] args) {

        Card[] cards = new Card[5];
        int count = 0;

        Card[] input = {
            new Card("Queen", "Hearts"),
            new Card("King", "Spades"),
            new Card("Ace", "Clubs"),
            new Card("Queen", "Hearts"),
            new Card("Jack", "Diamonds")
        };

        for (Card newCard : input) {

            boolean duplicate = false;

            for (int i = 0; i < count; i++) {
                if (newCard.equals(cards[i])) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("Duplicate found: " + newCard);
                break;
            }

            cards[count] = newCard;
            count++;
        }
    }
}