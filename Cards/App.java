package deck;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deck deck = new Deck(HowMany.full);
		
		deck.shuffleCards();
		deck.sortCards();
		System.out.println(deck.upperCard());
		for (Card card: deck.cards)
		{
			System.out.println(card);	
		}
	}

}
