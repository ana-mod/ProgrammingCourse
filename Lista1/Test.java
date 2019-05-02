public class Test {
	
	public static void main (String [] args) {
				
		if (args.length==0) {System.out.println("Brak danych"); System.exit(-1);}

		int n=0;
		
		try 
		{	n = Integer.parseInt(args[0]);
		
			if (n<0 || n>33)
			{
				System.out.println(args[0] + ": zly numer wiersza, wykracza poza zakres.");
				System.exit(-1);
			}		
		}
		catch (NumberFormatException ex)
		{	
			System.out.println(args[0] + " nie jest liczba calkowita");
			System.exit(-1);
		}

		WierszTrojkataPascala wtp = new WierszTrojkataPascala(n);
		
		int m;
		
		for (int i=1; i<args.length; i++)
			
		try 
		{
			m = Integer.parseInt(args[i]);
		
			if (m<0 || m>n) 
			{
				System.out.println(args[i] + ": zly numer miejsca, wykracza poza zakres");
				continue;
			}
		
			System.out.println(args[i] + ": " + wtp.wspolczynnik(m));
		}
		
		
		
		catch (NumberFormatException ex) 
		{
			System.out.println(args[i] + " nie jest liczba calkowita");
		}
				
	}
}