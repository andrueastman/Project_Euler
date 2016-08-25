public class Problem58{

	public static boolean isPrime(int a){
		if(a == 2) 
			return true;
		if(a <= 1 || a % 2 == 0) 
			return false;
		long max = (long)Math.sqrt(a);
		for(long n = 3; n <= max; n += 2){
		    if(a % n == 0) 
		   		return false;
		}
		
		return true;
	}


	public static void main(String args[]){
		System.out.println("Problem 58");
		int boxsize=1;
		int num=1;
		int totalCornerSum=1;
		int totalPrimeCornerSum=0;
		for (;;boxsize++) {
			for (int j=0;j<4 ;j++ ) {
				num=num+(boxsize*2);
				//System.out.println(num);
				totalCornerSum++;
				if(isPrime(num)){
					totalPrimeCornerSum++;
				}	
			}
			double ratio= (double)totalPrimeCornerSum*100.0/totalCornerSum;
			//System.out.println(ratio);
			if(ratio<10.0){
				break;	
			}
		}

		System.out.println("Box Size "+((boxsize*2)+1));
		
		System.out.println("Total corner Numbers"+totalCornerSum);
		System.out.println("Total primes "+totalPrimeCornerSum);
	}
}