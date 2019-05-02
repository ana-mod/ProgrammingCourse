package deck;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JU4Test {

	Deck deck = null;
	
	@Before
	public void setUp() throws Exception {
		deck = new Deck (HowMany.full);
	}

	@After
	public void tearDown() throws Exception {
		deck = null;
	}

	@Test
	public void testIsDeckCreated() {
		assertNotNull(deck);
	}
	
	@Test(timeout = 10)
	public void testIsDeckCreatedInExpectedTime(){
		assertNotNull(deck);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIsCardsCountCorrect(){
		deck.cards.get(52);
	}
	
	@Ignore
	public void testIgnored(){
		assertNull(deck);
	}

}
