package deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	ArrayList <Card> cards = new ArrayList<Card>();
	String [] kinds = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	
	public Deck (HowMany howmany){
	
		int n=0;
		
		switch (howmany) {
		case full: n=0;
		break;
		case from_nines: n=7;
		break;
		case from_sevens: n=5;
		break;
		}
		
		for (int i=n; i<kinds.length; i++)
		{
			for (Color color : Color.values())
			{
				Card card = new Card(kinds[i], color);
				cards.add(card);
			}
		}	
	}
	
	public void shuffleCards(){
		Collections.shuffle(cards);
	}
	
	public void sortCards(){
		Collections.sort(cards);
	}
	
	public Card upperCard() {
		if (cards.size()==0) 
		{
			return null;
		}		
		return cards.get((cards.size()-1));
	}

	
}
