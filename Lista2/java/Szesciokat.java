public class Szesciokat extends Figura 
{
    public Szesciokat(double a)
	{
        pole = (6*(a*a) * (1/Math.tan(Math.PI/6)) )/4;
        obwod = 6*a;
    }
}
