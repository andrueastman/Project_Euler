import java.util.Arrays;

public class Problem76{//dynamic programming solution :)
	public static int ways=0;
	public static void main(String[] args) {
		int[] length = new int[100];
		for(int i=0;i<length.length;i++){//populate the array with possible values i.e 1 to 100
			length[i]=i+1;
		}
		
		int target = 100;
		int[] ways = new int[target+1];
		ways[0] = 1;
		 
		for (int i = 0; i < length.length; i++) {
		    for (int j = length[i]; j <= target; j++) {
		        ways[j] += ways[j - length[i]];//cool stuff!!
		    }
		}
		System.out.println(ways[target]-1);//subract one to remove the solution that is not a sum
	}

}