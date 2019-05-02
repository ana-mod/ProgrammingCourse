#include <math.h>
#define PI 3.14159265359
#define degree_to_radian 0.0174532925
class Figura {
	public:
		virtual ~Figura(){}
		double pole;
		double obwod;
};

class Czworokat : public Figura {
public:
    virtual void liczPole(double a, double b, double kat)
    {
        pole = (a*b*sin(kat));
    }

    virtual void liczObwod(double a, double b) 
    {
        obwod = (2*(a+b));
    }
};

class Kwadrat : public Czworokat {
public:
    Kwadrat(double a)
	{
        liczPole(a,a,((PI)/2)); // pole kwadratu
        liczObwod(a,a); //boki tej samej dlugosci
    }
};

class Prostokat : public Czworokat {
public :
	Prostokat(double a, double b)
	{
        liczPole(a,b,(PI/2));
        liczObwod(a,b);
    }
};

class Romb : public Czworokat {
public :
	Romb(double a, double b, double kat)
	{
        liczPole(a,a,(kat*degree_to_radian));
        liczObwod(a,b);
    }
};

class Okrag : public Figura {
public :
   Okrag(double prom){
       pole = PI * prom * prom;
       obwod = 2 * PI * prom;
   }
};

class Pieciokat : public Figura 
{
    public :
	Pieciokat(double a)
    {
        pole = (5*a*a*(1/tan(PI/5)))/4;
        obwod = 5*a;
    }
};

class Szesciokat : public Figura 
{
    public :
	Szesciokat(double a)
	{
        pole = (6*a*a*(1/tan(PI/6)))/4;
        obwod = 6*a;
    }
};
