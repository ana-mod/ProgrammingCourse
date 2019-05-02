package deck;

public class Card implements Comparable<Card>{
	
	String number;
	Color color;
	
	public Card(String kinds, Color color){
	
		this.number = kinds;
		this.color = color;
		
	}
	
	@Override
	public String toString(){
		return number+" "+color;
	}

	@Override
	public int compareTo(Card card) {
		// TODO Auto-generated method stub
				
		int porownaneNumery = number.compareTo(card.number);
		if (porownaneNumery == 0) return color.compareTo(card.color);
		return porownaneNumery;
	}
	
	
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + n;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
*/
	@Override
	public boolean equals(Object cd) {
		if ( ((Card)cd).number.equals(this.number) &&  ((Card)cd).color==this.color ) return true;
		return false;
	}


}
