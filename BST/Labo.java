
public class Labo {

	public int prime (int n) {
		
		if (n<=2) return 0;
	
			boolean primes[] = new boolean[n+1];
			
			for (int i=2; i<=n; i++) primes[i]=true;
			
			for (int i=2; i<=n; i++) {
				if(primes[i]) {
					for (int j=i+i; j<=n; j=j+i) primes[j] = false;
				}
			}
			
		int solution = 0;
		for (int i=0; i<=n; i++) {
			if(primes[i]) {
				if (i%10==3) solution = i;
			}
		}
		return solution;
		
	}
		
	public int prime2 (int n) {
		
			
			if (n<=2) return 0;
		
				boolean primes[] = new boolean[n+1];
				
				for (int i=2; i<=n; i++) primes[i]=true;
				
				for (int i=2; i<=n; i++) {
					if(primes[i]) {
						for (int j=i+i; j<=n; j=j+i) primes[j] = false;
					}
				}
				
			for (int i=n; i>0; i--) {
				if (primes[i]) {
					if (i%10==3) return i;
				}
			}


			return 0;

	}
	
	public static void main (String []args){
		Labo n = new Labo();
		System.out.println(n.prime(236642));
		System.out.println(n.prime2(236642));
	}
	
}
