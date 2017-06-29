public class Problem69{

	public static int fi(int n, double currentLowest) {          
		int result = n;
		int original = n;
		double comparison;          
		for(int i=2;i*i <= n;i++) {            
			if (n % i == 0) result -= result / i;            
			while (n % i == 0) n /= i;
			         
		}          
		if (n > 1) result -= result / n; 

		comparison=(double)original/result; 
		if(comparison < currentLowest){

			return 1;//we don't need to continue since
		}
		return result;        
	}

	public static void main(String args[]){
		double currentLowest = 1.0;
		int result = 1;
		for(int i=0;i<1000000;i++){
			int x=Problem69.fi(i,currentLowest);
			if(x!=1){//function is lower
				double r=(double) i/x;
				currentLowest=r;
				result = i;	
			}
			
		}	
		System.out.println(result);
	}
}