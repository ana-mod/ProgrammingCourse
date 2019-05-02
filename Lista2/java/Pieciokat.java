public class Pieciokat extends Figura 
{
    public Pieciokat(double a)
    {
        pole = (5*(a*a) * (1/Math.tan(Math.PI/5)) )/4;
        obwod = 5*a;
    }
}
