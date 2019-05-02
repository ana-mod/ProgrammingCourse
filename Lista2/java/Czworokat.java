import static java.lang.Math.*;

public abstract class Czworokat extends Figura {

    public void liczPole(double a, double b, double kat)
    {
        if(kat <=0 || kat==180) {pole= -1; return;} //jesli nieprawidlowy kat
        pole=(a*b) * (sin(kat));
    }

    public void liczObwod(double a, double b) 
    {
        obwod= (2*a + 2*b);
    }
}
