#include <iostream>
#include <stdexcept>
#include <string>
#include <vector>
#include "Figury.h"

using namespace std;

    int main(int argc, char* argv[]) {

		vector <Figura> figury;

        if (argc==1) {cout << "Brak danych" << endl; exit(-1);} 

		string litery = argv[1];
		
		int lp = 0; //liczba parametrow
		
		for (int l=0; l<litery.size(); l++)
		{
			if (argv[1][l]=='c') lp=lp+5; // czworokaty maja 5 parametrow
			else if (argv[1][l]=='o' || argv[1][l]=='p' || argv[1][l]=='s') lp=lp+1; // okrag, pieciokat, szesciokat po jednym
			else {cout << argv[1][l] << ": zle oznaczenie figury" << endl; break;} 
		}
		
		if (lp!=(argc-2)) {cout << "Bledna ilosc parametrow" << endl; exit(-1);}

        int j = 0; 
        int i = 2; 
		
        while(j<litery.size()){

            switch (argv[1][j])
			{
                case 'c':
				{
					double bok1 = 0;
					double bok2 = 0;
					double kat = 0;
					bool check=true;
					for (int k=0; k<5; k++)
					{
						try {double m = stod(argv[i+k]); if (m<0) {cout << m <<  ": musi byc liczba nieujemna" << endl; i=i+5; check=false; break;}}
						catch (const invalid_argument& ia) { cout << argv[i+k] << ": musi byc liczba" << endl; i=i+5; check=false; break;}
					}
					if (!check) break;
					if (strcmp(argv[i],argv[i+1])==0 && strcmp(argv[i+2],argv[i+3])==0) // jesli parametry sa postaci aabb
					{
						bok1=stod(argv[i]);
						bok2=stod(argv[i+2]);
					}
					else if ((strcmp(argv[i],argv[i+2])==0 && strcmp(argv[i+1],argv[i+3])==0) || (strcmp(argv[i],argv[i+3])==0&&strcmp(argv[i+1],argv[i+2])==0)) // jesli parametry sa postaci abab lub abba
					{
						bok1=stod(argv[i]);
						bok2=stod(argv[i+1]);
					}
					else 
					{
						cout << "Bledne dane, mozliwe czworokaty to romb, prostokat, kwadrat." << endl;
						i=i+5;
						break;
					}
					
					kat=stod(argv[i+4]);
					if (kat>=180) {cout << kat << ": miara kata nie moze przekraczac 180 stopni" << endl;}
					
					if (kat!=90 && bok1==bok2) 
					{
						Romb r (bok1, bok2, kat);
						figury.push_back(r);
					}
					else if (kat==90 && bok1==bok2) 
					{
						Kwadrat k (bok1);
						figury.push_back(k);
					}
					else if (kat==90 && bok1!=bok2)
					{
						Prostokat pr (bok1, bok2);
						figury.push_back(pr);
					}
						else 
					{
						cout << "Bledne dane, mozliwe czworokaty to romb, prostokat, kwadrat." << endl; //jesli rownoleglobok
						i=i+5;
						break;
					}
					
					i=i+5;
					break;
				}

                case 'o':
				{
                    double r =0;
                    try{r = stod(argv[i]);}
                    catch (const invalid_argument& ia) { cout << argv[i] << ": dlugosc boku musi byc liczba" << endl; i++; break;}
                    if(r<0) {cout << r << ": dlugosc boku nie moze byc ujemna" << endl; i++; break;}
                    Okrag o (r);
                    figury.push_back(o);
                    i++;
                    break;
				}
				
                case 'p':
				{
                    double a =0;
                    try{a = stod(argv[i]);}
                    catch (const invalid_argument& ia) { cout << argv[i] << ": dlugosc boku musi byc liczba" << endl; i++; break;}
                    if(a<0) {cout << a << ": dlugosc boku nie moze byc ujemna" << endl; i++; break;}
                    Pieciokat p (a);
                    figury.push_back(p);
                    i++;
                    break;
				}
				
                case 's':
                {
					double b =0;
                    try{b = stod(argv[i]);}
                    catch (const invalid_argument& ia) { cout << ": dlugosc boku musi byc liczba" << endl; i++; break;}
                    if(b<0) {cout << b << ": dlugosc boku nie moze byc ujemna" << endl; i++; break;}
                    Szesciokat s (b);
                    figury.push_back(s);
                    i++;
                    break;
				}
            }
            j++;

        }

        for(int k=0; k<figury.size(); k++){ //wyswietlanie wynikow
            cout << argv[1][k] << ": pole wynosi " << figury[k].pole << ", obwod wynosi " << figury[k].obwod << endl;
        }
		
		return 0;
		
	}
