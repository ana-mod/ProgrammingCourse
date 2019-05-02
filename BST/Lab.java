// napisac funkcje ktora dla n zwroci liczbe nieparzystych liczb zlozonych z przedzialu (1,n) 
public class Lab {

	public static int method (int n) {
		
		if (n<=2) return 0;
		
		boolean [] composite = new boolean[n];
		for (int i=2; i<n; i++) composite[i] = false;
		
		
		for (int i=3; i<Math.sqrt(n); i=i+2) {
			if (!composite[i]) {
				for (int j=i+i+i; j<n; j=j+i+i) composite[j]=true;
			}
		}
		
		int count = 0;
		for (int i=2; i<n; i++)
		{
			if(composite[i]) count++;
		}
		
		return count;
	}
	
	public static void main(String[]args){
		
		Lab n = new Lab();
		int number = 17;
		System.out.println(method(number));
		
		System.out.println(n.method(236642));
		
	}
	
}
