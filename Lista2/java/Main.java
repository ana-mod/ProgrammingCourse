import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Figura> figury = new ArrayList<Figura>();

        if (args.length==0) {System.out.println ("Brak danych"); System.exit(-1);}

		int lp = 0; //liczba parametrow
		for (int l=0; l<args[0].length(); l++)
		{
			if (args[0].charAt(l)=='c') lp=lp+5; // czworokaty maja 5 parametrow
			else if (args[0].charAt(l)=='o' || args[0].charAt(l)=='p' || args[0].charAt(l)=='s') lp=lp+1; // okrag, pieciokat, szesciokat po jednym
			else {System.out.println (args[0].charAt(l) + ": zle oznaczenie figury"); break;} 
		}
		
		if (lp!=(args.length-1)) {System.out.println ("Bledna ilosc parametrow"); System.exit(-1);}

        int j = 0; 
        int i = 1; 

        while(j<args[0].length()){

            switch (args[0].charAt(j))
			{
                case 'c':
					double bok1 = 0;
					double bok2 = 0;
					double kat = 0;
					boolean check=true;
					for (int k=0; k<5; k++)
					{
						try {double m = Double.parseDouble(args[i+k]); if (m<0) {System.out.println (m + ": dlugosc musi byc liczba nieujemna"); i=i+5; check=false; break;}}
						catch (NumberFormatException e) { System.out.println(args[i+k] + ": dlugosc musi byc liczba"); i=i+5; check=false; break;}
					}
					if (!check) break;
					if (args[i].equals(args[i+1]) && args[i+2].equals(args[i+3])) 
					{
						bok1=Double.parseDouble(args[i]);
						bok2=Double.parseDouble(args[i+2]);
					}
					else if ((args[i].equals(args[i+2]) && args[i+1].equals(args[i+3])) || (args[i].equals(args[i+3])&&args[i+1].equals(args[i+2]))) 
					{
						bok1=Double.parseDouble(args[i]);
						bok2=Double.parseDouble(args[i+1]);
					}
					else 
					{
						System.out.println ("Bledne dane, mozliwe czworokaty to romb, prostokat, kwadrat.");
						i=i+5;
						break;
					}
					
					kat=Double.parseDouble(args[i+4]);
					
					if (kat!=90 && bok1==bok2) 
					{
						double degree_to_radian = 0.0174532925;
						kat=kat*degree_to_radian;
						Romb r = new Romb(bok1, bok2, kat);
						figury.add(r);
					}
					else if (kat==90 && bok1==bok2) 
					{
						Kwadrat k = new Kwadrat(bok1);
						figury.add(k);
					}
					else if (kat==90 && bok1!=bok2)
					{
						Prostokat pr = new Prostokat(bok1, bok2);
						figury.add(pr);
					}
						else 
					{
						System.out.println("Zle dane"); 
						i=i+5;
						break;
					}
					
					i=i+5;
					break;

                case 'o':
                    double r =0;
                    try{r = Double.parseDouble(args[i]);}
                    catch (NumberFormatException e) { System.out.println(args[i] + ": dlugosc boku musi byc liczba"); i++; break;}
                    if(r<0) {System.out.println(r + ": dlugosc boku nie moze byc ujemna"); i++; break;}
                    Okrag o = new Okrag(r);
                    figury.add(o);
                    i++;
                    break;

                case 'p':
                    double a =0;
                    try{a = Double.parseDouble(args[i]);}
                    catch (NumberFormatException e) { System.out.println(args[i] + ": dlugosc boku musi byc liczba"); i++; break;}
                    if(a<0) {System.out.println(a + ": dlugosc boku nie moze byc ujemna"); i++; break;}
                    Pieciokat p = new Pieciokat(a);
                    figury.add(p);
                    i++;
                    break;

                case 's':
                    double b =0;
                    try{b = Double.parseDouble(args[i]);}
                    catch (NumberFormatException e) { System.out.println(": dlugosc boku musi byc liczba"); i++; break;}
                    if(b<0) {System.out.println(b + ": dlugosc boku nie moze byc ujemna"); i++; break;}
                    Szesciokat s = new Szesciokat(b);
                    figury.add(s);
                    i++;
                    break;
            }
            j++;

        }

        for(int k=0; k<figury.size(); k++){ //wyswietlanie wynikow
            System.out.println(args[0].charAt(k) + ": pole wynosi " + figury.get(k).pole + ", obwod wynosi " + figury.get(k).obwod );
        }
    }

}
