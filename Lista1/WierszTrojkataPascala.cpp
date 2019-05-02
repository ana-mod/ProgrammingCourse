#include <iostream>
#include <stdexcept>
#include <string>
using namespace std;

class WierszTrojkataPascala {
	
	int *wiersz;

	public:

	WierszTrojkataPascala (int n) {
	
		wiersz = new int[n+1];
		for (int i=0; i<n+1; i++) wiersz[i]=0;

		wiersz[0]=1;
			
			for (int i=0; i<n; i++)
			{
				for (int j=i+1; j>0; j--)
				{ 
					wiersz[j] = wiersz[j] + wiersz[j-1];
				}

			} 		
	}

	int wspolczynnik (int m) {

		return wiersz[m];
	}

	~WierszTrojkataPascala() {
	
		delete[] wiersz;
	}
};

void main (int argc, char* argv[]) {
	
	if (argc==1) {cout << "Brak danych" << endl; exit(-1);}
	
	int n=0;

	try 
	{
		n=stoi(argv[1]);
		if (n<0 || n>33) { cout << argv[1] << ": zly numer wiersza, wykracza poza zakres." << endl; exit(-1); }
	
	}
	catch (const invalid_argument& ia)
	{	
		cout << argv[1] << ": zly numer wiersza, nie jest liczba calkowita." << endl;
		exit(-1);
	}
	
	WierszTrojkataPascala wtp (n);
	
	int m=0;
	
	for(int i=2; i<argc; i++)
		
	try 
	{
		m=stoi(argv[i]);
		
		if(m<0 || m>n) {cout << argv[i] << "zle" << endl; continue;}

		cout << argv[i] << ": " << wtp.wspolczynnik(m) << endl;

	}
	
	catch (const invalid_argument& ia) 
	{ 
		cout << argv[i] << " nie jest liczba calkowita" << endl;
	}
}