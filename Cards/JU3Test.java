package deck;

import junit.framework.TestCase;

public class JU3Test extends TestCase {

	Deck deck = null;
	Deck tmp = null;
	
	public void setUp(){
		deck = new Deck(HowMany.from_nines);
		tmp = new Deck(HowMany.from_nines);
	}

	public void testIsUpperCardMethodCorrect () throws Exception {
		Deck d1 = new Deck (HowMany.full);
		Card c1 = d1.upperCard();
		Card c2 = d1.cards.get(d1.cards.size() - 1);
		assertTrue(c1.equals(c2));
	}

	public void testIsUpperCardDifferentThanASpade() throws Exception{
		assertEquals(new Card("A", Color.spade),deck.upperCard());
	}
	
	public void test() throws Exception {
		assertNotNull(deck);
	}
	
	public void testIsCardsCountEqualToExpected(){
		assertSame(24, deck.cards.size());
	}
	
	public void testIsSortingCorrect() throws Exception {
		tmp.sortCards();
		deck.sortCards();
		assertEquals(tmp.cards.get(5), deck.cards.get(5));
		assertEquals(tmp.cards.get(23), deck.cards.get(23));
	}

	public void testIsShufflingCorrect() throws Exception {
		tmp.shuffleCards();
		assertFalse(deck.cards.get(0).equals(tmp.cards.get(0)));
	}

	public void tearDown() {
		deck = null;
		tmp = null;
	}
}
